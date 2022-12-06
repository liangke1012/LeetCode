package leetcode.backtract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class Nhuanghou {
    private static int count = 0;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] array = new int[n];
        check(0,array,n,solutions);
        return solutions;
    }

    /**
     * 判断第n个皇后，是否和前面的冲突
     * @param n
     * @return
     */
    private boolean judge(int n,int[] array){
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]判断是否在同一列
            //Math.abs(n-i) == Math.abs(array[n]-array[i])判断是否在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void check(int n,int[] array,int max,List<List<String>> solutions ){
        if(n == max){
            //print(array);
            List<String> borad = borad(array, max);
            solutions.add(borad);
            //System.out.println(borad.toString());
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if(judge(n,array)){
                check(n+1,array,max,solutions);
            }

        }
    }

    private void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    private List<String> borad(int[] array,int max){
        count++;
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < max; i++) {
            char[] row = new char[max];
            Arrays.fill(row, '.');
            row[array[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        Nhuanghou hh = new Nhuanghou();
        int max = 4;

        List<List<String>> lists = hh.solveNQueens(max);
        System.out.println(lists.toString());
        System.out.println(count);
    }
}
