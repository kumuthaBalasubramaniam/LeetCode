class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int a = 0, b = 0;
        for (int i = 0; i < n - 1; i += 2) {
            a ^= encoded[i];
        }
        for (int i = 1; i <= n; ++i) {
            b ^= i;
        }
        int[] per = new int[n];
        per[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            per[i] = encoded[i] ^ per[i + 1];
        }
        return per;
        
    }
}