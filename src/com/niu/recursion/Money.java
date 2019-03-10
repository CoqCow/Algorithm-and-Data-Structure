package com.niu.recursion;

public class Money {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4};
        System.out.println(getKinds(coins, 1000));
        System.out.println(process(coins, 3, 1000));
    }

    //动态规划
    public static int getKinds(int[] coins, int target) {
        int coinKinds = coins.length - 1;
        int[][] dp = new int[coinKinds + 1][target + 1];
        //初始第一列
        for (int i = 0; i < dp[0].length; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i <= coinKinds; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= j / coins[i]; k++) {
                    dp[i][j] += dp[i - 1][j - coins[i] * k];
                }
            }
        }
        return dp[coinKinds][target];
    }

    //递归
    public static int process(int[] coins, int index, int target) {
        if (index < 0 || target < 0) {
            return 0;
        }
        if (index == 0) {
            return target % coins[index] == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i <= target / coins[index]; i++) {
            res += process(coins, index - 1, target - i * coins[index]);
        }
        return res;
    }
}
