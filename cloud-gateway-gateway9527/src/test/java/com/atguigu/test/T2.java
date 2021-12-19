package com.atguigu.test;

import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
        //gateway before after等用的时间是ZonedDateTime格式
        ZonedDateTime now = ZonedDateTime.now();//默认时区
        //2021-12-16T15:29:47.129+08:00[Asia/Shanghai]
        System.out.println(now);
    }
}
