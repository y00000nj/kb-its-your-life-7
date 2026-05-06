package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try(InputStream is = new FileInputStream("C:\\Users\\student\\Desktop\\yj\\kb-its-your-life-7\\04_JAVA\\src\\ch18\\test1.db")){
            while (true){
                int data = is.read(); //1 byte씩 읽기
                if(data == -1) break; //파일 끝에 도달했을 경우
                System.out.println(data);
            }
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
