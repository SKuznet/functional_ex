package lesson6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/*
*Главные проблемы в работе с датой и временем версий Java 7 и ниже:

    Классы Java Date Time раскиданы по пакетам. Так, класс Date Class есть как в пакете java.util, так и
     в java.sql пакете. Классы для форматирования и парсинга определены в java.text пакете.
    Пакет java.util.Date содержит как дату, так и время, в то время как java.sql.Date содержит только дату.
    По моему, оба класса не очень хорошо спроектированы.
    Все классы для работы с датой могут изменяться, поэтому они не потокобезопасны.
    Это одна из самых больших проблем в Date и Calendar классах.
    Класс Date не обеспечивает интернационализацию, не поддерживает часовые пояса.
    Поэтому были введены классы java.util.Calendar и java.util.TimeZone, но опять-таки,
    они имеют все перечисленные выше проблемы.

    Yoda time
* */
public class Main {

}


/*
 * java.time.LocalDate — неизменяемый класс, который представляет объекты Date в формате по умолчанию yyyy-MM-dd.
 * Мы можем использовать метод now(), чтобы получить текущую дату. Мы также можем предоставить в качестве аргументов год,
 * месяц и день, чтобы создать экземпляр LocalDate. Этот класс предоставляет перегруженный метод now(),
 * которому мы можем предоставить ZoneId для получения даты в конкретном часовом поясе.
 * Этот класс предоставляет такую ​​же функциональность как java.sql.Date.
 * */
class LocalDateEx {
    public static void main(String[] args) {
        // current date
        LocalDate today = LocalDate.now();

        System.out.println("Now is: " + today);

        LocalDate specificDate = LocalDate.of(2017, Month.APRIL, 30);
        System.out.println("Specific date with year and month and day: " + specificDate);

        //А теперь попробуем хитрость. Укажем дату с ошибкой
        //LocalDate invDate = LocalDate.of(2014, Month.JULY, 33);
        //Но получим исключение java.time.DateTimeException:
        //Invalid value for DayOfMonth (valid values 1 - 28/31): 33

        //Получаем дату, например с 01.01.1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("Дата с начала отсчета времени : " + dateFromBase);

        LocalDate day256_2017 = LocalDate.ofYearDay(2014, 256);
        System.out.println("256 день 2017 : " + day256_2017);
    }
}

/*
 * Класс LocalTime является неизменяемым и представляет собой время в читабельном виде.
 * По умолчанию он предоставляет формат hh:mm:ss.zzz. Так же, как и LocalDate, этот класс обеспечивает поддержку
 * часовых поясов и создание даты, передавая в качестве аргументов часы, минуты и секунды.
 * */
class LocalTimeEx {
    public static void main(String[] args) {

        // Получаем текущее время
        LocalTime time = LocalTime.now();
        System.out.println("Получаем текущее время : " + time);

        //Создаем LocalTime с использование своих данных в качестве параметров
        LocalTime specificTime = LocalTime.of(23, 15, 11, 22);
        System.out.println("Какое-то время дня : " + specificTime);

        //Получаем дату через 2000 секунд после 01.01.1970
        LocalTime sec2000 = LocalTime.ofSecondOfDay(10000);
        System.out.println("Через 2000 секунд после 01.01.1970 : " + sec2000);
    }
}

/*
 * Класс java.time.LocalDateTime — представляет собой дату и время в формате по умолчанию: yyyy-MM-dd-HH-mm-ss.zzz.
 * Чтобы создать экземпляр LocalDateTime есть метод, который принимает LocalDate и LocalTime в качестве входных аргументов.
 * */
class LocalDateTimeEx {
    public static void main(String[] args) {
        // Получаем текущее время
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Получаем текущее время : " + today);

        //Создаем новую дату с помощью LocalDate и LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("DateTime : " + today);

        //Создаем LocalDateTime передавая в качестве аргументов
        //год, месяц, день, час, минуту, сукенду
        LocalDateTime randDate = LocalDateTime.of(2017, Month.JULY, 9, 11, 6, 22);
        System.out.println("LocalDateTime с указанной датой : " + randDate);

        //Получаем дату через 2000 секунд после 01.01.1970
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(2000, 0, ZoneOffset.UTC);
        System.out.println("Через 2000 секунд после 01.01.1970 : " + dateFromBase);
    }
}

/* Класс Instant используется для работы с машиночитаемым форматом времени —
 он сохраняет дату и время в так называемый «unix timestamp (отметку времени)».
 */
class InstantEx {
    public static void main(String[] args) {
        //Текущая отметка времени
        Instant timestamp = Instant.now();
        System.out.println("Текущая отметка времени : "+timestamp);

        //Instant для timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Instant для timestamp : " + specificTime);

        //Пример использования Duration
        Duration sixtyDay = Duration.ofDays(60);
        System.out.println(sixtyDay);
    }
}

class DateApiEx {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        //Получаем год, проверям его на высокосность
        System.out.println("Год " + today.getYear() + " - высокосный? : " + today.isLeapYear());

        //Сравниваем два LocalDate: до и после
        System.out.println("Сегодня — это до 02.03.2017? : " + today.isBefore(LocalDate.of(2017,3,2)));

        //Создаем LocalDateTime с LocalDate
        System.out.println("Текущее время : " + today.atTime(LocalTime.now()));

        //Операции + и - с датами
        System.out.println("9 дней после сегодняшнего дня будет: " + today.plusDays(9));
        System.out.println("3 недели после сегодняшнего дня будет: " + today.plusWeeks(3));
        System.out.println("20 месяцев после сегодняшнего дня будет: " + today.plusMonths(20));

        System.out.println("9 дней до сегодняшнего дня будет: " + today.minusDays(9));
        System.out.println("3 недели до сегодняшнего дня будет: " + today.minusWeeks(3));
        System.out.println("20 месяцев до сегодняшнего дня будет: " + today.minusMonths(20));

        // А теперь поиграемся с датой
        System.out.println("Первый день этого месяца : " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Последний день этой года : " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Находим время между жвумя датами : "+period);
        System.out.println("В этом году осталось " + period.getMonths() + " месяц(ев)");
    }
}

class DateParseEx {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        // стандартный формат даты
        System.out.println("стандартный формат даты для LocalDate : " + date);
        // приименяем свой формат даты
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));


        LocalDateTime dateTime = LocalDateTime.now();
        //стандартный формат даты
        System.out.println("стандартный формат даты LocalDateTime : " + dateTime);
        //приименяем свой формат даты
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        //стандартный формат даты
        System.out.println("стандартный формат : " + timestamp);
    }
}
