import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {
        List<Employee> list = EmployeeDatabase.getEmployeeList();

        // Group the Employees by city.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getCity))
                .forEach((city, employees) -> System.out.println(city + ":" + employees));

        // Group the Employees by age
        list.stream()
                .collect(Collectors.groupingBy(Employee::getAge))
                .forEach((age, employees) -> System.out.println(age + ":" + employees));

        // Find the count of male and female employees present in the organization.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .forEach((gender, count) -> System.out.println(gender + ":" + count));

        // Print the names of all departments in the organization.
        list.stream()
                .map(emp -> emp.getDeptName())
                .distinct()
                .forEach((department) -> System.out.println(department));

        // Find maximum age of employee.
        list.stream()
                .sorted((a, b) -> b.getAge() - a.getAge())
                .findFirst()
                .ifPresent((emp) -> System.out.println(emp));

        list.stream()
                .mapToInt(Employee::getAge)
                .max()
                .ifPresent((emp) -> System.out.println(emp));

        // Print Average age of Male and Female Employees.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)))
                .forEach((gender, avg) -> System.out.println(gender + ":" + avg));
        ;

        // Print the number of employees in each department.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .forEach((department, count) -> System.out.println(department + ":" + count));

        // Find youngest female employee.
        list.stream()
                .filter(emp -> emp.getGender().equalsIgnoreCase("F"))
                .mapToInt(Employee::getAge)
                .min()
                .ifPresent((emp) -> System.out.println(emp));

        // Find employees whose age is greater than 30 and less than 30.
        list.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 30))
                .entrySet().forEach(System.out::println);

        // Find the department name which has the highest number of employees
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max((a, b) -> Long.compare(a.getValue(), b.getValue()))
                .ifPresent((dept) -> System.out.println(dept));

        // Find count of employees from HR Department.
        System.out.println(list.stream()
                .filter(employee -> employee.getDeptName().equalsIgnoreCase("HR"))
                .count());

        // Find the department names that these employees work for, where the number of
        // employees in the department is over 3.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 3)
                .forEach((entry) -> System.out.println(entry.getKey() + ":" + entry.getValue()));

        // Find distinct department names that employees work for.
        list.stream()
                .map(Employee::getDeptName)
                .distinct()
                .forEach((entry) -> System.out.println(entry));

        // Find the department which has the highest number of employees.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(entry -> entry.getKey())
                .ifPresent(System.out::println);

        // Sorting a Stream by age and name fields.
        list.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName))
                .forEach(System.out::println);

        // Highest experienced employees in the organization.
        list.stream().min(Comparator.comparing(Employee::getYearOfJoining)).ifPresent(System.out::println);

        // Print average and total salary of the organization.
        System.out.println(list.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));

        // Print Average salary of each department.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((dept, avg) -> System.out.println(dept + ":" + avg));

        // Find Highest salary in the organisation.
        list.stream()
                .map(emp -> emp.getSalary())
                .sorted((a, b) -> Long.compare(b, a))
                .skip(0)
                .findFirst()
                .ifPresent(System.out::println);

        // Find Second Highest salary in the organisation.
        list.stream()
                .map(emp -> emp.getSalary())
                .sorted((a, b) -> Long.compare(b, a))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        // Find highest paid salary in the organisation based on gender.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .entrySet().forEach(System.out::println);

        // Highest salary based on department.
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .entrySet().forEach(System.out::println);

        // Print list of employee’s second highest record based on department
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                li -> li.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1)
                                        .findFirst())))
                .entrySet().forEach(System.out::println);

        // Sort the employees salary in each department in ascending order
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                li -> li.stream().sorted(Comparator.comparing(Employee::getSalary))
                                        .collect(Collectors.toList()))))
                .entrySet().forEach(System.out::println);

        // Sort the employees salary in each department in descending order
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                li -> li.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .collect(Collectors.toList()))))
                .entrySet().forEach(System.out::println);
    }
}
