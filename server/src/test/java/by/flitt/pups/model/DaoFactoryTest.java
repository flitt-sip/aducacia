package by.flitt.pups.model;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.flitt.pups.model.dao.DaoFactory;
import by.flitt.pups.model.dao.PupDao;

class DaoFactoryTest {

  private static final Logger logger = LoggerFactory.getLogger(DaoFactoryTest.class);

  @Test
  void testXlsx() throws IOException {
    PupDao doa = DaoFactory.loadXlsx(getClass().getResourceAsStream("/assets/data.xlsx"));

    logger.info("cities:  {}", doa.getCities());
  }
}