import transport.car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // задание
        System.out.println("Задание");
        car Lada = new car
                ("Lada", "Granta", 1.7, "желтый", 2015, "Россия");
        Lada.setRegNumber("в431пп199");
        System.out.println( Lada.isCorrectRegNumber());
        car Audi = new car
                ("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германия");
        Audi.setKey(new car.Key(true,true));
        car BMW = new car
                ("BMW", "Z8", 3.0 , "черный", 2021, "Германии");
        BMW.setSummerTypes(false);
        BMW.setInsurance(new car.Insurance(LocalDate.now(), 20000,"154882"));
        car Kia = new car
                ("Kia", "Sportage 4-го поколения", 2.4,"красный", 2018, "Южная Корея");
        car Hyundai = new car
                ("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");

        printInfo(Lada);
        printInfo(Audi);
        printInfo(BMW);
        printInfo(Kia);
        printInfo(Hyundai);
    }
    private static void printInfo (car car) {
        System.out.println(
                car.getBrand ()+ " " + car.getModel() +
                        ", год выпуска: "+ car.getYear()+
                        ", страна сборки: "+ car.getCountry()+
                        ", цвет кузова: "+ car.getColor()+
                        ", объем двигателя: "+ car.getEngineVolume()+
                        ", коробка передач: "+ car.getGears()+
                        ", тип кузова: "+ car.getTypeOfBody()+
                        ", рег. номер: "+ car.getRegNumber()+
                        ", кол-во мест: "+ car.getSeatsCount()+
                        ", "+ (car.isSummerTypes()? "летняя" : "зимняя") + "резина"+
                        ", "+ (car.getKey().isWithoutKeyAccess() ? "безключевой доступ" : "ключевой доступ") +
                        ", "+ (car.getKey().isRemoteRunEngine() ? "удаленный запуск" : "обычный запуск") +
                        ", номер страховки"+ car.getInsurance().getNumber() +
                        ", стоимость страховки"+ car.getInsurance().getCost() +
                        ", срок действия страховки"+ car.getInsurance().getExpirDate());

    }
}