package com.jw.teammakter.common.util;

public class CommonUtil {
    public static int randomIntGenerateOnRange(int min, int max){
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
