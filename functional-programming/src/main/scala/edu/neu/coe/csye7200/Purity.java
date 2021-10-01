package edu.neu.coe.csye7200;

import java.lang.reflect.Field;

public class Purity {
    class MyInteger {
        int i;

        public MyInteger(int x) {
            i = x;
        }

        public int getInt() {
            return i;
        }

        public void setInt(int x) {
            i = x;
        }
    }

    // is NOT pure, because it changed outside world -`MyInteger x`
    public int getNext(MyInteger x) {
        int x1 = x.getInt() + 1;
        x.setInt(x1);
        return x1;
    }

    // throw IllegalAccessException
    public int getNext(Integer x) throws Exception {
        int result = x.intValue() + 1;
        Field f = x.getClass().getDeclaredField("value");
        f.set(x, result);   // can not access `java.lang.Integer` private final member
        return result;
    }

    // is pure
    public int getNext(int x) {
        x = x + 1;
        return x;
    }

    public static void main(String[] args) {
        Purity n = new Purity();
        int i1 = 0;
        testPurity(n.getNext(i1) == n.getNext(i1), "getNext(int)");
        MyInteger i2 = n.new MyInteger(0);
        testPurity(n.getNext(i2) == n.getNext(i2), "getNext(MyInteger)");
        Integer i3 = 0;
        try {
            testPurity(n.getNext(i3) == n.getNext(i3), "getNext(Integer)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testPurity(boolean b, String message) {

        if (b) System.out.println(message + " is pure");
        else System.out.println(message + " is not pure");
    }
}