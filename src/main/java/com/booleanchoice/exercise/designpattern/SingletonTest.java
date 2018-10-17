package com.booleanchoice.exercise.designpattern;

public class SingletonTest {

    // 构造方法私有化
    private SingletonTest() {

    }

    // 设置为volatile，保证其可见性
    private static volatile SingletonTest instance;

    // 获取单例对象的方法
    public static SingletonTest getInstance() {
        // 如果对象非空，直接返回
        if (null == instance) {
            // 使用同步代码块，加入互斥锁，防止多线程下重复被创建
            synchronized (SingletonTest.class) {
                if (null == instance) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

}
