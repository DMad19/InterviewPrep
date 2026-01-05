## 1D DP (Linear progression)

Problems: Fibonacci, climbing stairs, house robber.

Idea: Answer for n depends on smaller indices (n-1, n-2).

Black box: “Build from base cases forward.”

## 2D DP (Grid / Matrix)

Problems: Unique paths, minimum path sum, edit distance.

Idea: State depends on neighbors (top, left, diagonal).

Black box: “Move through a grid, store best way at each cell.”

## Knapsack Pattern

Problems: Subset sum, partition equal subset, coin change.

Idea: Choice at each step: take or skip an item.

Black box: “At each item, branch into include/exclude.”

## Interval DP

Problems: Matrix chain multiplication, burst balloons.

Idea: Solve for ranges [i..j] by splitting at k.

Black box: “Divide interval into two smaller intervals.”

## String DP

Problems: Longest common subsequence, palindrome partitioning.

Idea: Compare characters, shrink string from ends.

Black box: “Match/mismatch characters, recurse on substrings.”

## Digit / Bitmask DP

Problems: Traveling salesman, counting numbers with constraints.

Idea: State defined by subset of choices or digits.

Black box: “Use bitmask to represent visited set.”