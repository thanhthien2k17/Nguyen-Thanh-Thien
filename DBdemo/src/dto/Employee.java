/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author thien
 */
public class Employee {

    private String code;
    private String name;
    private int age;
    private float salary;
    private String username;
    private int role;

    public Employee() {
    }

    public Employee(String code, String name, int age, float salary, String username, int role) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.username = username;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "code=" + code + ", name=" + name + ", age=" + age + ", salary=" + salary + '}';
    }

}
