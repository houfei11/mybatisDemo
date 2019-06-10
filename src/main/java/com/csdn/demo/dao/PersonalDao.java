package com.csdn.demo.dao;

import com.csdn.demo.entity.Personal;

/**
 * mybatis中与xml文件绑定的接口
 */
public interface PersonalDao {

    /**
     *  根据id查询Pesonal的方法
     * @param id
     * @return
     */
    Personal getPersonalById(Integer id);

    /**
     * 添加
     * @param personal
     */
    void addPersonal(Personal personal);

    /**
     * 修改
     * @param personal
     */
    void updatePersonal(Personal personal);

    /**
     * 删除
     * @param id
     */
    void deletePersonal(Integer id);
}
