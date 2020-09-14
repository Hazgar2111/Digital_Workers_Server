package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEst {
    public static ArrayList<File> getFiles(String path)
    {
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
       String path1 = filePath + "\\src\\sample\\PrivateAffair\\" + path;
       File dir = new File(path1); //path указывает на директорию
       File[] arrFiles = dir.listFiles();

       assert arrFiles != null;
       //System.out.println(arrFiles[0]);
       List<File> lst = Arrays.asList(arrFiles);
        return new ArrayList<>(lst);
    }
    public static void main(String[] args) {
        getFiles("СташинФёдор");
    }
}
