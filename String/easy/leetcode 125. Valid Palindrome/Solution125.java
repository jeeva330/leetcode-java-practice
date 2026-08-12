class Solution {
    public boolean isPalindrome(String s) {
        String a="";
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')) a+=s.charAt(i);

        }
       
        int left=0,right=a.length()-1;
        while(left<right){
            if(a.charAt(left)!=a.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
