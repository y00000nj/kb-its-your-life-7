package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMappingExample {
    public static void main(String[] args) {
        //문장 스트림을 단어 스트림으로 변환
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream()
                //.map(data -> Arrays.stream(data.split(" ")))
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach( word -> System.out.println(word));
    }
}
