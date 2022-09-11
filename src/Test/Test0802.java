package Test;

import java.io.*;
import java.util.function.Function;

public class Test0802 {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/liangke/Downloads/temp.txt";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/liangke/Downloads/job.txt");
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
        FileOutputStream fileOutputStream1 = new FileOutputStream("/Users/liangke/Downloads/mem.txt");
        OutputStreamWriter writer1 = new OutputStreamWriter(fileOutputStream1, "UTF-8");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String s = "^[a-zA-z]{1}.*$";
        String s1 = "^[0-9]{1}.*$";
        String line = null;
        while ((line = reader.readLine()) != null) {
            String str = line;
            if(str.matches(s)){
                writer.append(str);
                writer.append("\n");
            }else if(str.contains("G")){
                writer1.append(str);
                writer1.append("\n");
            }
        }
        reader.close();
        fileInputStream.close();
        writer.close();
        fileOutputStream.close();
        writer1.close();
        fileOutputStream1.close();
    }
}
