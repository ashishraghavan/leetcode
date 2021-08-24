package com.leetcode.strings;

public class DefangingIPAddress {

    public static void main(String[] args){
        String ipAddress = "1.1.1.1";
        String invalidIpAddress = "192.168.0.";//192..168.0.0
        System.out.println(defangIPaddr(ipAddress));
    }

    static String defangIPaddr(String address) {
        String[] splitStr = address.split("\\.");
        if(splitStr.length != 4) {
            return "Not a valid IPV4 address";
        }
        StringBuilder stringBuilder = new StringBuilder(splitStr[0]);
        for(int i = 1;i<splitStr.length - 1;i++) {
            stringBuilder.append("[.]").append(splitStr[i]);
        }
        stringBuilder.append("[.]").append(splitStr[splitStr.length - 1]);
        return stringBuilder.toString();
    }
}
