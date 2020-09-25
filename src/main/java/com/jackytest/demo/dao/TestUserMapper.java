package com.jackytest.demo.dao;

import com.jackytest.demo.common.MySqlExtensionMapper;
import com.jackytest.demo.entity.TestUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserMapper extends MySqlExtensionMapper<TestUser> {
}