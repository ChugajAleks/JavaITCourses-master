package io.file.look_for_new_big_image;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * User: Igor Russo
 * Date: 23.02.13
 * Time: 11:44
 */
public class FileLab_LookFor_solution {
    public static final String[] acceptableFileExtensions = new String[]{"jpg", "png", "gif"};


    public static FileFilter fileFilter;
    public static FileFilter folderFilter;
    public static File[] mFileArray = {};

    public static void main(String[] args) {
        File file = new File("e:/books");
        fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return checkIfFileIsBigImage(file);
            }
        };

        folderFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };

        print(file);
        System.out.println(Arrays.toString(mFileArray));
    }

    public static void print(File root) {
        if (root.isFile()) {
            if (checkIfFileIsBigImage(root)) {
                File[] fArr = {root};
                mFileArray = fArr;
            }

        } else {
            mFileArray = concatenate(mFileArray, root.listFiles(fileFilter));
            File[] folderArray = root.listFiles(folderFilter);

            for (File file : folderArray) {
                print(file);
            }
        }
    }

    public static File[] concatenate(File[] file0, File[] file1) {
        File[] result = new File[file0.length + file1.length];
        System.arraycopy(file0, 0, result, 0, file0.length);
        System.arraycopy(file1, 0, result, file0.length, file1.length);
        return result;
    }

    public static boolean checkIfFileIsBigImage(File file) {
        if (file.isFile() && file.length() > 1024 * 1024) {
            for (String extension : acceptableFileExtensions) {
                if (file.getName().toLowerCase().endsWith(extension)) {
                    return true;
                }
            }
        }
        return false;
    }
}
