package thread.thread.CodeFromCourse.CopyStream;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static thread.thread.CodeFromCourse.CopyStream.CopyUtil_writer_is_the_caller.copyMultiThreaf;

/**
 * Created by aleks on 02.09.15.
 */
public class DemoCopy {
    public static void main(String[] args) {
        final byte[] DATA_IN = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        byte[] dataOut;
        ByteArrayInputStream src = new ByteArrayInputStream(DATA_IN);
        ByteArrayOutputStream dest = new ByteArrayOutputStream();

        try {
            //CopyUtil.copy(src, dest);
            //CopyUtil.copyArray(src, dest);
            copyMultiThreaf(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataOut = dest.toByteArray();
        System.out.println(Arrays.toString(dataOut));
    }
}
