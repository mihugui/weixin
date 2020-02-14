package com.mhg.weixin.bean.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StreamTypeEnum
 * @Description TODO
 * @Author PWT
 * @Date 2019/9/2 17:00
 * @Version 1.0
 **/

public enum IsUsedEnum {

    ENABLE("0","启用"),
    DISABLE("1","禁用");

    private String code;
    private String desc;

    IsUsedEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }


    public static String getDescByCode(String code) {
        String label = "";
        for (IsUsedEnum o : IsUsedEnum.values()) {
            if (o.getCode().equals(code)) {
                label = o.getDesc();
            }
        }
        return label;
    }

    public static String getCodeByDesc(String desc) {
        String value = "";
        for (IsUsedEnum o : IsUsedEnum.values()) {
            if (o.getDesc().equals(desc)) {
                value = o.getCode();
            }
        }
        return value;
    }

    public static List<Map> getList()
    {
        List<Map> maps = new ArrayList<>();
        for (IsUsedEnum o : IsUsedEnum.values()) {
            Map map = new HashMap();
            map.put("code",o.getCode());
            map.put("desc",o.getDesc());
            maps.add(map);
        }
        return maps;
    }


}
