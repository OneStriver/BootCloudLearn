package com.work.learn.test1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: HeYin
 * @date: 2020-05-19 15:27
 * @version: 1.0
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        Student student = new Student();
        Field age = student.getClass().getDeclaredField("age");
        unsafe.putInt(student,unsafe.objectFieldOffset(age),20);


    }

}

class Student {
    int age;

    public Student(){
        this.age = 10;
    }

    public int getAge(){
        return age;
    }

}

