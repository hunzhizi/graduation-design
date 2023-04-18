package com.hunzhizi.tool;

import java.util.Arrays;

/**
 * @author 魂之子
 * @since 2023-03-13 13:00
 * program: graduation-design
 * description:
 */
public class ConvertRGB {
    public static String int2Hex(Integer r,Integer g,Integer b){
        return "#"+toHexString(r) + toHexString(g) + toHexString(b);

    }

    /**
     * 由int返回string 保留两位
     * @param i
     * @return
     */
    public static String toHexString(int i){
        String res = Integer.toHexString(i);
        if(res.length()==1){
            res = "0" + res;
        }
        return res;
    }
    public static int[] hex2int(String rgb){
        char[] chars = rgb.toCharArray();
        String r = "" + chars[1] + chars[2];
        String g = "" + chars[3] + chars[4];
        String b = "" + chars[5] + chars[6];
        int[] ints = new int[3];
        ints[0] = Integer.parseInt(r,16);
        ints[1] = Integer.parseInt(g,16);
        ints[2] = Integer.parseInt(b,16);
        return ints;
    }

    public static int[] parsePyReturnValue(String rgb){
        char[] chars = rgb.toCharArray();
        int j = 0;
        int[] res = new int[3];
        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < chars.length-1; i++) {
            if(chars[i] == ' '){
                if(temp.length()!=0){
                    res[j++] = Integer.parseInt(temp.toString());
                    temp = new StringBuilder();
                }
                continue;
            }
            temp.append(chars[i]);
        }
        res[j] = Integer.parseInt(temp.toString());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(int2Hex(255, 255, 255));
        int[] ints = hex2int("#ffffff");
        System.out.println(Arrays.toString(ints));

        int[] a = parsePyReturnValue("[  7  30   3]");
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
    }
}
