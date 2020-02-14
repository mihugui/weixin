package com.mhg.weixin.bean;

import lombok.Data;

/**
 * @Classname PageDO
 * @Description TODO
 * @Date 2020/2/3 21:36
 * @Created by pwt
 */

@Data
public class PageVO {

    Integer limit = 10;

    Integer page = 1;

}
