package org.lee.study.generic.type;

import java.util.*;


public class GenericParadigm1 {
    public static void main(String[] args) {
        /**
         *  协变
         *  java的数组式支持协变的
         *
         */
        Integer[] integers = new Integer[3];
        Number[] numbers = new Number[3];
        numbers[0] = integers[0];
        numbers = integers; // 支持协变
        for (Number number : numbers) {
            System.out.print(number);
        }
        System.out.println();
        for (Number number : integers) {
            System.out.println(number);
        }
        /**
         * 但是list不支持协变
         */
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        List<Number> numbers1 = new ArrayList<>();
//        numbers1 = integers1; // 编译报错不支持协变？

        List<? extends Number> numbers2 = new ArrayList<>();
//        numbers2.add(new Integer(0)); // error:   capture of ? extends Number
        // 这种情况下不能添加除了 null 之外的任何实例化对象


        /**
         * 逆变
         */

        ArrayList<? super Shape> shapes0 = new ArrayList<>();
        shapes0.add(new Rectangle());
        shapes0.add(new Triangle());
        shapes0.add(new Shape());
//        shapes0.add(new Object()); // 编译不通过

        ArrayList<? extends Shape> shapes1 = new ArrayList<>();
        shapes1.add(null);
//        shapes1.add(new Rectangle()); // 编译不通过
//        shapes1.add(new Triangle()); // 编译不通过
//        shapes1.add(new Shape()); // 编译不通过
//        shapes1.add(new Object()); // 编译不通过
        // <? extends Shape> 不允许生产者是任何 除null之外的实例


    }

    /**
     * super 和 extends 的使用
     * producer use extends； consumer use super
     * 即 PECS (Producer-Extends, Consumer-Super)
     */
    private static final int COPY_THRESHOLD = 10;

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (srcSize > dest.size())
            throw new IndexOutOfBoundsException("Source does not fit in dest");

        if (srcSize < COPY_THRESHOLD ||
                (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            for (int i = 0; i < srcSize; i++)
                dest.set(i, src.get(i));
        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i = 0; i < srcSize; i++) {
                di.next();
                di.set(si.next());
            }
        }
    }
}

class Shape {

}

class Rectangle extends Shape {

}

class Triangle extends Shape {

}