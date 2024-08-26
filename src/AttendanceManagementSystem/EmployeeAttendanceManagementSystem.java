package AttendanceManagementSystem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeeAttendanceManagementSystem {

    public static void main(String[] args) throws IOException {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadEmployees();
        manager.loadAttendanceRecords();
        boolean s = true;
        while (s) {
            System.out.println("\nEmployee Attendance Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Record Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. View All Employees");
            System.out.println("5. View All Attendance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Employee employee = new Employee(id, name, designation, department);
                    manager.addEmployee(employee);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    String empId = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Status (Present/Absent/Leave): ");
                    String status = scanner.nextLine();
                    manager.recordAttendance(empId, date, status);
                    System.out.println("Attendance recorded successfully.");
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    String viewEmpId = scanner.nextLine();
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    List<Attendance> records = manager.viewAttendance(viewEmpId, startDate, endDate);
                    if (records.isEmpty()) {
                        System.out.println("No attendance records found.");
                    } else {
                        for (Attendance record : records) {
                            System.out.println("Date: " + record.date + ", Status: " + record.status);
                        }
                    }
                    break;

                case 4:
                    manager.viewAllEmployees();
                    break;

                case 5:
                    manager.viewAllAttendance();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    s = false;
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

