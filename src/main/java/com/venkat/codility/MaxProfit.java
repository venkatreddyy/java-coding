package com.venkat.codility;

public class MaxProfit {
    public int solution(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit obj = new MaxProfit();
        int[] prices = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(obj.solution(prices));  // Output: 356
    }
}

