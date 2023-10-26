package org.java.demo;

import java.util.Objects;

/**
 * @Auther: Ban
 * @Date: 2023/5/11 21:16
 * @Description:
 */
public class Demo implements Comparable<Demo> {

    private int number;

    public Demo() {
    }

    public Demo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return number == demo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Demo o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "number=" + number +
                '}';
    }
}
