package com.leetcode.easy;

//problem # 278 - first bad version
//TODO: revise, pending checking github solution
public class FirstBadVersion_L278 {
    public static void main(String[] args) {
        //1,2,3,4,5 | bad = 4
        //1,2,3,4,5,6,7,8 | bad = 7
        //1....289786902
        System.out.println(firstBadVersion(289786902));
    }

    //1,2,3,4,5 | bad = 4
    //assuming product versions are successive i.e. 1->2->3->4->5
    //use binary search
    public static int firstBadVersion(int n) {
        //mid = (end - start + 1)/2
        //if(isBadVersion(mid)) = true, check isBadVersion(mid-1) -> true? search in range (0,mid-1) -> start = 0, end = mid-1
        // else
        // ans is in range (mid+1,n) -> start = mid+1, end = n
        // mid = (end - start+1)/2
//        int[] A = new int[n];
//        for(int i=0;i<n;i++) {
//            A[i] = i;
//        }
        int start = 1, end = n, mid;
        while(start <= end) {
            if(start == end) {
                if(isBadVersion(start)) {
                    return start;
                }
                return -1;
            }
            mid = start + (end - start)/2;
            if(isBadVersion(mid)) {
                if(!isBadVersion(mid-1))return mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static boolean isBadVersion(int idx) {
        //return idx >= 144993451;
        //return idx >= 289786901;
        return idx >= 289786900;
    }
}
