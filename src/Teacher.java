
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private String subject;
    public int years;
    public double salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int years, double salary) {
        super(name, surname, age, gender);
        this.subject =subject;
        this.years =years;
        this.salary = salary;
    }
    public void giveRaise(double percentage) {
        salary += salary * percentage / 100;
    }

    public static List<Teacher> readTeachersFromFile(String filename) {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                String subject = parts[4];
                int years = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, years, salary);
                teachers.add(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }

}