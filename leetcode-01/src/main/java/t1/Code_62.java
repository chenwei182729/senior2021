package t1;

public class Code_62 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (obstacleGrid[j][i] == 1) {
                    f[i] = 0;
                    continue;
                }
                if (i - 1 >= 0 && obstacleGrid[j][i - 1] == 0) {
                    f[i] += f[i - 1];
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        Code_62 code_62 = new Code_62();
        System.out.println(code_62.uniquePathsWithObstacles(obstacleGrid));
    }
}
