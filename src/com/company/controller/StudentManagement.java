package com.company.controller;

import com.company.model.Clazz;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements IGeneralManagement<Student> {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public void showAll() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void addNew(Student student) {
        students.add(student);
    }

    @Override
    public void updateById(String id, Student student) {
        int index = findById(id);
        if (index != -1) {
            students.set(index, student);
        } else {
            System.out.println("Không có mã sinh viên này");
        }
    }

    @Override
    public void removeById(String id) {
        int index = findById(id);
        if (index != -1) {
            students.remove(index);
        } else {
            System.out.println("Không có mã sinh viên này");
        }
    }

    @Override
    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void addStudentToClass(int index, Clazz clazz) {
        Student student = students.get(index);
        student.setClazz(clazz);
        students.set(index, student);
    }

    public int countStudentInClass(Clazz clazz) {
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getClazz().getId().equals(clazz.getId())) {
                count++;
            }
        }
        return count;
    }
}
