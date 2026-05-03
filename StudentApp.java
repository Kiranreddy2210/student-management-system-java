import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {
    private int id;
    private String name;
    private int age;
    private String course;

    public StudentRecord(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void show() {
        System.out.println(id + " | " + name + " | " + age + " | " + course);
    }
}

public class StudentApp {

    static ArrayList<StudentRecord> studentList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void add() {
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (StudentRecord s : studentList) {
            if (s.getId() == id) {
                System.out.println("ID already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter Course: ");
        String course = input.nextLine();

        studentList.add(new StudentRecord(id, name, age, course));
        System.out.println("Student record saved.");
    }

    public static void view() {
        if (studentList.size() == 0) {
            System.out.println("No records found.");
            return;
        }

        for (StudentRecord s : studentList) {
            s.show();
        }
    }

    public static void search() {
        System.out.print("Enter ID: ");
        int id = input.nextInt();

        for (StudentRecord s : studentList) {
            if (s.getId() == id) {
                s.show();
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public static void update() {
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (StudentRecord s : studentList) {
            if (s.getId() == id) {

                System.out.print("New Name: ");
                s.setName(input.nextLine());

                System.out.print("New Age: ");
                s.setAge(input.nextInt());
                input.nextLine();

                System.out.print("New Course: ");
                s.setCourse(input.nextLine());

                System.out.println("Updated successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public static void delete() {
        System.out.print("Enter ID: ");
        int id = input.nextInt();

        for (StudentRecord s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                System.out.println("Deleted successfully.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Add 2.View 3.Search 4.Update 5.Delete 6.Exit");
            int ch = input.nextInt();

            switch (ch) {
                case 1: add(); break;
                case 2: view(); break;
                case 3: search(); break;
                case 4: update(); break;
                case 5: delete(); break;
                case 6: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}