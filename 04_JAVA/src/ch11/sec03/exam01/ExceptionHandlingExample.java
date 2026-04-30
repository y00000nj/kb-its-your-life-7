package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array={"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);

            System.out.println("array[" + i + "]: " + value);
        } catch (Exception e){
                //1. 에러의 간단한 이유만 알고 싶을 때
                System.out.println("에러 원인: " + e.getMessage());
                //2. 에러의 정확한 이름과 이유를 같이 알고 싶을 때
                //System.out.println("에러 종류: " + e.toString());
                //3. 에러발생 위치까지 모두 추적하고 싶을 때
                //e.printStackTrace();
            }
        }
    }
}
