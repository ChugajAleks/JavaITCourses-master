package io.stream.download_from_inet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * User: Igor Russo
 * Date: 22.02.13
 * Time: 22:43
 */
public class DownloadFromInternet_My {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        try(InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();){
            int count;
            byte[] buff = new byte[1024];
            while((count = in.read(buff)) != -1){
                out.write(buff, 0, count);
            }
            //String html = new String(out.toByteArray(), StandardCharsets.US_ASCII);
            System.out.println(new String(out.toByteArray(), StandardCharsets.US_ASCII));
        }
    }
}
