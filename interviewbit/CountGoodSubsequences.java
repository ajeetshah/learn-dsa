/*
An array is good if all the elements present in it have the same frequency. 

For example:
[2, 3, 3, 2] is good because both 2 and 3 have frequency 2. 
[2, 3, 2] is not good because the frequencies of 2 and 3 are 2 and 1 respectively. 

You are given an array A. 
You need to count the number of non-empty good subsequences of A. 
Since the answer can be large, return it modulo 109+7.

Input 1: A = [1, 2, 1]
Output 1: 6
subs:
1
2
1
1,2
1,1
2,1
1,2,1: not good
ans: 6

Input 2: A = [5, 10, 2]
Output 2: 7
subs:
5
10
2
5,10
5,2
10,2
5,10,2
ans: 7
*/

class CountGoodSubsequences {
    public static void main(String[] args) {
        // int[] A = {1,2,1};
        int[] A = {5,10,2};
        generateSubs(A);
    }
    public static void generateSubs(int[] A) {
        int[][] subs = new int[50][A.length];
        int lastFilled = -1;
        int toPick = 0;
        helper(A, subs, lastFilled, toPick);
        for(int i=0; i<50; i++) {
            for(int j=0; j<A.length; j++) {
                p(subs[i][j]);
            }
        }
    }
    public static void helper(int[] A, int[][] subs, int lastFilled, int toPick) {
        p(toPick);
        if(toPick == 0) {
            subs[++lastFilled][0] = A[toPick];
            helper(A, subs, lastFilled, toPick+1);
            return;
        }
        if(toPick >= A.length) return;
        int lastFilledCopy = lastFilled;

        for(int i=0; i<=lastFilledCopy; i++) {
            p(i);
            int[] ithRow = subs[i];
            subs[++lastFilled][ithRow.length] = A[toPick];
        }

        subs[++lastFilled] = new int[] {A[toPick]};
        helper(A, subs, lastFilled, toPick+1);
    }
    public static int solve(int[] A) {
        return 0;
    }
    public static void p(int x) {
        System.out.println(x);
    }
}
