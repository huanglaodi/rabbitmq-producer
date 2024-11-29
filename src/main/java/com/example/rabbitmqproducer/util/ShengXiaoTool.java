package com.example.rabbitmqproducer.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ShengXiaoTool {


    //查询生辰八字星座属相
    public static String getJson(Map dateMap) throws IOException {
        //十天干
        String[] TIAN_GAN = {"甲", "已", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        //十二地支
        String[] DI_ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

        //dateMap.put("date", "1973-01-01 08:05:35");
        // dateMap.put("type", "solar");

        String dateStr = (String) dateMap.get("date");
        String type = (String) dateMap.get("type");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter);

        //第三方api公历农历转换
        int year = dateTime.getYear();
        int month = dateTime.getMonth().getValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        String url = "https://www.iamwawa.cn/nongli/api?type=" + type + "&year=" + year + "&month=" + month + "&day=" + day; // 替换为你的URL
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // 设置请求类型为GET
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "iamwawa-open-api");

        // 读取响应
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String responseStr = response.toString();
        JSONObject json = JSONObject.parseObject(responseStr);

        //农历日期
        JSONObject data = JSONObject.parseObject(json.getString("data"));
        String lunar = data.getString("lunar").replace("年", "-").replace("月", "-").replace("日", "");
        String[] lunarList = lunar.split("-");
        int lunarYear = Integer.parseInt(lunarList[0]);
        int lunarMonth = Integer.parseInt(lunarList[1]);
        int lunarDay = Integer.parseInt(lunarList[2]);
        String lunarStr = lunarYear + "-" + (lunarMonth > 10 ? lunarMonth : "0" + lunarMonth) + "-" + (lunarDay > 10 ? lunarDay : "0" + lunarDay);

        //公历日期
        String solar = data.getString("solar").replace("年", "-").replace("月", "-").replace("日", "");
        String[] solarList = solar.split("-");
        int solarYear = Integer.parseInt(solarList[0]);
        int solarMonth = Integer.parseInt(solarList[1]);
        int solarDay = Integer.parseInt(solarList[2]);
        String solarStr = solarYear + "-" + (solarMonth > 10 ? solarMonth : "0" + solarMonth) + "-" + (solarDay > 10 ? solarDay : "0" + solarDay);

        data.put("solar", solarStr);
        data.put("lunar", lunarStr);

        // 打印结果
        System.out.println(data.toString());

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
        String xinZuo = data.getString("constellation");
        //属相
        String shuXiang = data.getString("zodiac");
        String message = "您的生辰八字：" + yearForGanZhi + "年 " + monthForGanZhi + "月 " + dayForGanZhi + "日 " + hourForGanZhi + "时 " + xinZuo + " 属" + shuXiang;
        return message;
    }

    public static void main(String[] args) throws IOException {
        // getYearForGanZhi(1982);
        getJson(new HashMap());
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


}
