package com.example.demoinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoInjectionApplication {

    public static void main(String[] args) {
        var ctx =SpringApplication.run(DemoInjectionApplication.class, args);
        BinarySearchImpl binarySearch = ctx.getBean(BinarySearchImpl.class);
        int res = binarySearch.binarySearch(new int[] {2,1,4,6,5},6);
        System.out.println(res);

    }

}
