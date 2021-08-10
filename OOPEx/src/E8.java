import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E8 {

    static class Department{
        String departmentName;
        List<Employee> employees;

        public Department(String departmentName, List<Employee> employees) {
            this.departmentName = departmentName;
            this.employees = employees;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public List<Employee> getEmployees() {
            return employees;
        }


    }

    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public String getDepartment() {
            return department;
        }

        public String getEmail() {
            if (email == null) {
                return "n/a";
            }
            return email;
        }

        public int getAge() {
            if (age == 0) {
                return -1;
            }
            return age;
        }


        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String toString(){
            return String.format("%s %.2f %s %d", getName(), getSalary(), getEmail(), getAge());
        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();



        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Employee employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]);
            if (input.length == 5){
                if (input[4].contains("@")){
                    employee.setEmail(input[4]);
                } else {
                    employee.setAge(Integer.parseInt(input[4]));
                }
            } else if (input.length == 6){
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));
            }

            employees.add(employee);

        }

        List<String> howManyDepartments = new ArrayList<>();

        for (Employee employee : employees) {
            String currentDepartment = employee.getDepartment();
            if (!howManyDepartments.contains(currentDepartment))
                howManyDepartments.add(currentDepartment);
        }
        List<Department> departmentList = new ArrayList<>();

        for (int i = 0; i < howManyDepartments.size() ; i++) {
            List<Employee> employeesInDepartment = new ArrayList<>();
            for (int j = 0; j < employees.size() ; j++) {
                if (howManyDepartments.get(i).equals(employees.get(j).getDepartment())){
                    employeesInDepartment.add(employees.get(j));
                }
            }
            Department department = new Department(howManyDepartments.get(i), employeesInDepartment);

            departmentList.add(department);
        }
        double maxSalary = Double.MIN_VALUE;
        String departmentWithMaxSalary = "";
        for (int i = 0; i <departmentList.size() ; i++) {
            double currentSalary = 0.0;
            String currentDepartment = departmentList.get(i).getDepartmentName();
            for (int j = 0; j <departmentList.get(i).getEmployees().size() ; j++) {
                currentSalary +=departmentList.get(i).getEmployees().get(j).getSalary();
            }
            if (currentSalary > maxSalary){
                maxSalary = currentSalary;
                departmentWithMaxSalary = currentDepartment;

            }
        }

        System.out.println("Highest Average Salary: " + departmentWithMaxSalary);
        for (int i = 0; i < departmentList.size() ; i++) {
            if (departmentList.get(i).getDepartmentName().equals(departmentWithMaxSalary)){

                departmentList.get(i).getEmployees().stream().sorted(
                            (s1, s2) -> Double.compare(s2.getSalary(), s1.getSalary()))
                            .forEach(salary -> System.out.println(salary.toString()));

                    /*System.out.printf("%s %.2f %s %d%n", departmentList.get(i).getEmployees().get(j).getName()
                    , departmentList.get(i).getEmployees().get(j).getSalary(), departmentList.get(i).getEmployees().get(j).getEmail()
                    ,departmentList.get(i).getEmployees().get(j).getAge());*/

            }
        }
    }
}
