package com.example.rabbitmqproducer.util;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ShengXiaoTool {

    //十天干
    private static String[] TIAN_GAN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    //十二地支
    private static String[] DI_ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    //十二生肖
    private static String[] SHENG_XIAO = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "犬", "猪"};


    //查询生辰八字星座属相
    public static String getJson(Map dateMap) throws Exception {

        String dateStr = (String) dateMap.get("date");
        //公历solar=1 农历lunar=0
        int typeNumber = (int) dateMap.get("type");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);
        int year = dateTime.getYear();
        int month = dateTime.getMonth().getValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();

        int solarYear , solarMonth, solarDay, lunarYear, lunarMonth, lunarDay;
        // 公历转农历
        if(1 == typeNumber) {
            Solar solar = new Solar(year, month, day); // 公历2023年3月18日
            Lunar lunar = solar.getLunar();
            lunarYear = lunar.getYear();
            lunarMonth = lunar.getMonth();
            lunarDay = lunar.getDay();
            solarYear = year;
            solarMonth = month;
            solarDay =day;
        }else{
            // 农历转公历
            Lunar lunar = new Lunar(year, month, day);
            Solar solar = lunar.getSolar();
            solarYear = solar.getYear();
            solarMonth = solar.getMonth();
            solarDay = solar.getDay();
            lunarYear = year;
            lunarMonth = month;
            lunarDay = day;
        }
        //农历日期
        String lunarStr = lunarYear + "-" + (lunarMonth > 9 ? lunarMonth : "0" + lunarMonth) + "-" + (lunarDay > 9 ? lunarDay : "0" + lunarDay);
        //公历日期
        String solarStr = solarYear + "-" + (solarMonth > 9 ? solarMonth : "0" + solarMonth) + "-" + (solarDay > 9 ? solarDay : "0" + solarDay);

        Map data = new HashMap();
        data.put("solar", solarStr);
        data.put("lunar", lunarStr);

        //根据农历年份获取干支纪年
        int yearForJiaZi = ((lunarYear - 1984) % 60) >= 0 ? (lunarYear - 1984) % 60 : (lunarYear - 1984) % 60 + 60;
        int x = yearForJiaZi % 10;
        int y = yearForJiaZi % 12;
        String yearForGanZhi = TIAN_GAN[x] + DI_ZHI[y];

        //根据年份干支计算月份
        int monthTianGan = (2 * (x + 1) + 1) % 10 - 1;
        int monthDiZhi = (lunarMonth + 1) % 12;
        String monthForGanZhi = TIAN_GAN[monthTianGan] + DI_ZHI[monthDiZhi];

        //根据公历日期获取干支纪日（农历闰月暂不懂如何计算）
        //以某一固定公历日期的干支推算   1984.1.1  甲午日 = 31
        //距离固定日期的总天数
        int days = getDays(solarStr);
        int daysForGZ = (30 + days) % 60 >= 0 ? (30 + days) % 60 : (30 + days) % 60 + 60;
        int dayTianGan = daysForGZ % 10;
        int dayDiZhi = daysForGZ % 12;
        String dayForGanZhi = TIAN_GAN[dayTianGan] + DI_ZHI[dayDiZhi];

        //时辰
        int hourGanZhi = (hour + 3) / 2 - 1;
        String hourForGanZhi = DI_ZHI[hourGanZhi];

        //星座
        String xinZuo = getXingZuo(solarStr);

        //属相
        String shuXiang = SHENG_XIAO[y];
        String message = "您的生辰八字：" + yearForGanZhi + "年 " + monthForGanZhi + "月 " + dayForGanZhi + "日 " + hourForGanZhi + "时 " + xinZuo + " 属" + shuXiang;
        return message;
    }


    //日期在一年中的第几天
    public static int getDays(String dateStr) {
        //是否闰年
        int year = Integer.parseInt(dateStr.split("-")[0]);
        int month = Integer.parseInt(dateStr.split("-")[1]);
        int day = Integer.parseInt(dateStr.split("-")[2]);

        boolean runYearStatus = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            runYearStatus = true;
        }
        int num = 0;
        switch (month) {
            case 12:
                num += 30;
            case 11:
                num += 31;
            case 10:
                num += 30;
            case 9:
                num += 31;
            case 8:
                num += 31;
            case 7:
                num += 30;
            case 6:
                num += 31;
            case 5:
                num += 30;
            case 4:
                num += 31;
            case 3:
                num += runYearStatus == true ? 29 : 28;
            case 2:
                num += 31;
            case 1:
                num += day;
                break;
        }

        int runYears = 0;
        int days = 0;
        if (year > 1984) {
            runYears = (year - 1985) / 4 + 1;
            days = 365 * (year - 1984) + runYears + num - 1;
        } else if (year < 1984) {
            runYears = (1983 - year) / 4;
            days = -(365 * (1983 - year) + runYears + (runYearStatus == true ? 367 - num : 366 - num));
        } else {
            days = num - 1;
        }
        return days;
    }

    //公历日期星座获取
    private static String getXingZuo(String date){
        String xingZuo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        int year = localDate.getYear();
        //白羊 3.21-4.19
        if(localDate.isAfter(LocalDate.of(year,3,20)) && localDate.isBefore(LocalDate.of(year,4,20))){
            xingZuo = "白羊座";
        }
        //金牛 4.20-5.20
        if(localDate.isAfter(LocalDate.of(year,4,19)) && localDate.isBefore(LocalDate.of(year,5,21))){
            xingZuo = "金牛座";
        }
        //双子 5.21-6.21
        if(localDate.isAfter(LocalDate.of(year,5,20)) && localDate.isBefore(LocalDate.of(year,6,22))){
            xingZuo = "双子座";
        }
        //巨蟹 6.22-7.22
        if(localDate.isAfter(LocalDate.of(year,6,21)) && localDate.isBefore(LocalDate.of(year,7,23))){
            xingZuo = "巨蟹座";
        }
        //狮子 7.23-8.22
        if(localDate.isAfter(LocalDate.of(year,7,22)) && localDate.isBefore(LocalDate.of(year,8,23))){
            xingZuo = "狮子座";
        }
        //处女 8.23-9.22
        if(localDate.isAfter(LocalDate.of(year,8,22)) && localDate.isBefore(LocalDate.of(year,9,23))){
            xingZuo = "处女座";
        }
        //天秤 9.23-10.23
        if(localDate.isAfter(LocalDate.of(year,9,22)) && localDate.isBefore(LocalDate.of(year,10,24))){
            xingZuo = "天秤座";
        }
        //天蝎 10.24-11.22
        if(localDate.isAfter(LocalDate.of(year,10,23)) && localDate.isBefore(LocalDate.of(year,11,23))){
            xingZuo = "天蝎座";
        }
        //射手 11.23-12.21
        if(localDate.isAfter(LocalDate.of(year,11,22)) && localDate.isBefore(LocalDate.of(year,12,22))){
            xingZuo = "射手座";
        }
        //摩羯 12.22-1.19
        if((localDate.isAfter(LocalDate.of(year-1,12,21)) && localDate.isBefore(LocalDate.of(year,1,20)))||
                (localDate.isAfter(LocalDate.of(year,12,21)) && localDate.isBefore(LocalDate.of(year+1,1,20)))){
            xingZuo = "摩羯座";
        }
        //水瓶 1.20-2-18
        if(localDate.isAfter(LocalDate.of(year,1,19)) && localDate.isBefore(LocalDate.of(year,2,19))){
            xingZuo = "水瓶座";
        }
        //双鱼 2.19-3.20
        if(localDate.isAfter(LocalDate.of(year,2,18)) && localDate.isBefore(LocalDate.of(year,3,21))){
            xingZuo = "双鱼座";
        }
        return xingZuo;

    }




}
