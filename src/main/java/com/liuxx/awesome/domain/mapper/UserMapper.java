package com.liuxx.awesome.domain.mapper;

import com.liuxx.awesome.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * User类的mapper对象
 *
 * @author :liuxx
 * @date: 2017/11/13 10:32
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 通过name查询
     *
     * @param name 姓名
     * @return user对象
     */
    @Select("SELECT * FROM user WHERE `name`=#{name}")
    User findByName(String name);

    /**
     * 新增一个user对象
     *
     * @param name 名字
     * @param age  年龄
     * @return 影响行数
     */
    @Insert("INSERT INTO user (`name`,age) VALUES (#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
