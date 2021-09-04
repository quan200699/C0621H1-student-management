package com.company.controller;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManagement implements IGeneralManagement<User> {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void showAll() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public void addNew(User user) {
        users.add(user);
    }

    @Override
    public void updateById(String id, User user) {
        int index = findById(id);
        if (index != -1) {
            users.set(index, user);
        } else {
            System.out.println("Không có user này");
        }
    }

    @Override
    public void removeById(String id) {
        int index = findById(id);
        if (index != -1) {
            users.remove(index);
        } else {
            System.out.println("Không có user này");
        }
    }

    @Override
    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public User isLogin(User user) {
        for (User user1 : users) {
            if (user.getUsername().equals(user1.getUsername())
                    && user.getPassword().equals(user1.getPassword())){
                return user1;
            }
        }
        return null;
    }
}
