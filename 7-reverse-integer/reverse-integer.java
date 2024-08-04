class Solution {
    public int reverse(int x) {
       long sum=0;
       int rev=0;
       while(x!=0)
       {
         rev=x%10;
         sum=sum*10+rev;
        x=x/10;
       }
       return(sum<Integer.MIN_VALUE|| sum>Integer.MAX_VALUE)?0:(int)sum;
    }
}