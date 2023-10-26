package org.java.demo;

/**
 * @Auther: Ban
 * @Date: 2023/6/30 16:14
 * @Description:
 */
public class Manager extends Employee {
    private double bonus;

    public Manager() {
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
