package com.company.view;

import com.company.controller.StudentManagement;
import com.company.model.Student;

import static com.company.Main.scanner;

public class StudentMenu {
    public static StudentManagement studentManagement = new StudentManagement();

    public void run() {
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAllStudent();
                    break;
                }
                case 2: {
                    addNewStudent();
                    break;
                }
                case 3: {
                    updateStudent();
                    break;
                }
                case 4: {
                    removeStudent();
                    break;
                }
            }
        } while (choice != 0);
    }

    private void removeStudent() {
        System.out.println("Nhập mã sinh viên cần chỉnh sửa:");
        String id = scanner.nextLine();
        studentManagement.removeById(id);
    }

    private void updateStudent() {
        System.out.println("Nhập mã sinh viên cần chỉnh sửa:");
        String id = scanner.nextLine();
        Student student = inputStudentFromKeyBoard();
        studentManagement.updateById(id, student);
    }

    private void addNewStudent() {
        Student student = inputStudentFromKeyBoard();
        studentManagement.addNew(student);
    }

    private Student inputStudentFromKeyBoard() {
        System.out.println("Nhập mã sinh viên:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sinh viên:");
        String name = scanner.nextLine();
        System.out.println("Nhập điểm:");
        double mark = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập ngày sinh:");
        String birthday = scanner.nextLine();
        Student student = new Student(id, name, birthday, mark);
        return student;
    }

    private void showAllStudent() {
        studentManagement.showAll();
    }

    private void menu() {
        System.out.println("QUẢN LÝ SINH VIÊN");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Cập nhật thông tin sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Hiển thị 5 sinh viên điểm cao nhất");
        System.out.println("0. Quay lại");
    }
}
