package com.jackytest.demo.common;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * mybatis的Mapper的统一父类，用于简单sql语句快速编码
 * @author JackyRoc
 * @date 2020/9/23 10:52
 */

public interface MySqlExtensionMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
