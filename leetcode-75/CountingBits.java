class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = count1sInBinary(i);
        }
        return ans;
    }

    // TODO: improve

    public int count1sInBinary(int x) {
        int count1s = 0;
        while (x > 0) {
            count1s += x % 2;
            x = x / 2;
        }
        return count1s;
    }
}
