package com.disorn;

import java.io.File;
import java.util.Scanner;

public class PreProcess {

    private int answerAMT;
    private char[] data;

    public PreProcess(String fileName) {
        File file = new File(fileName);
        try{
            Scanner fileReader = new Scanner(file);
            String line = fileReader.nextLine();
            data = line.trim().toCharArray();
            this.answerAMT = fileReader.nextInt();
            fileReader.close();
        }catch (Exception e){
        }
    }

    public byte[] mapGP(char[] data){
        byte[] processedData = new byte[data.length];
        for (int i=0;i<data.length;i++) {
            processedData[i] = isG(data[i]);
        }
        return processedData;
    }

    public int getAnswerAMT() {
        return answerAMT;
    }

    private static byte isG(char character){
        return (byte) (character == 'G'? 1:0);
    }

}
