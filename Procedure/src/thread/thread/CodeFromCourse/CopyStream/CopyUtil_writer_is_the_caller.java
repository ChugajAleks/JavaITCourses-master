package thread.thread.CodeFromCourse.CopyStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by aleks on 02.09.15.
 */
public class CopyUtil_writer_is_the_caller {
    //В последнем двупоточном решении мы стартуем два потока – для чтения и для записи.
// Перепишите код, что бы чтение осуществлялось в новом потоке, а запись производилась потоком,
// вызвавшим copy(…). Кстати, тогда можно будет избавиться от пары join-ов, так как поток на
// принимающем конце буфера знает, когда закончились данные.
    public static void copyMultiThreaf(final InputStream src, final OutputStream dst) throws IOException {
        // reader-to-writer byte[]-channel
        final BlockingQueue<byte[]> buffer = new ArrayBlockingQueue<>(2);
        // exception-channel from reader/writer threads?
        final AtomicReference<Throwable> ex = new AtomicReference<>();
        final ThreadGroup group = new ThreadGroup("read-write") {
            public void uncaughtException(Thread t, Throwable e) {
                ex.set(e);
            }
        };
        // reader from 'src'
        Thread reader = new Thread(group, new Runnable() {
            @Override
            public void run() {
                try (InputStream src0 = src) {              // 'src0' for auto-closing
                    while (true) {
                        byte[] data = new byte[128];        // new data buffer
                        int count = src.read(data, 1, 127); // read up to 127 bytes
                        data[0] = (byte) count;             // 0-byte is length-field
                        buffer.put(data);                   // send to writer
                        if (count == -1) {
                            break;
                        }           // src empty
                    }
                } catch (Exception e) {
                    group.interrupt();
                }  // interrupt writer
            }
        });
        reader.start();
        // writer to 'dst'

        try (OutputStream dst0 = dst) {      // 'dst0' for auto-closing
            while (true) {
                byte[] data = buffer.take(); // get new data from reader
                if (data[0] == -1) {
                    break;
                }  // its last data
                dst.write(data, 1, data[0]); //
            }
        } catch (Exception e) {
            group.interrupt();
        }  // interrupt writer

        if (ex.get() != null) {
            throw new IOException(ex.get());
        }
    }
}


