package com.leetcode.easy;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1048576, 1024));
    }

    private static int hammingDistance(int num1, int num2) {
        if (num1 == num2) {
            return 0;
        }
        int higherNum = Math.max(num1, num2);
        int smallerNum;
        //Convert higherNum to binary first.
        //Use padding to make both numbers equal in binary.
        if (higherNum == num1) {
            smallerNum = num2;
        } else {
            smallerNum = num1;
        }
        String binaryHigherNum = getBinaryStringRepresentation(higherNum);
        String binarySmallerNum = getBinaryStringRepresentation(smallerNum);
        StringBuilder smallerNumberBuilder = new StringBuilder();
        //No of zeroes to be padded
        int diffOfLength = Math.abs(binaryHigherNum.length() - binarySmallerNum.length());
        //Pad these zeroes to the smaller no
        for (int i = 0; i < diffOfLength; i++) {
            smallerNumberBuilder.append("0");
        }
        binarySmallerNum = smallerNumberBuilder.append(binarySmallerNum).toString();
        int difference = 0;
        for (int counter = 0; counter < binaryHigherNum.length(); counter++) {
            if (binaryHigherNum.charAt(counter) != binarySmallerNum.charAt(counter)) {
                difference++;
            }
        }
        return difference;
    }

    private static String getBinaryStringRepresentation(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        while (number != 0) {
            stringBuilder.append(number % 2);
            number = number / 2;
        }
        return stringBuilder.reverse().toString();
    }
}
