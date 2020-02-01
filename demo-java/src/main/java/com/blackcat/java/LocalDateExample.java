package com.blackcat.java;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * <p> 描述 ：LocalDate使用示例
 * @author : blackcat
 * @date : 2020/1/31 9:45
 */
public class LocalDateExample {
    public static void main(String[] args) {

        //********** LocalDate *************
        // 获取当前年月日
        LocalDate localDate = LocalDate.now();
        // 构造指定的年月日
        LocalDate.of(2019, 9, 10);
        // 获取年
        localDate.getYear();
        localDate.get(ChronoField.YEAR);
        // 获取月
        localDate.getMonth();
        localDate.get(ChronoField.MONTH_OF_YEAR);
        // 获取日
        localDate.getDayOfMonth();
        localDate.get(ChronoField.DAY_OF_MONTH);
        // 获取星期几
        localDate.getDayOfWeek();
        localDate.get(ChronoField.DAY_OF_WEEK);

        //********** LocalTime *************
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime.now();
        // 获取小时
        localTime.getHour();
        localTime.get(ChronoField.HOUR_OF_DAY);
        // 获取分
        localTime.getMinute();
        localTime.get(ChronoField.MINUTE_OF_HOUR);
        // 获取秒
        localTime.getMinute();
        localTime.get(ChronoField.SECOND_OF_MINUTE);

        //********** LocalDateTime *************
        // 获取年月日时分秒，等于LocalDate+LocalTime
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime.of(localDate, localTime);
        localDate.atTime(localTime);
        localTime.atDate(localDate);
        // 获取LocalDate
        localDateTime.toLocalDate();
        // 获取LocalTime
        localDateTime.toLocalTime();

        // 获取秒数
        // 创建Instant对象
        Instant instant = Instant.now();
        // 获取秒数
        instant.getEpochSecond();
        // 获取毫秒数
        instant.toEpochMilli();

        LocalDateTime localDateTime6 = LocalDateTime.of(
                2019, Month.SEPTEMBER, 10,
                14, 46, 56);
        //增加一年
        localDateTime6=localDateTime6.plusYears(1);
        localDateTime6=localDateTime6.plus(1, ChronoUnit.YEARS);
        //减少一个月
        localDateTime6=localDateTime6.minusMonths(1);
        localDateTime6=localDateTime6.minus(1, ChronoUnit.MONTHS);
        //修改年为2019
        localDateTime6=localDateTime6.withYear(2020);
        //修改为2022
        localDateTime6=localDateTime6.with(ChronoField.YEAR, 2022);
        System.out.println(localDateTime6);

        // 格式化时间
        localDate.with(firstDayOfYear());// 年最后一天
        LocalDate.of(2019, 9, 10);
        localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        localDate.format(dateTimeFormatter);

        // 解析时间
        LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
