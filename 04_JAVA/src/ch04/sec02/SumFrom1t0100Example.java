package ch04.sec02;

public class SumFrom1t0100Example {
    public static void main(String[] args){
        int sum = 0;
        int i = 1;
        while(i<=100){
            sum += i;
            i++;
        }
        System.out.println("1~100 합: " + sum);
    }
}
