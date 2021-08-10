import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class oop5 {

    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        Student (String firstName, String lastName, int age, String homeTown){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public static Student parseStudent(String line) {
            String [] studentParameters = line.split(" ");
            return new Student(studentParameters[0], studentParameters[1],
                    Integer.parseInt(studentParameters[2]), studentParameters[3]);
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("end")){
            Student s = Student.parseStudent(line);

            int existingIndex = findStudentIndex(students, s.firstName, s.lastName);

            if (existingIndex != -1){
                students.get(existingIndex).setHomeTown(s.homeTown);
                students.get(existingIndex).setAge(s.age);
            }else {
                students.add(s);
            }


            line = scanner.nextLine();
        }

        String searchTownName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHomeTown().equals(searchTownName)){
                System.out.printf("%s %s is %d years old.%n",student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }
    static int findStudentIndex(List<Student> students, String firstName, String lastName){
        for (int i = 0; i < students.size() ; i++) {
            if (students.get(i).getFirstName().equals(firstName) &&
                    students.get(i).getLastName().equals(lastName)){
                return i;
            }
        }
        return -1;
    }
}
