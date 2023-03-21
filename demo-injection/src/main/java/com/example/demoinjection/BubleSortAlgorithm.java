package com.example.demoinjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("BubleSort")
//@Primary
public class BubleSortAlgorithm implements SortAlgorithm{
    public int[] sort(int[] numbers){
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (numbers[j] > numbers[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
        return numbers;
    }
}
