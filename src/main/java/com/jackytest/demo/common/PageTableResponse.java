package com.jackytest.demo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询返回
 * @author JackyRoc
 * @date 2020/9/21 14:59
 */

@Data
public class PageTableResponse<T> implements Serializable {

    private static final long serialVersionUID = 620421858510718076L;

    private Integer recordsTotal;
    private List<T> data;

}
