class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,(a,b)->b.length()-a.length());
        for(int i=0;i<strs.length;i++){
            if(isLUS(strs,i))return strs[i].length();
        }
        return -1;
    }
    public static boolean isLUS(String[] strs,int i){
        for(int j=0;j<strs.length;j++){
            if(strs[i].length()>strs[j].length())break;
            if(i!=j && isSub(strs[j],strs[i]))return false;
            
        }
        return true;
    }
    public static boolean isSub(String s1,String s2){
        int count=0;
        int j=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
                count++;
            }
            if(count==s2.length())return true;
        }
        return false;
    }
}