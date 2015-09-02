package thread.thread.CodeFromCourse.CopyStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by aleks on 02.09.15.
 */
//Это реализация однопоточного побайтового копировальщика из InputStream в OutputStream.
// Копирование происходит в потоке вызвавшем метод copy(…)
public class CopyUtil {
    public static void copy(InputStream src, OutputStream dest) throws IOException {
        try(InputStream srcTmp = src; OutputStream destTemp = dest) {
            int partOfData;
            while ((partOfData = srcTmp.read()) != -1) {
                destTemp.write(partOfData);
            }
        }

    }
//Это реализация однопоточного копировальщика массивами из InputStream в OutputStream.
// Копирование происходит в потоке вызвавшем метод copy(…)
    public static void copyArray(InputStream src, OutputStream dest) throws IOException {
        byte[] buff = new byte[10];
        int count = 0;
        while ((count = src.read(buff)) != -1){
            dest.write(buff, 0, count);
        }
    }
}
