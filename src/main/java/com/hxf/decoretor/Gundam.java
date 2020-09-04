package com.hxf.decoretor;

/**
 * @author: hxf
 * @date: 2020/3/3 14:51
 * @description:
 */
public class Gundam extends FightMachine {

    @Override
    public void fight() {
        System.out.println("use gandam!!!");
    }
}

class MainClass {
    public static void main(String[] args) {
        FightMachine gandam = new Gun(new Sword(new Gundam()));
        gandam.fight();
    }
}
