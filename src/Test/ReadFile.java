package Test;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/liangke/Downloads/temp1.txt";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/liangke/Downloads/jobId.txt");
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
        FileOutputStream fileOutputStream1 = new FileOutputStream("/Users/liangke/Downloads/cpu.txt");
        OutputStreamWriter writer1 = new OutputStreamWriter(fileOutputStream1, "UTF-8");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String s = "^[a-zA-z]{1}.*$";
        String s1 = "^[0-9]{1}.*$";
        String line = null;
        while ((line = reader.readLine()) != null) {
            String str = line;
            if(str.contains("-")){
                writer.append(str);
                writer.append("\n");
            }else if(str.contains(".")){
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
