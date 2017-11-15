package com.hencoder.hencoderpracticedraw1.practice;

import java.util.Date;

/**
 * Created by regan.chon on 2017/11/15.
 */

public class TestValueTranslate {

    public static void main(String[] args) {


        Date d1 = new Date(" 1 Apr 98");

        int a = 5;
        Integer ai = 5;
        nextDateUpdate(d1, a, ai);
        System.out.println("2:    " + d1 + "  ,  " + a);

        nextReplace(d1, a, ai);
        System.out.println("4:    " + d1 + "  ,  " + a);

    }

    public static void nextDateUpdate(Date date, int a, Integer ai) {
        System.out.println("1:    " + date);
        date.setDate(date.getDate() + 1);

        System.out.println("1-1:    " + a);
        a = a + 1;
//
//        ai=ai+1;
//        System.out.println("1-2:    " + ai);
    }

    public static void nextReplace(Date date, int a, Integer ai) {
        //用函数对象取代函数，在函数体过长情况下使用
        new NextReplace(date, a).compute();
    }


}
