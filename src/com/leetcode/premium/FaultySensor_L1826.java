package com.leetcode.premium;

//check https://github.com/doocs/leetcode/blob/main/solution/1800-1899/1826.Faulty%20Sensor/README_EN.md for more details
//problem # 1826
//is comparable to github solution
//TODO: review
public class FaultySensor_L1826 {
    public static void main(String[] args) {
        //new int[]{2,3,4,5},new int[]{2,1,3,4}
        //sensor1 = [2,2,2,2,2], sensor2 = [2,2,2,2,5]
        //sensor1 = [2,3,2,2,3,2], sensor2 = [2,3,2,3,2,7]
        System.out.println(isFaulty(new int[]{2,3,2,2,3,2},new int[]{2,3,2,3,2,7}));
    }

    //pseudocode
    //result = -1;
    //if all values match except sensor1[sensor1.length-1] != sensor2[sensor2.length-1] return -1
    //for idx[0:sensor1.length-1] if sensor1[idx] == sensor2[idx] continue
    //TODO: might be incorrect for some test cases
    //else if sensor1[idx] == sensor2[idx+1]  return 1
    //else if sensor2[idx] == sensor1[idx+1] return 2
    //else return -1
    public static int isFaulty(int[] sensor1,int[] sensor2) {
        return -1;
    }
}
