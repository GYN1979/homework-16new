package transport;

import java.time.LocalDate;

public class car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String gears;
    private final String typeOfBody;
    private String regNumber;
    private final int seatsCount;
    private boolean summerTypes;
    private Key key;
    private Insurance insurance;


    public car
            (String brand,
             String model,
             double engineVolume,
             String color,
             int year,
             String country,
             String gears,
             String typeOfBody,
             String regNumber,
             int seatsCount,
             boolean summerTypes,
             Key key,
             Insurance insurance
            ) {
        if (brand == null) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (country == null) {
            this.country = "default";
        } else {
            this.country = country;
        }
        if (color == null) {
            this.color = "white";
        } else {
            this.color = color;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (gears == null) {
            this.gears = "МКПП";
        } else {
            this.gears = gears;
        }
        if (regNumber == null) {
            this.regNumber = "х000хх000";
        } else {
            this.regNumber = regNumber;
        }
        if (typeOfBody == null) {
            this.typeOfBody = "седан";
        } else {
            this.typeOfBody = typeOfBody;
        }
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
        this.year = year;
        this.seatsCount = seatsCount;
        this.summerTypes = summerTypes;
    }


    public car(String brand,
               String model,
               double engineVolume,
               String color,
               int year,
               String country) {

        this(
                brand,
                model,
                engineVolume,
                color,
                year,
                country,
                "МКПП",
                "седан",
                "х000хх000",
                5,
                true,
                new Key(),
                new Insurance()
        );
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGears() {
        return gears;
    }

    public void setGears(String gears) {
        if (gears == null) {
            this.gears = "МКПП";
        } else {
            this.gears = gears;
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null) {
            this.regNumber = "х000хх000";
        } else {
            this.regNumber = regNumber;
        }
    }

    public boolean isSummerTypes() {
        return summerTypes;
    }

    public void setSummerTypes(boolean summerTypes) {
        this.summerTypes = summerTypes;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void changeTyres() {
        summerTypes = !summerTypes;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isCorrectRegNumber() {
        // х000хх000
        if (regNumber.length() != 9) {
            return false;
        }
        char[] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) &&
                Character.isDigit(chars[3]) && Character.isDigit(chars[6]) &&
                Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }

    public static class Key {
        private final boolean remoteRunEngine;
        private final boolean withoutKeyAccess;

        public Key(boolean remoteRunEngine, boolean withoutKeyAccess) {
            this.remoteRunEngine = remoteRunEngine;
            this.withoutKeyAccess = withoutKeyAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteRunEngine() {
            return remoteRunEngine;
        }

        public boolean isWithoutKeyAccess() {
            return withoutKeyAccess;
        }
    }

    public static class Insurance {


        private final LocalDate expirDate;
        private final double cost;
        private final String number;

        public Insurance(LocalDate expirDate, double cost, String number) {
            if (expirDate == null) {
                this.expirDate = LocalDate.now().plusDays(365);
            } else {
                this.expirDate = expirDate;
            }
            this.cost = cost;

            if (number == null) {
                this.number = "123456789";
            } else {
                this.number = number;
            }
        }

        public Insurance(){
            this(null,10000,null);
        }
        public LocalDate getExpirDate() {
            return expirDate;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public void checkExpirDate() {
            if (expirDate.isBefore(LocalDate.now()) || expirDate.isEqual(LocalDate.now())) {
                System.out.println("Нужно срочно получить страховку");
            }
        }

        public void checkNumber() {
            if (number.length() != 9) {
                System.out.println("Номер страховки некорретный");
            }
        }
    }
}
