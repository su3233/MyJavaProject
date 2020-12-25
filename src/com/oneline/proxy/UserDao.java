package com.oneline.proxy;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("userDao-已保存数据");
    }
}
