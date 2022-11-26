import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to
 * endTime[i], obtaining a profit of profit[i].
 * 
 * You're given the startTime, endTime and profit arrays, return the maximum
 * profit you can take such that there are no two jobs in the subset with
 * overlapping time range.
 * 
 * If you choose a job that ends at time X you will be able to start another job
 * that starts at time X.
 * 
 * Example 1:
 * 
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * 
 * Example 2:
 * 
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * 
 * Example 3:
 *
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 */

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] s, int[] e, int[] p) {
        int n = s.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; ++i)
            jobs[i] = new int[] { s[i], e[i], p[i] };

        Arrays.sort(jobs, (x, y) -> x[0] - y[0] != 0 ? x[0] - y[0] : x[1] - y[1]);

        int[] dp = IntStream.range(0, n + 1).map(j -> 0).toArray();
        for (int i = n - 1; i >= 0; --i) {
            int k = Arrays.binarySearch(jobs, new int[] { jobs[i][1], 0, 0 },
                    Comparator.comparingInt(j -> j[0]));
            k = (k >= 0) ? k : -k - 1;
            dp[i] = Math.max(dp[i + 1], dp[k] + jobs[i][2]);
        }

        return dp[0];
    }
}