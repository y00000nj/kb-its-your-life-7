package ch17.sec10;

import java.util.Arrays;

public class AggreagateExample {
    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 5};

        //2의 배수 카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        //2의 배수의 합
        long sum = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        //2의 배수의 평균
        double avg = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        // 최댓값
        int max = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        //최솟값
        int min = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .min()
                .getAsInt();
        System.out.println("최소값 : " + min);
    }
}
