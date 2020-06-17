package com.work.learn.test1;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @description:
 * @author: HeYin
 * @date: 2020-05-19 15:57
 * @version: 1.0
 */
public class Test3 {

    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();

        Student student1 = Student.class.newInstance();

        Student student2 = Student.class.getConstructor().newInstance();

        student.clone();



    }


    static class Student implements Cloneable, Serializable {
        int age;

        public Student(){
            this.age = 10;
        }

        public int getAge(){
            return age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}

