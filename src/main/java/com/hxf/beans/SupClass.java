package com.hxf.beans;

/**
 * @author: hxf
 * @date: 2020/3/2 11:15
 * @description:
 */
public class SupClass {

    public SupClass() {
        System.out.println("父类的无参构造器被调用");
    }
}

class SubClass extends SupClass {
    public SubClass() {
        System.out.println("子类的无参构造器被调用");
    }
}

class MainClass {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        SupClass supClass = new SubClass();
    }
}
