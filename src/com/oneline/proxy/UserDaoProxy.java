package com.oneline.proxy;

public class UserDaoProxy implements IUserDao {
    private IUserDao iUserDao;

    public UserDaoProxy(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void save() {
        System.out.println("开始事务");
        iUserDao.save();
        System.out.println("提交事务");
    }
}
