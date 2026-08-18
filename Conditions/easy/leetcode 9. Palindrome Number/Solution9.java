class Solution {
    public boolean isPalindrome(int x) {
        int count=0;
        String s=Integer.toString(x);
        int start=0,end=s.length()-1;

        while(start<end){
            if(s.charAt(start)==s.charAt(end)) count++;
            start++;
            end--;
        }
        return count==(s.length()/2);
    }
}
