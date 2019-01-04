package com.jayne.book;

/**
 * 计算最大公约数
 *
 * Created by vikin on 2018/12/11.
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcd(9, 3));
        System.out.println(gcd(3, 9));
        System.out.println(gcd(55, 22));
    }

    public static int gcd(int p, int q){
        if(q == 0){
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
