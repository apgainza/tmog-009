# The Mirror of Galadriel!
## Episode #009 - Rotting Oranges

Welcome to ***The Mirror of Galadriel***, one of the activities that will follow in the *The Fellowship of Code*. If you haven't been here before, this is a place where programming problems of different types will be proposed to be solved as fast as possible.

Without further ado, we leave you with the next problem. 

Good luck adventurers!

## Statement

You are given an ``m x n`` ``grid`` where each cell can have one of three values:

> ``0`` representing an empty cell
> </br> ``1`` representing a fresh orange
> </br> ``2`` representing a rotten orange

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return ``-1``.

***Constraints***
> ``m`` == ``grid.length``
> </br> ``n`` == ``grid[i].length``
> </br> 1 <= ``m``, ``n`` <= 10
> </br> ``grid[i][j]`` is 0, 1, or 2.

## Examples

*Example 1*
> ![Screenshot](https://assets.leetcode.com/uploads/2019/02/16/oranges.png)
> </br> **Input**: grid = [[2,1,1],[1,1,0],[0,1,1]]
> </br> **Output**: 4

*Example 2*
> **Input**: grid = [[2,1,1],[0,1,1],[1,0,1]]
> </br> **Output**: -1
> </br> **Explanation**: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

*Example 2*
> **Input**: grid = [[0,2]]
> </br> **Output**: 0
> </br> **Explanation**: Since there are already no fresh oranges at minute 0, the answer is just 0.

## Extra

Run, you fools! No extra spicy stuff this time.

## Credits

This exercise has been extracted from the [LeetCode](https://leetcode.com/problems/rotting-oranges) website. Don't hesitate, join and practice in this great community.
