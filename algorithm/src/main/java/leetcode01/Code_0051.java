package leetcode01;

import java.util.*;

public class Code_0051 {
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        _backtrack(queens, n, 0, cols, pies, nas);
        return result;
    }

    private void _backtrack(int[] queens, int n, int row, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            result.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i)) {
                continue;
            }
            int na = row - i;
            if (nas.contains(na)) {
                continue;
            }
            int pie = row + i;
            if (pies.contains(pie)) {
                continue;
            }

            queens[row] = i;
            cols.add(i);
            pies.add(pie);
            nas.add(na);
            _backtrack(queens, n, row + 1, cols, pies, nas);
            queens[row] = -1;
            cols.remove(i);
            pies.remove(pie);
            nas.remove(na);
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>(n * 2);
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        Code_0051 code_0051 = new Code_0051();
        System.out.println(code_0051.solveNQueens(8));
    }
}
