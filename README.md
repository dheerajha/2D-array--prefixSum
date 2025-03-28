# 2D Array Prefix Sum - Mastering 2D Range Queries

## 🔥 Introduction
2D prefix sum is a powerful technique to efficiently solve problems involving **sum queries on a submatrix**. By preprocessing the array, we can answer sum queries in **O(1) time** instead of **O(N × M)**.

## 📌 Formula for 2D Prefix Sum
Given a 2D array **arr[i][j]**, its **prefix sum matrix** `prefix[i][j]` is computed as:

\[
prefix[i][j] = arr[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]
\]

### Querying a Submatrix Sum (Top-Left: (r1, c1), Bottom-Right: (r2, c2))
\[
sum = prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1]
\]
Handling **boundary cases**:
- If `r1 == 0`, remove `prefix[r1-1][c2]`
- If `c1 == 0`, remove `prefix[r2][c1-1]`
- If both `r1 == 0` and `c1 == 0`, then sum = `prefix[r2][c2]`

## 🚀 Implementation
```cpp
#include <iostream>
using namespace std;

const int N = 1005;
int arr[N][N], prefix[N][N];

void computePrefixSum(int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            prefix[i][j] = arr[i][j];
            if (i > 0) prefix[i][j] += prefix[i-1][j];
            if (j > 0) prefix[i][j] += prefix[i][j-1];
            if (i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];
        }
    }
}

int getSum(int r1, int c1, int r2, int c2) {
    int sum = prefix[r2][c2];
    if (r1 > 0) sum -= prefix[r1-1][c2];
    if (c1 > 0) sum -= prefix[r2][c1-1];
    if (r1 > 0 && c1 > 0) sum += prefix[r1-1][c1-1];
    return sum;
}
```

## 📚 Important Questions
1. **Range Sum Query 2D - Immutable** (LeetCode 304)
2. **Largest Submatrix with Rearrangements** (LeetCode 1727)
3. **Maximum Sum Rectangle in a 2D Matrix** (Kadane's 2D Algorithm)
4. **Submatrix Sum Queries** (GFG, LeetCode Variants)
5. **Counting Submatrices with Target Sum** (LeetCode 1074)

## 🎯 Tips & Tricks
✅ **Precompute Prefix Sum Matrix** – Avoid recomputation in queries.
✅ **Handle Edge Cases** – Ensure correct boundary conditions.
✅ **Use Kadane’s Algorithm for Maximum Sum Submatrix**
✅ **Binary Search on Prefix Sum for Optimization**
✅ **Use Hash Maps for Faster Lookup in Some Variants**

## 🔥 Become a Pro!
- Practice problems on LeetCode, Codeforces, and Atcoder.
- Understand edge cases like negative numbers, large matrices, etc.
- Optimize space by modifying the input matrix instead of using extra space.

## 🌟 Conclusion
2D Prefix Sum is a must-know technique for handling matrix problems efficiently. Mastering it will help in solving **dynamic programming, range queries, and optimization problems faster!** 🚀

