package io.stream.delete_zero;

import java.io.*;
import java.util.Arrays;


public class DeleteZeroInFileStream_My {
    public static void main(String[] args) throws IOException {
        final int BUFF_SIZE = 4;
        final byte[] DATA_IN = {0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1};

        //Создаем файл 1
        try (OutputStream file = new FileOutputStream("/home/aleks/Java/JavaITCourses-master/tmp_files/1.txt")) {
            file.write(DATA_IN);
        } catch (IOException e) {
            System.out.println("Ой!");
        }
        //Сортируем данные файла 1 и записываем в файл java_out
        try (InputStream src = new FileInputStream("/home/aleks/Java/JavaITCourses-master/tmp_files/1.txt");
             OutputStream out = new FileOutputStream("/home/aleks/Java/JavaITCourses-master/tmp_files/java_out.txt")) {
            filterArray(src, out, BUFF_SIZE);
        } catch (IOException e) {
            System.out.println("Ой!!!");
        }
        //Печатаем из java_out в консоль
//        byte[] arr = new byte[10];
//        try (InputStream in = new FileInputStream("/home/aleks/Java/JavaITCourses-master/tmp_files/java_out.txt")){
//            in.read(arr);
//        }
        try(ByteArrayOutputStream buff = new ByteArrayOutputStream();
            InputStream in = new FileInputStream("/home/aleks/Java/JavaITCourses-master/tmp_files/java_out.txt");){
            copy(in, buff);
            System.out.println(Arrays.toString(buff.toByteArray()));
        }




    }

    private static void copy(InputStream in, ByteArrayOutputStream buff) throws IOException {
        byte[] tmp = new byte[8];
        int count;
        while((count = in.read(tmp)) != -1){
            buff.write(tmp, 0, count);
        }
    }

    static void filterArray(InputStream in, OutputStream out, int buffSize) throws IOException {
        final int ZERO_STATE = 0;
        final int NUMBER_STATE = 1;
        byte[] buff = new byte[buffSize];
        int count;

        while ((count = in.read(buff)) != -1) {
            int state = ZERO_STATE;
            int previousIndex = 0;
            for (int index = 0; index < count; index++) {
                switch (state) {
                    case ZERO_STATE:
                        if (buff[index] == 0)
                            state = ZERO_STATE;
                        else {
                            previousIndex = index;
                            state = NUMBER_STATE;
                        }
                        break;
                    case NUMBER_STATE:
                        if (buff[index] == 0) {
                            out.write(buff, previousIndex, index - previousIndex);
                            state = ZERO_STATE;
                        } else {
                            state = NUMBER_STATE;
                        }
                        break;
                }
            }
            if (state == ZERO_STATE) {
                state = ZERO_STATE;
            } else
                out.write(buff, previousIndex, count - previousIndex);
        }
    }


}
