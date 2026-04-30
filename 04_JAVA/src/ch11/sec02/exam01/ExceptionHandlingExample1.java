package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data){
        try {
            int res = data.length();
            System.out.println("문자 수: " + res);
        } catch (NullPointerException e){
            // 1. 예외 객체의 메시지로 출력
            System.out.println(e.getMessage());
            // 2. 스택 추적 내용을 모두 출력
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
/*
* 문제점
* main 메서드에서 printLength(null);을 호출하며
* 객체가 없는 상태(null)에서 data.length() 메서드를 호출하려고 시도하는 과정에서
* NullPointerException이 발생
* */