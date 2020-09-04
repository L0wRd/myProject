package com.hxf.decoretor;

/**
 * @author: hxf
 * @date: 2020/3/3 14:49
 * @description:
 */
public class Gun extends FightMachine {

    private FightMachine fightMachine;

    public Gun(FightMachine fightMachine) {
        this.fightMachine = fightMachine;
    }

    @Override
    public void fight() {
        fightMachine.fight();
        shoot();
    }

    public void shoot() {
        System.out.println("use gun shoot");
    }
}
