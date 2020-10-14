package view;

import java.util.Arrays;

/**
 * @author xuxingjun
 * @data 2020/10/14  -  18:39
 */
public class test {
    public static void main(String[] args) {

        String str = "12310";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = chars[i] - '0';
            System.out.println("i1 = " + i1);
        }


    }
}
