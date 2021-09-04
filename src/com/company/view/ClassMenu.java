package com.company.view;

import com.company.controller.ClassManagement;
import com.company.controller.StudentManagement;
import com.company.model.Clazz;
import com.company.model.Student;

import static com.company.Main.scanner;
import static com.company.view.StudentMenu.studentManagement;

public class ClassMenu {
    private ClassManagement classManagement = new ClassManagement();

    public void run() {
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAllClass();
                    break;
                }
                case 2: {
                    addNewClass();
                    break;
                }
                case 3: {
                    updateClassInfo();
                    break;
                }
                case 4: {
                    removeClass();
                    break;
                }
                case 5: {
                    addStudentToClass();
                    break;
                }
                case 6: {
                    showStudentInClass();
                    break;
                }
            }
        } while (choice != 0);
    }

    private void showStudentInClass() {
        classManagement.showNumberOfStudentInClass();
    }

    private void addStudentToClass() {
        System.out.println("Nhập mã lớp muốn thêm sinh viên vào:");
        String id = scanner.nextLine();
        int index = classManagement.findById(id);
        if (index == -1) {
            System.out.println("Không có mã lớp này");
        } else {
            studentManagement.showAll();
            Clazz clazz = classManagement.findById(index);
            System.out.println("Nhập mã sinh viên mà bạn muốn thêm vào trong lớp:");
            String studentId = scanner.nextLine();
            int studentIndex = studentManagement.findById(studentId);
            studentManagement.addStudentToClass(studentIndex, clazz);
        }
    }

    private void removeClass() {
        System.out.println("Nhập mã lớp cần chỉnh sửa:");
        String id = scanner.nextLine();
        classManagement.removeById(id);
    }

    private void updateClassInfo() {
        System.out.println("Nhập mã lớp cần chỉnh sửa:");
        String id = scanner.nextLine();
        Clazz clazz = inputClassFromKeyboard();
        classManagement.updateById(id, clazz);
    }

    private void addNewClass() {
        Clazz clazz = inputClassFromKeyboard();
        classManagement.addNew(clazz);
    }

    private Clazz inputClassFromKeyboard() {
        System.out.println("Nhập mã lớp:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên lớp:");
        String name = scanner.nextLine();
        return new Clazz(id, name);
    }

    private void showAllClass() {
        classManagement.showAll();
    }

    private void menu() {
        System.out.println("QUẢN LÝ LỚP HỌC");
        System.out.println("1. Hiển thi danh sách lớp");
        System.out.println("2. Thêm lớp học mới");
        System.out.println("3. Chỉnh sửa thông tin lớp học");
        System.out.println("4. Xóa lớp học");
        System.out.println("5. Thêm sinh viên vào lớp học");
        System.out.println("6. Thống kê mỗi lớp có bao nhiêu sinh viên");
        System.out.println("0. Quay lại");
    }
}
