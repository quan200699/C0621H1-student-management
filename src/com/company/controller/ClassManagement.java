package com.company.controller;

import com.company.model.Clazz;

import java.util.ArrayList;
import java.util.List;

import static com.company.view.StudentMenu.studentManagement;

public class ClassManagement implements IGeneralManagement<Clazz> {
    private List<Clazz> classList = new ArrayList<>();

    public List<Clazz> getClassList() {
        return classList;
    }

    public void setClassList(List<Clazz> classList) {
        this.classList = classList;
    }

    @Override
    public void showAll() {
        for (Clazz clazz : classList) {
            System.out.println(clazz);
        }
    }

    @Override
    public void addNew(Clazz clazz) {
        classList.add(clazz);
    }

    @Override
    public void updateById(String id, Clazz clazz) {
        int index = findById(id);
        if (index != -1) {
            classList.set(index, clazz);
        } else {
            System.out.println("Không tồn tại mã lớp này!");
        }
    }

    @Override
    public void removeById(String id) {
        int index = findById(id);
        if (index != -1) {
            classList.remove(index);
        } else {
            System.out.println("Không tồn tại mã lớp này!");
        }
    }

    @Override
    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Clazz findById(int index) {
        return classList.get(index);
    }

    public void showNumberOfStudentInClass() {
        for (Clazz clazz : classList) {
            int count = studentManagement.countStudentInClass(clazz);
            System.out.println("Lớp " + clazz.getName() + " có " + count + " học viên");
        }
    }
}
