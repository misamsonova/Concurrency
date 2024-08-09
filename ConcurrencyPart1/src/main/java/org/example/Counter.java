package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger value = new AtomicInteger();

    public void inc(){
        value.getAndIncrement();
    }

    public void dec(){
        value.getAndDecrement();
    }

    public int getValue() {
        return value.intValue();
    }


   /* private int value2;

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    public void inc(){

        synchronized (monitor1){
            value++;
        }
    }


    // То же самое
    *//* public void inc(){
        synchronized (this){
        value++;
        }
    }*//*
    public void dec(){
        synchronized (monitor1){
            value--;
        }
    }

    public int getValue() {
        return value;
    }

    public void inc2(){
        synchronized (monitor2){
            value2++;
        }
    }

    public void dec2(){
        synchronized (monitor2){
            value2--;
        }
    }

    public int getValue2() {
        return value2;
    }*/


}
