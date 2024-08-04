class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int rev=0;
        if(x<0)
        {
            return false;
        }
        while(temp!=0)
        {
            int dig=temp%10;
            rev=rev*10+dig;
            temp=temp/10;
        }
        if(rev==x)
        {
            return true;
        }
        return(rev==x);
        
    }
}