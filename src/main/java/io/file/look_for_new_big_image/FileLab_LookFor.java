package io.file.look_for_new_big_image;

import java.io.File;

/**
 * User: Igor Russo
 * Date: 23.02.13
 * Time: 11:44
 */
public class FileLab_LookFor {
    public static void main(String[] args) {
        File file = new File("d:/tmp");
        print(file);
    }

    public static void print(File root) {
        if (root.isFile()) {

        } else {
            File[] fileArray = root.listFiles();
            for (File file : fileArray) {
                print(file);
            }
        }
    }
}
