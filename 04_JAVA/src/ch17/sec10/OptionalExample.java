package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        double avg = list.stream()
//                        .mapToInt(Integer::intValue)
//                        .average()
//                        .getAsDouble();

        double avg = list.stream()
                        .mapToInt(Integer :: intValue)
                                .average()
                                        .orElse(0.0);
        System.out.println("방법2_평균: " + avg);


        System.out.println("평균: " + avg);
    }

}
