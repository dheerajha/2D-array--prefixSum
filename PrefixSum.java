public class PrefixSum {
    // Build the prefix sum matrix
    public static int[][] buildPrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i][j] = matrix[i][j];

                if (i > 0)
                    prefix[i][j] += prefix[i - 1][j];
                if (j > 0)
                    prefix[i][j] += prefix[i][j - 1];
                if (i > 0 && j > 0)
                    prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        return prefix;
    }

    // Query sum of a submatrix (r1, c1) to (r2, c2)
    public static int submatrixSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        int total = prefix[r2][c2];
        if (r1 > 0)
            total -= prefix[r1 - 1][c2];
        if (c1 > 0)
            total -= prefix[r2][c1 - 1];
        if (r1 > 0 && c1 > 0)
            total += prefix[r1 - 1][c1 - 1];

        return total;
    }

    // Test the solution
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] prefix = buildPrefixSum(matrix);

        // Query sum from (1,1) to (2,2) -> Sum of [5,6,8,9] = 28
        System.out.println(submatrixSum(prefix, 1, 1, 2, 2));

        // Query sum from (0,0) to (1,1) -> Sum of [1,2,4,5] = 12
        System.out.println(submatrixSum(prefix, 0, 0, 1, 1));
    }
}