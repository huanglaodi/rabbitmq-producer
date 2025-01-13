package com.example.rabbitmqproducer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test11 {

    private static String[] puke = {"♥A", "♥2", "♥3", "♥4", "♥5", "♥6", "♥7", "♥8", "♥9", "♥10", "♥J", "♥Q", "♥K",
            "♠A", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠J", "♠Q", "♠K",
            "♦A", "♦2", "♦3", "♦4", "♦5", "♦6", "♦7", "♦8", "♦9", "♦10", "♦J", "♦Q", "♦K",
            "♣A", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10", "♣J", "♣Q", "♣K", "小王", "大王"};

    public static void main(String[] args) {
        /*if(aa()){
            System.out.print("hello ");
        }else{
            System.out.println("world");
        }*/
        //jiafabiao();
        //chenfabiao();
        // doudizhu();
        //zhajinhua();
        //shuangseqiu();
        //qilecai();
        gas();
    }


    public static void gas() {
        Integer a=128;
        Integer b=128;
        boolean result = (a==b);
        System.out.println(result);
    }

    public static void chenfabiao() {
        System.out.println("99乘法表：");
        for (int i = 1; i <= 9; i++) {
            for (int t = 1; t <= 9; t++) {
                System.out.print(i + "*" + t + "=" + (i * t) + "  ");
                if (t == i) {
                    System.out.println("");
                    break;
                }
            }
        }
    }

    public static void shuangseqiu() {
        String[] redBall = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"};
        String[] blueBall = {"+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16"};
        int red1 = 0;
        int red2 = 0;
        int red3 = 0;
        int red4 = 0;
        int red5 = 0;
        int red6 = 0;
        int red7 = 0;
        int red8 = 0;
        int red9 = 0;
        int red10 = 0;
        int red11 = 0;
        int red12 = 0;
        int red13 = 0;
        int red14 = 0;
        int red15 = 0;
        int red16 = 0;
        int red17 = 0;
        int red18 = 0;
        int red19 = 0;
        int red20 = 0;
        int red21 = 0;
        int red22 = 0;
        int red23 = 0;
        int red24 = 0;
        int red25 = 0;
        int red26 = 0;
        int red27 = 0;
        int red28 = 0;
        int red29 = 0;
        int red30 = 0;
        int red31 = 0;
        int red32 = 0;
        int red33 = 0;
        int blue1 = 0;
        int blue2 = 0;
        int blue3 = 0;
        int blue4 = 0;
        int blue5 = 0;
        int blue6 = 0;
        int blue7 = 0;
        int blue8 = 0;
        int blue9 = 0;
        int blue10 = 0;
        int blue11 = 0;
        int blue12 = 0;
        int blue13 = 0;
        int blue14 = 0;
        int blue15 = 0;
        int blue16 = 0;
        // List<List<String>> kaijiangList = new ArrayList<>();
        for (int t = 0; t < 33; t++) {
            List<String> kaijiang = new ArrayList<>();
            List<String> red = new ArrayList(Arrays.asList(redBall));
            List<String> blue = new ArrayList(Arrays.asList(blueBall));
            for (int i = 0; i < 6; i++) {
                String hong = red.get((int) (Math.random() * red.size()));
                kaijiang.add(hong);
                red.remove(hong);
            }
            String lan = blue.get((int) (Math.random() * blue.size()));
            kaijiang.add(lan);
            System.out.println("本期双色球开奖：" + kaijiang);
            //kaijiangList.add(kaijiang);


            if (kaijiang.contains("1")) {
                red1++;
            }
            if (kaijiang.contains("2")) {
                red2++;
            }
            if (kaijiang.contains("3")) {
                red3++;
            }
            if (kaijiang.contains("4")) {
                red4++;
            }
            if (kaijiang.contains("5")) {
                red5++;
            }
            if (kaijiang.contains("6")) {
                red6++;
            }
            if (kaijiang.contains("7")) {
                red7++;
            }
            if (kaijiang.contains("8")) {
                red8++;
            }
            if (kaijiang.contains("9")) {
                red9++;
            }
            if (kaijiang.contains("10")) {
                red10++;
            }
            if (kaijiang.contains("11")) {
                red11++;
            }
            if (kaijiang.contains("12")) {
                red12++;
            }
            if (kaijiang.contains("13")) {
                red13++;
            }
            if (kaijiang.contains("14")) {
                red14++;
            }
            if (kaijiang.contains("15")) {
                red15++;
            }
            if (kaijiang.contains("16")) {
                red16++;
            }
            if (kaijiang.contains("17")) {
                red17++;
            }
            if (kaijiang.contains("18")) {
                red18++;
            }
            if (kaijiang.contains("19")) {
                red19++;
            }
            if (kaijiang.contains("20")) {
                red20++;
            }
            if (kaijiang.contains("21")) {
                red21++;
            }
            if (kaijiang.contains("22")) {
                red22++;
            }
            if (kaijiang.contains("23")) {
                red23++;
            }
            if (kaijiang.contains("24")) {
                red24++;
            }
            if (kaijiang.contains("25")) {
                red25++;
            }
            if (kaijiang.contains("26")) {
                red26++;
            }
            if (kaijiang.contains("27")) {
                red27++;
            }
            if (kaijiang.contains("28")) {
                red28++;
            }
            if (kaijiang.contains("29")) {
                red29++;
            }
            if (kaijiang.contains("30")) {
                red30++;
            }
            if (kaijiang.contains("31")) {
                red31++;
            }
            if (kaijiang.contains("32")) {
                red32++;
            }
            if (kaijiang.contains("33")) {
                red33++;
            }
            if (kaijiang.contains("+1")) {
                blue1++;
            }
            if (kaijiang.contains("+2")) {
                blue2++;
            }
            if (kaijiang.contains("+3")) {
                blue3++;
            }
            if (kaijiang.contains("+4")) {
                blue4++;
            }
            if (kaijiang.contains("+5")) {
                blue5++;
            }
            if (kaijiang.contains("+6")) {
                blue6++;
            }
            if (kaijiang.contains("+7")) {
                blue7++;
            }
            if (kaijiang.contains("+8")) {
                blue8++;
            }
            if (kaijiang.contains("+9")) {
                blue9++;
            }
            if (kaijiang.contains("+10")) {
                blue10++;
            }
            if (kaijiang.contains("+11")) {
                blue11++;
            }
            if (kaijiang.contains("+12")) {
                blue12++;
            }
            if (kaijiang.contains("+13")) {
                blue13++;
            }
            if (kaijiang.contains("+14")) {
                blue14++;
            }
            if (kaijiang.contains("+15")) {
                blue15++;
            }
            if (kaijiang.contains("+16")) {
                blue16++;
            }
        }
        System.out.println("--------------------统计--------------------");
        System.out.println("红1出现：  "+red1+"   次");
        System.out.println("红2出现：  "+red2+"   次");
        System.out.println("红3出现：  "+red3+"   次");
        System.out.println("红4出现：  "+red4+"   次");
        System.out.println("红5出现：  "+red5+"   次");
        System.out.println("红6出现：  "+red6+"   次");
        System.out.println("红7出现：  "+red7+"   次");
        System.out.println("红8出现：  "+red8+"   次");
        System.out.println("红9出现：  "+red9+"   次");
        System.out.println("红10出现：  "+red10+"   次");
        System.out.println("红11出现：  "+red11+"   次");
        System.out.println("红12出现：  "+red12+"   次");
        System.out.println("红13出现：  "+red13+"   次");
        System.out.println("红14出现：  "+red14+"   次");
        System.out.println("红15出现：  "+red15+"   次");
        System.out.println("红16出现：  "+red16+"   次");
        System.out.println("红17出现：  "+red17+"   次");
        System.out.println("红18出现：  "+red18+"   次");
        System.out.println("红19出现：  "+red19+"   次");
        System.out.println("红20出现：  "+red20+"   次");
        System.out.println("红21出现：  "+red21+"   次");
        System.out.println("红22出现：  "+red22+"   次");
        System.out.println("红23出现：  "+red23+"   次");
        System.out.println("红24出现：  "+red24+"   次");
        System.out.println("红25出现：  "+red25+"   次");
        System.out.println("红26出现：  "+red26+"   次");
        System.out.println("红27出现：  "+red27+"   次");
        System.out.println("红28出现：  "+red28+"   次");
        System.out.println("红29出现：  "+red29+"   次");
        System.out.println("红30出现：  "+red30+"   次");
        System.out.println("红31出现：  "+red31+"   次");
        System.out.println("红32出现：  "+red32+"   次");
        System.out.println("红33出现：  "+red33+"   次");
        System.out.println("----------------------------------");
        System.out.println("蓝1出现：  "+blue1+"   次");
        System.out.println("蓝2出现：  "+blue2+"   次");
        System.out.println("蓝3出现：  "+blue3+"   次");
        System.out.println("蓝4出现：  "+blue4+"   次");
        System.out.println("蓝5出现：  "+blue5+"   次");
        System.out.println("蓝6出现：  "+blue6+"   次");
        System.out.println("蓝7出现：  "+blue7+"   次");
        System.out.println("蓝8出现：  "+blue8+"   次");
        System.out.println("蓝9出现：  "+blue9+"   次");
        System.out.println("蓝10出现：  "+blue10+"   次");
        System.out.println("蓝11出现：  "+blue11+"   次");
        System.out.println("蓝12出现：  "+blue12+"   次");
        System.out.println("蓝13出现：  "+blue13+"   次");
        System.out.println("蓝14出现：  "+blue14+"   次");
        System.out.println("蓝15出现：  "+blue15+"   次");
        System.out.println("蓝16出现：  "+blue16+"   次");
    }


    public static void qilecai() {
        String[] balls = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        int ball1 = 0;
        int ball2 = 0;
        int ball3 = 0;
        int ball4 = 0;
        int ball5 = 0;
        int ball6 = 0;
        int ball7 = 0;
        int ball8 = 0;
        int ball9 = 0;
        int ball10 = 0;
        int ball11 = 0;
        int ball12 = 0;
        int ball13 = 0;
        int ball14 = 0;
        int ball15 = 0;
        int ball16 = 0;
        int ball17 = 0;
        int ball18 = 0;
        int ball19 = 0;
        int ball20 = 0;
        int ball21 = 0;
        int ball22 = 0;
        int ball23 = 0;
        int ball24 = 0;
        int ball25 = 0;
        int ball26 = 0;
        int ball27 = 0;
        int ball28 = 0;
        int ball29 = 0;
        int ball30 = 0;
        for (int t = 0; t < 100; t++) {
            List<String> kaijiang = new ArrayList<>();
            List<String> ballList = new ArrayList(Arrays.asList(balls));
            for (int i = 0; i < 7; i++) {
                String ball = ballList.get((int) (Math.random() * ballList.size()));
                kaijiang.add(ball);
                ballList.remove(ball);
            }
            System.out.println("本期七乐彩开奖：" + kaijiang);


            if (kaijiang.contains("1")) {
                ball1++;
            }
            if (kaijiang.contains("2")) {
                ball2++;
            }
            if (kaijiang.contains("3")) {
                ball3++;
            }
            if (kaijiang.contains("4")) {
                ball4++;
            }
            if (kaijiang.contains("5")) {
                ball5++;
            }
            if (kaijiang.contains("6")) {
                ball6++;
            }
            if (kaijiang.contains("7")) {
                ball7++;
            }
            if (kaijiang.contains("8")) {
                ball8++;
            }
            if (kaijiang.contains("9")) {
                ball9++;
            }
            if (kaijiang.contains("10")) {
                ball10++;
            }
            if (kaijiang.contains("11")) {
                ball11++;
            }
            if (kaijiang.contains("12")) {
                ball12++;
            }
            if (kaijiang.contains("13")) {
                ball13++;
            }
            if (kaijiang.contains("14")) {
                ball14++;
            }
            if (kaijiang.contains("15")) {
                ball15++;
            }
            if (kaijiang.contains("16")) {
                ball16++;
            }
            if (kaijiang.contains("17")) {
                ball17++;
            }
            if (kaijiang.contains("18")) {
                ball18++;
            }
            if (kaijiang.contains("19")) {
                ball19++;
            }
            if (kaijiang.contains("20")) {
                ball20++;
            }
            if (kaijiang.contains("21")) {
                ball21++;
            }
            if (kaijiang.contains("22")) {
                ball22++;
            }
            if (kaijiang.contains("23")) {
                ball23++;
            }
            if (kaijiang.contains("24")) {
                ball24++;
            }
            if (kaijiang.contains("25")) {
                ball25++;
            }
            if (kaijiang.contains("26")) {
                ball26++;
            }
            if (kaijiang.contains("27")) {
                ball27++;
            }
            if (kaijiang.contains("28")) {
                ball28++;
            }
            if (kaijiang.contains("29")) {
                ball29++;
            }
            if (kaijiang.contains("30")) {
                ball30++;
            }

        }
        System.out.println("--------------------统计--------------------");
        System.out.println("球1出现：  "+ball1+"   次");
        System.out.println("球2出现：  "+ball2+"   次");
        System.out.println("球3出现：  "+ball3+"   次");
        System.out.println("球4出现：  "+ball4+"   次");
        System.out.println("球5出现：  "+ball5+"   次");
        System.out.println("球6出现：  "+ball6+"   次");
        System.out.println("球7出现：  "+ball7+"   次");
        System.out.println("球8出现：  "+ball8+"   次");
        System.out.println("球9出现：  "+ball9+"   次");
        System.out.println("球10出现：  "+ball10+"   次");
        System.out.println("球11出现：  "+ball11+"   次");
        System.out.println("球12出现：  "+ball12+"   次");
        System.out.println("球13出现：  "+ball13+"   次");
        System.out.println("球14出现：  "+ball14+"   次");
        System.out.println("球15出现：  "+ball15+"   次");
        System.out.println("球16出现：  "+ball16+"   次");
        System.out.println("球17出现：  "+ball17+"   次");
        System.out.println("球18出现：  "+ball18+"   次");
        System.out.println("球19出现：  "+ball19+"   次");
        System.out.println("球20出现：  "+ball20+"   次");
        System.out.println("球21出现：  "+ball21+"   次");
        System.out.println("球22出现：  "+ball22+"   次");
        System.out.println("球23出现：  "+ball23+"   次");
        System.out.println("球24出现：  "+ball24+"   次");
        System.out.println("球25出现：  "+ball25+"   次");
        System.out.println("球26出现：  "+ball26+"   次");
        System.out.println("球27出现：  "+ball27+"   次");
        System.out.println("球28出现：  "+ball28+"   次");
        System.out.println("球29出现：  "+ball29+"   次");
        System.out.println("球30出现：  "+ball30+"   次");

    }

    public static void jiafabiao() {
        System.out.println("99加法表：");
        for (int i = 1; i <= 9; i++) {
            for (int t = 1; t <= 9; t++) {
                System.out.print(i + "+" + t + "=" + (i + t) + "  ");
                if (t == i) {
                    System.out.println("");
                    break;
                }
            }
        }
    }

    public static List<String> xipai() {
        List<String> newPai = new ArrayList<>();
        List<String> t = new ArrayList<>(Arrays.asList(puke));
        while (newPai.size() < 54) {
            String pai = t.get((int) (Math.random() * t.size()));
            newPai.add(pai);
            t.remove(pai);

        }
        System.out.println(newPai);
        return newPai;
    }


    public static void zhajinhua() {
        List<String> pai = xipai();
        List<String> shihao = new ArrayList<>();
        List<String> yefan = new ArrayList<>();
        List<String> xiaoyan = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            shihao.add(pai.get(i));
            i++;
            yefan.add(pai.get(i));
            i++;
            xiaoyan.add(pai.get(i));
        }
        System.out.println("炸金花开始：");
        System.out.println("石昊：" + shihao);
        System.out.println("叶凡：" + yefan);
        System.out.println("萧炎：" + xiaoyan);
    }

    public static void doudizhu() {
        System.out.println("斗地主开始，洗牌：");
        List<String> pai = xipai();
        String dizhupai = pai.get((int) (Math.random() * 54));
        System.out.println("地主牌：" + dizhupai);
        List<String> shihao = new ArrayList<>();
        List<String> yefan = new ArrayList<>();
        List<String> xiaoyan = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            shihao.add(pai.get(i));
            i++;
            yefan.add(pai.get(i));
            i++;
            xiaoyan.add(pai.get(i));
        }
        List<String> sanzhang = new ArrayList<>();
        sanzhang.add(pai.get(51));
        sanzhang.add(pai.get(52));
        sanzhang.add(pai.get(53));
        System.out.println("余三张：" + sanzhang);
        //谁是地主
        String dizhu = "";
        if (shihao.contains(dizhupai)) {
            dizhu = "石昊";
            shihao.addAll(sanzhang);
            System.out.println("地主是：" + dizhu);
            System.out.println("👲石昊：" + shihao);
            System.out.println("叶凡：" + yefan);
            System.out.println("萧炎：" + xiaoyan);
        }
        if (yefan.contains(dizhupai)) {
            dizhu = "叶凡";
            yefan.addAll(sanzhang);
            System.out.println("地主是：" + dizhu);
            System.out.println("👲叶凡：" + yefan);
            System.out.println("石昊：" + shihao);
            System.out.println("萧炎：" + xiaoyan);
        }
        if (xiaoyan.contains(dizhupai)) {
            dizhu = "萧炎";
            xiaoyan.addAll(sanzhang);
            System.out.println("地主是：" + dizhu);
            System.out.println("👲萧炎：" + xiaoyan);
            System.out.println("叶凡：" + yefan);
            System.out.println("石昊：" + shihao);
        }

    }


    public static boolean aa() {
        System.out.print("hello ");
        return false;
    }


    public static int getAa() {
        int i = 5;
        int y = 8;
        System.out.print("");
        return 0;
    }

    public static void getXing(int row){
        //非奇数行不可执行
        if(row%2!=1){
            System.out.println("行数必须为奇数");
        }
        for(int i=1;i<=row;i++){
            for(int t=1;t<=row;t++)
            //行数小于row的1/2时
            if(i<row/2){
                if(t!=(row/2)){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            //行数等于row的1/2时
            if(i==row/2){

            }
            //行数大于row的1/2
            if(i>row/2){

            }

        }
    }



}
