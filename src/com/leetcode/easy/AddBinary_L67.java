package com.leetcode.easy;

//problem # 67 - add binary
//check https://github.com/doocs/leetcode/tree/main/solution/0000-0099/0067.Add%20Binary for github solution (not much different)
public class AddBinary_L67 {
    public static void main(String[] args) {
        //a = "11", b = "1"
        //a = "1010", b = "1011"
        //a = 1111, b = 111
        //a = 100001, b = 11111111111111
        //a=0,b=1
        System.out.println(addBinaryII("11","1"));
    }


    //INEFFICIENT SOLUTION
    //String.format is giving unexpected exception in leetcode judge
    public static String addBinaryII(String a, String b) {
        int maxLen = Math.max(a.length(),b.length());
        String addend1 = String.format("%0$"+maxLen+"s",a).replace(' ','0');
        String addend2 = String.format("%0$"+maxLen+"s",b).replace(' ','0');
        StringBuilder sb = new StringBuilder(Math.max(a.length(),b.length())+1);
        int carry = 0;
        int i;
        for(i=addend2.length()-1;i>=0;i--) {
            //total # of 1's
            int oneCt = Character.digit(addend1.charAt(i),10) + Character.digit(addend2.charAt(i),10) + carry;
            switch(oneCt) {
                case 0:
                    carry = 0;
                    sb.append('0');
                    break;
                case 1:
                    carry = 0;
                    sb.append('1');
                    break;
                case 2:
                    carry = 1;
                    sb.append('0');
                    break;
                case 3:
                    carry = 1;
                    sb.append('1');
                    break;
                default:break;
            }
        }
        if(carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static String padWithZeroes(int count,String s) {
        StringBuilder sb = new StringBuilder(count+s.length());
        for(int i=0;i<count;i++) {
            sb.append('0');
        }
        return sb.append(s).toString();
    }
}
