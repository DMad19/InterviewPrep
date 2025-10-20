import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDatabase.getEmployeeList();

        // Group the Employees by city.
        Map<String, List<Employee>> byCityMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(byCityMap);

        // Group the Employees by age
        Map<Integer, List<Employee>> byAgeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(byAgeMap);

        // Find the count of male and female employees present in the organization.
        Map<String, Long> countByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(countByGender);

        // Print the names of all departments in the organization.
        employeeList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

        // Print employee details whose age is greater than 28.
        employeeList.stream().filter(employee -> employee.getAge() > 28)
                .forEach(System.out::println);

        // Find maximum age of employee.
        System.out.println(employeeList.stream().mapToInt(Employee::getAge).max().orElse(0));

        // Print Average age of Male and Female Employees.
        Map<String, Double> genderMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(genderMap);

        // Print the number of employees in each department.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + ":" + value));

        // Find youngest female employee.
        employeeList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("F"))
                .min(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);

        // Find employees whose age is greater than 30 and less than 30.
        employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 30))
                .entrySet().forEach(System.out::println);

        // Find the department name which has the highest number of employees
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);

        // Find count of employees from HR Department.
        System.out.println(employeeList.stream()
                .filter(employee -> employee.getDeptName().equalsIgnoreCase("HR"))
                .count());

        // Find if there any employees from HR Department.
        System.out.println(employeeList.stream()
                .filter(employee -> employee.getDeptName().equalsIgnoreCase("HR"))
                .findAny().orElse(null));

        // Find the department names that these employees work for, where the number of
        // employees in the department is over 3.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 3)
                .forEach(entry -> System.out.println(entry.getKey()));

        // Find distinct department names that employees work for.
        employeeList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

        // Find all employees who lives in ‘Blore’ city, sort them by their name and
        // print the names of employees.
        employeeList.stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase("Blore"))
                .forEach(System.out::println);

        // No of employees in the organisation.
        System.out.println(employeeList.stream().count());

        // Find employee count in every department
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().forEach(System.out::println);

        // Find the department which has the highest number of employees.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        // Sorting a Stream by age and name fields.
        employeeList.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName))
                .forEach(System.out::println);

        // Highest experienced employees in the organization.
        employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining))
                .ifPresent(System.out::println);

        // Print average and total salary of the organization.
        System.out.println(employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));

        // Print Average salary of each department.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .forEach(System.out::println);

        // Find Highest salary in the organisation.
        employeeList.stream().max(Comparator.comparing(Employee::getSalary))
                .ifPresent(employee -> System.out.println(employee.getSalary()));

        // Find Second Highest salary in the organisation.
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1)
                .findFirst().ifPresent(employee -> System.out.println(employee.getSalary()));

        // Find highest paid salary in the organisation based on gender.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .entrySet().forEach(System.out::println);

        // Find lowest paid salary in the organisation based in the organisation.
        employeeList.stream().min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        // Sort the employees salary in the organisation in ascending order
        employeeList.stream().map(Employee::getSalary).sorted().forEach(System.out::println);
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // Sort the employees salary in the organisation in descending order.
        System.out.println("Descending order");
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

        // Highest salary based on department.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet().forEach(System.out::println);

        // Print list of employee’s second highest record based on department
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .distinct().skip(1).findFirst())))
                .entrySet().forEach(System.out::println);

        // Sort the employees salary in each department in ascending order
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list
                                .stream()
                                .sorted(Comparator.comparing(Employee::getSalary))
                                .collect(Collectors.toList()))))
                .forEach((key, value) -> System.out.println(key + ":" + value));

        // Sort the employees salary in each department in descending order
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list
                                .stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .collect(Collectors.toList()))))
                .forEach((key, value) -> System.out.println(key + ":" + value));
    }

}
