package com.sde.day_10_recursion_and_backtracking;

class Solution {

    public boolean check(char[][] board, int row, int col, char ch) {

        // row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch)
                return false;
        }
        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;
        }

        // 3x3 Matrix check
        int x = 3 * (row / 3);
        int y = 3 * (col / 3);

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }

    public boolean rec(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (check(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (rec(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        rec(board);
    }
}