package com.jackytest.demo.dao;

import com.jackytest.demo.common.MySqlExtensionMapper;
import com.jackytest.demo.entity.TestUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestUserMapper extends MySqlExtensionMapper<TestUser> {

    List<TestUser> getByName(@Param("userName") String userName, @Param("userId") Integer userId);

}