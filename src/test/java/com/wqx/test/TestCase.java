package com.wqx.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCase {
    @Test
    public void test() {

    }

    @Test
    public void test1() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\1.ppt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        fileInputStream.read(bytes);
        //转换成16进制
        toHex(bytes);
    }

    private String toHex( byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for(byte b : bytes){
            int i = b & 0xff;
           sb.append(Integer.toHexString(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}
