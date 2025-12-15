package org.example.task_86;

class Solution {
    public static long getDescentPeriods(int[] prices) {
        int left=0,right=1,n=prices.length;
        long ans=n;

        while(right<n){
            if(prices[right-1]-prices[right]==1){
                ans+=(right-left);
            }
            else{
                left=right;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {3,2,1,4};
        System.out.println(getDescentPeriods(prices));
    }
}