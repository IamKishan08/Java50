package AttendanceManagementSystem;

public class Employee {
    String id;
    String name;
    String designation;
    String department;

    public Employee(String id, String name, String designation, String department) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
    }

    public static Employee fromText(String text) {
        String[] parts = text.split("\\|");
        return new Employee(parts[0], parts[1], parts[2], parts[3]);
    }

    public String toText() {
        return id + "|" + name + "|" + designation + "|" + department;
    }
}
