package algoritm.math;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class GridUniquePaths {
    public int uniquePaths(int A, int B) {
        int[][] temp = new int[A][B];

        for (int j = 0; j < B; j++) {
            for (int i = 0; i < A; i++) {
                if (i == 0 || j == 0) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = temp[i][j-1] + temp[i-1][j];
                }
            }
        }

        return temp[A-1][B-1];
    }
}
