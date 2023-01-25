import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание №12");
        checkLeapYear(1936);
        checkClientDeviceYear(0, 2025);
        calculateDeliveryDays(101);
    }

    /**
     * Метод принимает в качестве параметра год и проверяет является ли он високосным
     *
     * @param year проверяемый гол
     */
    public static void checkLeapYear(int year) {
        System.out.println("Task1:");
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0)) {
                isLeapYear = true;
            }
        }
        if (isLeapYear) {
            System.out.println(" " + year + " год - високосный год.");
        } else {
            System.out.println(" " + year + " год - невисокосный год.");
        }
    }

    /**
     * Метод в зависимости от года выпуска устройства вывод какую версию приложения нужно установить клиенту
     *
     * @param typeOs           Тип операционной системы (0-'IOS', 1-'Android')
     * @param clientDeviceYear Год выпуска устройства
     */
    public static void checkClientDeviceYear(int typeOs, int clientDeviceYear) {
        System.out.println("Task2:");
        if (typeOs < 0 || typeOs > 1) {
            throw new RuntimeException(" Ошибка! Введите '0' для выбора IOS или '1' для выбора Android!");
        }
        int currentYear = LocalDate.now().getYear();
        String os = typeOs == 0 ? "IOS" : "Android";
        if (clientDeviceYear < currentYear) {
            System.out.printf(" Установите облегченную версию приложения для %s по ссылке.\n", os);
        } else {
            System.out.printf(" Установите обычную версию приложения для %s по ссылке.\n", os);
        }
    }

    /**
     * Метод проверяет возможность доставки от офиса до клиента, учитывая расстояние
     *
     * @param deliveryDistance Дистанция до клиенты
     */
    public static void calculateDeliveryDays(int deliveryDistance) {
        System.out.println("Task3:");
        if (deliveryDistance <= 0) {
            throw new RuntimeException(" Проверьте правильность веденных данных!");
        }

        int deliveryDays = 0;
        if (deliveryDistance <= 20) {
            deliveryDays++;
        } else if (deliveryDistance <= 60) {
            deliveryDays += 2;
        } else if (deliveryDistance <= 100) {
            deliveryDays += 3;
        }

        if (deliveryDays == 0) {
            System.out.println(" Доставки нет.");
        } else {
            System.out.println(" Потребуется дней: " + deliveryDays + ".");
        }
    }
}