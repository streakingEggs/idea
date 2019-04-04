package com.wql.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id" ,columnDefinition = "int(11)")
    private int id;

    @Column(name = "name" ,columnDefinition = "varchar(20)")
    private String name;

    @Column(name = "age" ,columnDefinition = "int(3)")
    private int age;

    @Column(name = "sex" ,columnDefinition = "int(1)")
    private int sex;

    @Column(name = "phone" ,columnDefinition = "varchar(11)")
    private String phone;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "depa_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Department department;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
