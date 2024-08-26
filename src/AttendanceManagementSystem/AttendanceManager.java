package AttendanceManagementSystem;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AttendanceManager {
    List<Employee> employees = new ArrayList<>();
    List<Attendance> attendanceRecords = new ArrayList<>();
    List<Employee> newEmployees = new ArrayList<>();
    List<Attendance> newAttendanceRecords = new ArrayList<>();
    String employeeFilePath = "employees.txt";
    String attendanceFilePath = "attendance.txt";

    public void loadEmployees() {
        try {
            Path employeePath = Paths.get(employeeFilePath).toAbsolutePath();
            if (Files.exists(employeePath)) {
                try (BufferedReader reader = Files.newBufferedReader(employeePath)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                      //  System.out.println("Reading Employee: " + line); // Debugging statement
                        employees.add(Employee.fromText(line));
                    }
                }
            } else {
                System.out.println("Employee file not found at: " + employeePath);
            }
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }

    public void saveEmployees() {
        try {
            Path employeePath = Paths.get(employeeFilePath).toAbsolutePath();
            try (BufferedWriter writer = Files.newBufferedWriter(employeePath, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
                for (Employee employee : newEmployees) {
                    System.out.println("Saving New Employee: " + employee.toText()); // Debugging statement
                    writer.write(employee.toText());
                    writer.newLine();
                }
                writer.flush(); // Ensure all data is written
                newEmployees.clear(); // Clear new entries after saving
            }
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public void loadAttendanceRecords() {
        try {
            Path attendancePath = Paths.get(attendanceFilePath).toAbsolutePath();
            if (Files.exists(attendancePath)) {
                try (BufferedReader reader = Files.newBufferedReader(attendancePath)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        attendanceRecords.add(Attendance.fromText(line));
                    }
                }
            } else {
                System.out.println("Attendance file not found at: " + attendancePath);
            }
        } catch (IOException e) {
            System.out.println("Error loading attendance records: " + e.getMessage());
        }
    }

    public void saveAttendanceRecords() {
        try {
            Path attendancePath = Paths.get(attendanceFilePath).toAbsolutePath();
            System.out.println("Attendance file path: " + attendancePath);
            try (BufferedWriter writer = Files.newBufferedWriter(attendancePath, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
                for (Attendance attendance : newAttendanceRecords) {
                    System.out.println("Saving New Attendance: " + attendance.toText()); // Debugging statement
                    writer.write(attendance.toText());
                    writer.newLine();
                }
                writer.flush(); // Ensure all data is written
                newAttendanceRecords.clear(); // Clear new entries after saving
            }
        } catch (IOException e) {
            System.out.println("Error saving attendance records: " + e.getMessage());
        }
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployees();
    }

    public void recordAttendance(String employeeId, String date, String status) {
        attendanceRecords.add(new Attendance(employeeId, date, status));
        saveAttendanceRecords();
    }

    public List<Attendance> viewAttendance(String employeeId, String startDate, String endDate) {
        List<Attendance> filteredRecords = new ArrayList<>();
        for (Attendance attendance : attendanceRecords) {
            if (attendance.employeeId.equals(employeeId) &&
                    attendance.date.compareTo(startDate) >= 0 &&
                    attendance.date.compareTo(endDate) <= 0) {
                filteredRecords.add(attendance);
            }
        }
        return filteredRecords;
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
        } else {
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.id +
                        ", Name: " + employee.name +
                        ", Designation: " + employee.designation +
                        ", Department: " + employee.department);
            }
        }
    }

    public void viewAllAttendance() {
        if (attendanceRecords.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            for (Attendance attendance : attendanceRecords) {
                System.out.println("Employee ID: " + attendance.employeeId +
                        ", Date: " + attendance.date +
                        ", Status: " + attendance.status);
            }
        }
    }
}
