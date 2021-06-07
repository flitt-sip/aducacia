package by.flitt.pups.model;

import com.google.common.base.MoreObjects;

import java.time.Instant;
import java.util.Objects;

public class Pup {

    private final Instant timestamp;
    private final String pupName;
    private final String parentName;
    private final String pupPortrait;
    private final String phoneNumber;
    private final PupCity city;
    private final String preferredPlace;
    private final String govEducationPros;
    private final String govEducationCons;
    private final String teacherWanted;
    private final String teacherIdeal;
    private final String readyForSelfInvest;
    private final String whyNeedTeacher;
    private final String whatIsImportant;

    private Pup(Builder builder) {
        this.timestamp = Objects.requireNonNull(builder.timestamp);
        this.pupName = Objects.requireNonNull(builder.pupName);
        this.parentName = Objects.requireNonNull(builder.parentName);
        this.pupPortrait = Objects.requireNonNull(builder.pupPortrait);
        this.phoneNumber = Objects.requireNonNull(builder.phoneNumber);
        this.city = Objects.requireNonNull(builder.city);
        this.preferredPlace = Objects.requireNonNull(builder.preferredPlace);
        this.govEducationPros = Objects.requireNonNull(builder.govEducationPros);
        this.govEducationCons = Objects.requireNonNull(builder.govEducationCons);
        this.teacherWanted = Objects.requireNonNull(builder.teacherWanted);
        this.teacherIdeal = Objects.requireNonNull(builder.teacherIdeal);
        this.readyForSelfInvest = Objects.requireNonNull(builder.readyForSelfInvest);
        this.whyNeedTeacher = Objects.requireNonNull(builder.whyNeedTeacher);
        this.whatIsImportant = Objects.requireNonNull(builder.whatIsImportant);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getPupName() {
        return pupName;
    }

    public String getPupPortrait() {
        return pupPortrait;
    }

    public String getParentName() {
        return parentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PupCity getCity() {
        return city;
    }

    public String getPreferredPlace() {
        return preferredPlace;
    }

    public String getGovEducationPros() {
        return govEducationPros;
    }

    public String getGovEducationCons() {
        return govEducationCons;
    }

    public String getTeacherWanted() {
        return teacherWanted;
    }

    public String getTeacherIdeal() {
        return teacherIdeal;
    }

    public String getReadyForSelfInvest() {
        return readyForSelfInvest;
    }

    public String getWhyNeedTeacher() {
        return whyNeedTeacher;
    }

    public String getWhatIsImportant() {
        return whatIsImportant;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timestamp", timestamp)
                .add("pupName", pupName)
                .add("parentName", parentName)
                .add("phoneNumber", phoneNumber)
                .add("city", city)
                .add("preferredPlace", preferredPlace)
                .add("pupPortrait", pupPortrait)
                .add("govEducationPros", govEducationPros)
                .add("govEducationCons", govEducationCons)
                .add("teacherWanted", teacherWanted)
                .add("teacherIdeal", teacherIdeal)
                .add("readyForSelfInvest", readyForSelfInvest)
                .add("whyNeedTeacher", whyNeedTeacher)
                .add("whatIsImportant", whatIsImportant)
                .toString();
    }

    public static class Builder {

        private Instant timestamp;
        private String pupName;
        private String parentName;
        private String phoneNumber;
        private PupCity city;
        private String preferredPlace;
        private String govEducationPros;
        private String govEducationCons;
        private String teacherWanted;
        private String teacherIdeal;
        private String pupPortrait;
        private String readyForSelfInvest;
        private String whyNeedTeacher;
        private String whatIsImportant;

        public Builder setTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setPupName(String pupName) {
            this.pupName = pupName;
            return this;
        }

        public Builder setPupPortrait(String pupPortrait) {
            this.pupPortrait = pupPortrait;
            return this;
        }

        public Builder setParentName(String parentName) {
            this.parentName = parentName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setCity(PupCity city) {
            this.city = city;
            return this;
        }

        public Builder setPreferredPlace(String preferredPlace) {
            this.preferredPlace = preferredPlace;
            return this;
        }

        public Builder setGovEducationPros(String govEducationPros) {
            this.govEducationPros = govEducationPros;
            return this;
        }

        public Builder setGovEducationCons(String govEducationCons) {
            this.govEducationCons = govEducationCons;
            return this;
        }

        public Builder setTeacherWanted(String teacherWanted) {
            this.teacherWanted = teacherWanted;
            return this;
        }

        public Builder setTeacherIdeal(String teacherIdeal) {
            this.teacherIdeal = teacherIdeal;
            return this;
        }

        public Builder setReadyForSelfInvest(String readyForSelfInvest) {
            this.readyForSelfInvest = readyForSelfInvest;
            return this;
        }

        public Builder setWhyNeedTeacher(String whyNeedTeacher) {
            this.whyNeedTeacher = whyNeedTeacher;
            return this;
        }

        public Builder setWhatIsImportant(String whatIsImportant) {
            this.whatIsImportant = whatIsImportant;
            return this;
        }

        public Pup build() {
            return new Pup(this);
        }
    }
}
