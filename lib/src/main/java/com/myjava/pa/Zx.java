package com.myjava.pa;

public class Zx {
    public Zx() {

    }

    public static void  setTR(Call call){
        call.sd("fd");
    }

//    public int getS() {
//        return sg;
//    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Zx z = new Zx();
        Zx x = new Zx();
         z.setTR(new Call() {
             @Override
             public void sd(String s) {
                 System.out.println(s);
             }
         });
    }


    interface Call{
        void sd(String s);
    }
}
