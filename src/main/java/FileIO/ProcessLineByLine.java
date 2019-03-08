package main.java.FileIO;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ryan on 17/1/18.
 */
public class ProcessLineByLine {

    static List<String> lines = new LinkedList<>();

    private static void readFile(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String path, int sizePerLine) throws IOException {
        List<String> idsToWrite = new LinkedList<>();
        for (int i = 0; i< lines.size(); i+=sizePerLine) {
            String temp = lines.get(i);
            String[] codes = temp.split("\t");
            String[] isos = codes[2].split(" ");
            idsToWrite.add("\"" + codes[0] + "\":\"+" + codes[1] + "\",");
        }
        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (String line:idsToWrite) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    private static int firstDigit(String s) {
        Matcher matcher = Pattern.compile("\\d+").matcher(s);
        matcher.find();
        return s.indexOf(matcher.group());
    }

    public static void main(String[] args) throws IOException{
        readFile("/Users/wyao/LD-Work/dial");
        //writeFile("/Users/Ryan/Documents/Agoda-Projects/output.txt", 1);
        writeFile("/Users/wyao/LD-Work/js.txt", 1);
    }
}
