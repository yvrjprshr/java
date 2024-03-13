package com.sde.day_10_recursion_and_backtracking;
import java.util.*;
class Solution {
    public boolean isWrongPosition(List<StringBuilder> sb, int row, int col, int n){
        // row check
        for(int i=0;i<n;i++){
            if(sb.get(row).charAt(i)=='Q') return true;
        }
        
        // col check
        for(int i=0; i<n; i++){
            if(sb.get(i).charAt(col)=='Q') return true;
        } 
        
        // diagonally check
        int i,j;
        
        // upper left
        i=row;j=col;
        while(i>=0&&j>=0){
            if(sb.get(i).charAt(j)=='Q') return true;
            i--;j--;
        }

        // upper right
        i=row; j=col;
        while(i>=0&&j<n){
            if(sb.get(i).charAt(j)=='Q') return true;
            i--;j++;
        }

        // lower left
        i=row; j=col;
        while(i<n&&j>=0){
            if(sb.get(i).charAt(j)=='Q') return true;
            i++;j--;
        }

        // lower right
        i=row; j=col;
        while(i<n&&j<n){
            if(sb.get(i).charAt(j)=='Q') return true;
            i++;j++;
        }
        
        return false;
    }
    
    public void rec(List<List<StringBuilder>> ans, List<StringBuilder> ls, int row, int n){
        if(row==n){                           
            List<StringBuilder> temp = new ArrayList<>();
            for(int i = 0; i < ls.size(); i++){
                StringBuilder x = new StringBuilder(ls.get(i));
                temp.add(x);
            }
            ans.add(temp);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isWrongPosition(ls, row, i, n)==false){
                ls.get(row).setCharAt(i, 'Q');
                rec(ans, ls, row+1, n);
                ls.get(row).setCharAt(i, '.');
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        List<List<StringBuilder>> ans = new ArrayList<>();
        List<StringBuilder> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            sb.append('.');
        }
        for(int i=0; i<n; i++){
            StringBuilder temp = new StringBuilder(sb);
            ls.add(temp);
        }
        rec(ans, ls, 0, n);
        List<List<String>> final_ans = new ArrayList<>();
        for(int i = 0; i < ans.size(); i++){
            List<String> str_temp = new ArrayList<>();
            for(int j = 0; j < ans.get(i).size(); j++){
                str_temp.add(ans.get(i).get(j).toString());
            }
            final_ans.add(str_temp);
        }
        return final_ans;
    }
}