package ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws Exception {
        // --- 1. 기본 스트림용 경로 설정 ---
        String originalFilePath1 = "C:/Users/student/Desktop/yj/kb-its-your-life-7/04_JAVA/src/ch18/sec07/exam01/kirby.jpg";
        String targetFilePath1 = "C:/Users/student/Desktop/yj/kb-its-your-life-7/04_JAVA/src/ch18/sec07/exam01/test.jpg";

        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        // --- 2. 버퍼 보조 스트림용 경로 설정 ---
        // originalFile2.jpg도 같은 폴더에 있다고 가정하고 경로를 맞췄습니다.
        String originalFilePath2 = "C:/Users/student/Desktop/yj/kb-its-your-life-7/04_JAVA/src/ch18/sec07/exam01/kirby.jpg";
        String targetFilePath2 = "C:/Users/student/Desktop/yj/kb-its-your-life-7/04_JAVA/src/ch18/sec07/exam01/test2.jpg";

        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

        // 성능 향상을 위한 버퍼 스트림 연결
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 버퍼를 사용하지 않고 복사 (1바이트씩 직접 읽고 쓰기)
        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용:\t" + nonBufferTime + " ns");

        // 버퍼를 사용하여 복사 (바구니에 담아서 한꺼번에 처리)
        long bufferTime = copy(bis, bos);
        System.out.println("버퍼 사용:\t" + bufferTime + " ns");

        // 사용한 자원은 반드시 닫아줘야 합니다.
        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }

    public static long copy(InputStream is, OutputStream os) throws Exception {
        long start = System.nanoTime();
        while(true) {
            int data = is.read();
            if(data == -1) break;
            os.write(data);
        }
        os.flush();
        long end = System.nanoTime();
        return (end - start);
    }
}