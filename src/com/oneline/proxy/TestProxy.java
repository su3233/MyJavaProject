package com.oneline.proxy;

public class TestProxy {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        //返回代理类的一个实例，返回后的代理类可以当作被代理类使用
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
