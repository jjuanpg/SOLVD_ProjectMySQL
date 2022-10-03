package com.solvd.mybatis.entities;

public class Branch {

    private int id;
    private String name;
    private String address;
    private int managerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManager_id() {
        return managerId;
    }

    public void setManager_id(int manager_id) {
        this.managerId = manager_id;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manager_id=" + managerId +
                '}';
    }
}
