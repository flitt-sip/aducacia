package by.flitt.pups.model.dao;

import by.flitt.pups.model.Pup;
import by.flitt.pups.model.PupCity;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.*;
import java.util.List;
import java.util.Objects;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DaoFactory {

    private static final Logger logger = LoggerFactory.getLogger(DaoFactory.class);

    public static PupDao loadXlsx(InputStream xlsxStream) throws IOException {
        Objects.requireNonNull(xlsxStream);

        final Instant validSince = LocalDateTime
                .of(2021, Month.MAY.getValue(), 4, 11, 49, 18)
                .toInstant(ZoneOffset.UTC);

        Workbook workbook = new XSSFWorkbook(xlsxStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row header = sheet.getRow(0);
        AtomicInteger counter = new AtomicInteger();
        List<String> heads = StreamSupport.stream(header.spliterator(), false)
                .map(Cell::getStringCellValue)
                .map(v -> counter.getAndIncrement() + "." + v)
                .collect(Collectors.toList());

        logger.debug("header loaded: {}", heads);

        List<Pup> pups = StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(sheet.rowIterator(), 0), false)
                .skip(1)
                .map(row -> Pup.builder()
                        .setTimestamp(getInstant(row, 0))
                        .setParentName(getString(row, 1))
                        .setPupName(getString(row, 2))
                        .setPhoneNumber(getPhone(row, 3))
                        .setCity(makeCity(getString(row, 4)))
                        .setPreferredPlace(getString(row, 5))
                        .setGovEducationPros(getString(row, 6))
                        .setGovEducationCons(getString(row, 7))
                        .setTeacherWanted(getString(row, 8))
                        .setTeacherIdeal(getString(row, 9))
                        .setReadyForSelfInvest(getString(row, 10))
                        .setPupPortrait(getString(row, 11))
                        .setWhyNeedTeacher(getString(row, 12))
                        .setWhatIsImportant(getString(row, 13))
                        .build())
                .peek(pup -> logger.debug("pup parsed: {}", pup))
                .filter(pup -> pup.getTimestamp().isAfter(validSince))
                .collect(Collectors.toList());

        return new ListPupDao(pups);
    }

    private static Instant getInstant(Row row, int i) {
        return Instant.ofEpochMilli(row.getCell(i).getDateCellValue().getTime());
    }

    private static String getString(Row row, int i) {
        return row.getCell(i).getStringCellValue().trim();
    }

    private static String getPhone(Row row, int i) {
        return getString(row, i).replaceAll("\\s", "");
    }

    @SuppressWarnings("UnstableApiUsage")
    private static PupCity makeCity(String city) {
        String name = normalizeCityName(city);
        return new PupCity(Hashing.murmur3_128().hashString(name, Charsets.UTF_8).toString(), name);
    }

    private static String normalizeCityName(String city) {
        String tmp = city.toLowerCase();
        String prefix = "г.";
        int idx = tmp.indexOf(prefix);
        if (idx != -1) {
            city = city.substring(idx + prefix.length());
        }
        city = city.trim();

        return city.substring(0, 1).toUpperCase() + city.substring(1);
    }
}
