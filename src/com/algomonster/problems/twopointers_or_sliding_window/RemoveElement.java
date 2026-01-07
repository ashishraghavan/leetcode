package com.algomonster.problems.twopointers_or_sliding_window;

public class RemoveElement {
    public static void main(String[] args) {
        //[0,1,2,2,3,0,4,2],2
        //[2,2,2,2],2
        //[1,2,1,2,1,2],1
        //[4,5,6,4,5,6],5
        //[1,2,3,4,5],6
        //[-1,0,1],0
        //[1,2,1,2,1,2],2
        System.out.println(removeElement(new int[]{1},0));
    }

    //3,2,2,3   val=3
    //index i such that all elements before & including i != val
    //A[i]=val, A[j]!=val -> swap(A,i,j), i=j,j=i+1
    //2,3,2,3 i=1,j=2
    public static int removeElement(int[] A, int val) {
        if(A.length==0)return 0;
        int i,j;
        for(i=0,j=0;j<A.length;j++) {
            if(A[i]!=val) {
                i++;
            } else {
                if(A[j] != val) {
                    swap(A,i,j);
                    i++;
                }
            }
        }
        return i;
    }

    public static void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
