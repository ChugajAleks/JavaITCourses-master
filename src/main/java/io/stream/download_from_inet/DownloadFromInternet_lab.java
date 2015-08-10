package io.stream.download_from_inet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * User: Igor Russo
 * Date: 22.02.13
 * Time: 22:43
 */
public class DownloadFromInternet_lab {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        InputStream in = url.openStream();
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char) b);
        }
        in.close();
    }
}
