package com.demo.stringops;

public class StringBuilderOps {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        System.out.println("Initial Cap : " + sb.capacity());
        System.out.println("Initial Size : " + sb.length());

        sb.append("Hello World !");

        System.out.println("Cap after 1st append : " + sb.capacity());
        System.out.println("Size after 1st append : " + sb.length());

        sb.append(" Hello !");

        System.out.println("Cap after 2nd append : " + sb.capacity());
        System.out.println("Size after 2nd append : " + sb.length());

        sb.append(" This is a Sample String.");

        System.out.println("Cap after 3rd append : " + sb.capacity());
        System.out.println("Size after 3rd append : " + sb.length());

        StringBuilder sb2 = new StringBuilder("Hello World !");

        System.out.println("Second Initial Cap : " + sb2.capacity());
        System.out.println("Second Initial Size : " + sb2.length());
        System.out.println("Reversed : " + sb2.reverse());

    }

}
