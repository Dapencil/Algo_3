package com.disorn;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PreProcess init = new PreProcess("Lab3example.txt");
        int pairAmt = 0;
        final int k = init.getK();
        byte[] data = init.mapGP();
//        byte[] data = {1,1,0,0,1,0};
        int[] pairMap = new int[data.length];
        Arrays.fill(pairMap,-1);

        //solver
        for(int i = 0;i< pairMap.length - k + 1;i++){
            for(int radar = k;radar>0;radar--){
                if(i+radar > pairMap.length-1)continue;
                boolean isDiff = (data[i] ^ data[i+radar]) == 1;

                //get pair
                if(isDiff && !isPaired(pairMap,i,i+radar)){
                    pairMap[i] = i+radar;
                    pairMap[i+radar] = i;
                    pairAmt++;
                    System.out.println(Arrays.toString(pairMap));
                }
            }
        }
        System.out.println(pairAmt);

    }

    public static boolean isPaired(int[] pairMap,int i,int j){
        return pairMap[i] > -1 || pairMap[j] > -1;
    }
}