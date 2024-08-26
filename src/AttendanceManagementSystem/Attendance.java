package AttendanceManagementSystem;

public class Attendance {
    String employeeId;
    String date;
    String status;

    public Attendance(String employeeId, String date, String status) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    public static Attendance fromText(String text) {
        String[] parts = text.split("\\|");
        return new Attendance(parts[0], parts[1], parts[2]);
    }

    public String toText() {
        return employeeId + "|" + date + "|" + status;
    }
}
