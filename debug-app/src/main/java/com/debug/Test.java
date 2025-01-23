package com.debug;

//Bug - A software bug is an error, flaw or fault in a computer program or system that causes it to produce an incorrect or unexpected result.
//Debugging - Debugging is the process of detecting and removing of existing and potential errors (also called as bugs) in a software code that can cause it to behave unexpectedly or crash.
public class Test {
    public static void main(String[] args) {
        System.out.println("Going to debug our simple java application");
        int[] arr = {1, 2, 3, 4, 5};
        int sum = getSum(arr);
        System.out.println(sum);
    }

    public static int getSum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sum += 3;
        return sum;
    }

}
