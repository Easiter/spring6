package com.powernode.simple.factory;

public class WeaponFactory {

    /*
        静态方法：要获取什么产品，就看你传什么参数，传tank就获取坦克，传dagger就获取匕首....
        简单工厂模式有一个静态方法，所以被称为：静态工厂方法模式
     */
    public static Weapon get(String weaponType) {
        if ("TANK".equals(weaponType)) {
            return new Tank();
        } else if ("DAGGER".equals(weaponType)) {
            return new Dagger();
        } else if ("FIGHTER".equals(weaponType)) {
            return new Fighter();
        } else {
            throw new RuntimeException("不支持该武器的生产！");
        }
    }
}
