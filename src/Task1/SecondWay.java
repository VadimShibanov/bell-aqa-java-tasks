package Task1;

import java.util.*;

public class SecondWay {
    public static void main(String[] args) {
        List<Map<String, String>> employees = getListOfEmployees();

        System.out.println("=== МОЛОДЫЕ ===");
        List<Integer> youth = getPositionsOfYoungEmp(employees);
        printYoungEmp(youth, employees);


        System.out.println("=== РУБЛИ ===");
        List<Integer> empWithSalaryInRub = getPositionsOfEmpWithSalaryInRub(employees);
        printYoungEmp(empWithSalaryInRub, employees);

        System.out.println("=== СРЕДНИЙ ВОЗРАСТ ===");
        System.out.println(middleAgeOfEmps(employees).orElseThrow());
    }

    public static List<Map<String, String>> getListOfEmployees() {
        Map<String, String> employee1 = new HashMap<>();
        employee1.put("Имя", "Кирилл");
        employee1.put("Возраст", "26");
        employee1.put("Должность", "Middle java dev");
        employee1.put("Зарплата", "150000 руб");

        Map<String, String> employee2 = new HashMap<>();
        employee2.put("Имя", "Виталий");
        employee2.put("Возраст", "28");
        employee2.put("Должность", "Senior java automation QA");
        employee2.put("Зарплата", "2000$");

        Map<String, String> employee3 = new HashMap<>();
        employee3.put("Имя", "Александр");
        employee3.put("Возраст", "31");
        employee3.put("Должность", "junior functional tester");
        employee3.put("Зарплата", "50000 руб");

        Map<String, String> employee4 = new HashMap<>();
        employee4.put("Имя", "Дементий");
        employee4.put("Возраст", "35");
        employee4.put("Должность", "dev-ops");
        employee4.put("Зарплата", "1500$");

        return List.of(
                employee1,
                employee2,
                employee3,
                employee4);
    }

    public static List<Integer> getPositionsOfYoungEmp(List<Map<String, String>> employees) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            for (Map.Entry<String, String> entry : employees.get(i).entrySet()) {
                if (entry.getKey().equals("Возраст") && entry.getValue() != null) {
                    if (!entry.getValue().isBlank()) {
                        int integerValueOfAge = Integer.parseInt(entry.getValue());
                        if (integerValueOfAge < 30) {
                            numbers.add(i);
                        }
                    }
                }
            }
        }

        return numbers;
    }

    public static List<Integer> getPositionsOfEmpWithSalaryInRub(List<Map<String, String>> employees) {
        List<Integer> numbers = new ArrayList<>();

        outerLoop:
        for (int i = 0; i < employees.size(); i++) {
            middleLoop:
            for (Map.Entry<String, String> entry : employees.get(i).entrySet()) {
                if (entry.getKey().equals("Зарплата") && entry.getValue() != null) {
                    innerLoop:
                    for (char symbol : entry.getValue().toCharArray()) {
                        if (symbol == '$') {
                            continue outerLoop;
                        }
                    }
                }
            }
            numbers.add(i);
        }

        return numbers;
    }

    public static Optional<Double> middleAgeOfEmps(List<Map<String, String>> employees) {
        double age = 0;

        for (Map<String, String> employee : employees) {
            for (Map.Entry<String, String> entry : employee.entrySet()) {
                if (entry.getKey().equals("Возраст") && entry.getValue() != null) {
                    if (!entry.getValue().isBlank()) {
                        age = age + Integer.parseInt(entry.getValue());
                    }
                }
            }
        }

        if (age != 0) {
            return Optional.of(age / employees.size());
        } else {
            return Optional.empty();
        }
    }

    public static void printYoungEmp(List<Integer> numbers, List<Map<String, String>> employees) {
        for (int number : numbers) {
            System.out.println(getEmployeeName(employees.get(number)));
        }
    }

    private static String getEmployeeName(Map<String, String> employee) {
        return employee.getOrDefault("Имя", "Неизвестно");
    }
}
