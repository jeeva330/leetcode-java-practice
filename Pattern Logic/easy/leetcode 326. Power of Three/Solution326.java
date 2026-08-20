class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<0) return false;
        int count=0;
        int num=n;
        while(n>1){
            n/=3;
            count++;
        }
        return num==((int)Math.pow(3,count));
    }
}
