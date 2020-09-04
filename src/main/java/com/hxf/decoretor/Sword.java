package com.hxf.decoretor;

/**
 * @author: hxf
 * @date: 2020/3/3 14:47
 * @description:
 */
public class Sword extends FightMachine {

    private FightMachine fightMachine;

    public Sword(FightMachine fightMachine) {
        this.fightMachine = fightMachine;
    }

    @Override
    public void fight() {
        fightMachine.fight();
        bit();
    }

    public void bit() {
        System.out.println("use sword");
    }
}
