package com.hencoder.hencoderpracticedraw1.practice;

import java.util.Date;

/**
 * The Sample of Replace Method with Method Object
 *
 * Created by regan.chon on 2017/11/15.
 */

public class NextReplace {

    private Date date;
    private int a;

    public NextReplace(Date date, int a) {
        this.date = date;
        this.a = a;
    }

    public void compute() {
        date = new Date(date.getYear(), date.getMonth(), date.getDate() + 1);
        System.out.println("3:    " + date);

        int a1 = a + 1;
        System.out.println("3-1:    " + a1);
//  and so on!
//        ai=new Integer(ai+1);
//        System.out.println("3-2:    " + ai);
    }
}
