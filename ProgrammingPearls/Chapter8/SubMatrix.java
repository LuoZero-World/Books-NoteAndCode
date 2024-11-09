package ProgrammingPearls.Chapter8;

/*
 * 求最大和子矩阵
 */
public class SubMatrix {
    
    public int maxSumRectangle(int[][] matrix) {
        int n = matrix.length;
        int maxSum = Integer.MIN_VALUE;

        // Iterate over all pairs of row boundaries
        for (int top = 0; top < n; top++) {
            int[] colSum = new int[n];
            for (int bottom = top; bottom < n; bottom++) {
                // Update column sums for the current row boundary
                for (int col = 0; col < n; col++) {
                    colSum[col] += matrix[bottom][col];
                }
                // Find the maximum sum of the subarray in this 1D array
                int currentMax = maxSubarraySum(colSum);
                maxSum = Math.max(maxSum, currentMax);
            }
        }
        return maxSum;
    }
    
    //Kadane's algorithm
    private int maxSubarraySum(int[] arr) {
        int maxEndingHere = 0, maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
