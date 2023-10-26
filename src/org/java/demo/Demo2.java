package org.java.demo;

import java.util.Objects;

/**
 * @Auther: Ban
 * @Date: 2023/5/11 21:16
 * @Description:
 */
public class Demo2 {

    int number;

    public Demo2() {
    }

    public Demo2(int number) {
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
        Demo2 demo2 = (Demo2) o;
        return number == demo2.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Demo2{" +
                "number=" + number +
                '}';
    }
}
