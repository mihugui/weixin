package com.mhg.weixin.bean.base.dto;

import lombok.Data;

import java.util.List;

/**
 * @Classname TableVO
 * @Description TODO
 * @Date 2020/2/11 13:25
 * @Created by pwt
 */

@Data
public class TableDTO<T> {

    Integer code = 0;

    String msg;

    long count;

    List<T> data;

}
