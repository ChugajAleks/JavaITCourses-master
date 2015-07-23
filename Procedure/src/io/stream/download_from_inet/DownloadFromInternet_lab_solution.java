package io.stream.download_from_inet;

import java.io.*;
import java.net.URL;

/**
 * User: Igor Russo
 * Date: 22.02.13
 * Time: 22:43
 */
public class DownloadFromInternet_lab_solution {

    public static final String FIRST_FILE_PATH = "d:/igorrusso.html";
    public static final String SECOND_FILE_PATH = "d:/google.html";

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://igorrusso.com");
        OutputStream out1 = null;
        OutputStream out2 = null;
        InputStream in = null;
        byte[] buff = new byte[100];
        try {
            out1 = new FileOutputStream(FIRST_FILE_PATH, false);
            out2 = new FileOutputStream(SECOND_FILE_PATH, false);
            in = url.openStream();
            while (in.read(buff) != -1) {
                out1.write(buff);
                out2.write(buff);
            }
        } catch (IOException ioe){
            if(out1 != null)out1.close();
            System.out.println("First file delete: " + new File(FIRST_FILE_PATH).delete());
            if(out2 != null)out2.close();
            System.out.println("Second file delete: " + new File(SECOND_FILE_PATH).delete());

            throw new IOException("IOException happened while writing files", ioe);
        } finally {
            if(in != null)in.close();
            if(out1 != null)out1.close();
            if(out2 != null)out2.close();
        }
    }
}
