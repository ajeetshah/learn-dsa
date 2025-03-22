/*

1 2
3 4

1 2 3
4 5 6
7 8 9

d1: 15
d2: 15

d1 + d2 - arr[]


*/


class SumDiagonal {
    public static void  main(String[] args) {
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{1,2}, {3,4}};
        sumDiagonal(mat);       
    }
    public static void sumDiagonal(int[][] mat) {
        int n = mat.length;
        int ans = 0;

        for(int i=0; i<n; i++) {
            ans += mat[i][i];
        }
    
        for(int i=0; i<n; i++) {
            ans += mat[i][n-i-1];        
        }

        if (n % 2 == 1) ans -= mat[n/2][n/2];
        System.out.println(ans);
    }
}
