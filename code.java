class Solution {
    public static boolean b;
    public List<List<String>> solveNQueens(int n) {
        b=false;
       char [][] board=new char[n][n];
       for (char[] a : board) Arrays.fill(a, '.');
       List<List<String>> ans = new ArrayList<>();
       rec(board, 0, n,ans);
       return ans;
    }
    public static void rec(char[][] board, int row, int n,List<List<String>> ans) {
        if (row == n) {
            add(board,ans);
            return;
        }
        for (int column = 0; column < n; column++) if (isSafe(board, row, column, n)) {
            board[row][column] = 'Q';
            rec(board, row + 1, n,ans);
            if (!b)
                board[row][column] = '.';
            else 
                break ;
        }
    }
     public static boolean isSafe(char[][] board, int row, int column, int n) {
        int i = row, j = column;
        while (i >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
        }
        i = row;
        while (j >= 0 && i >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row;
        j = column;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
    public static void add(char[][] board,List<List<String>> ans){
        List<String> rowlist = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = "";
            for(int j=0;j<board[0].length;j++){
                row = row+ board[i][j];
            }
            rowlist.add(row);
            
        }
        ans.add(rowlist);
    }
}
