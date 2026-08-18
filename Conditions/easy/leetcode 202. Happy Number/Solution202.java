class Solution {
    public boolean isHappy(int n) {
        int len=(int)Math.log10(n)+1;
        int num=n;
        HashSet<Integer> hs=new HashSet<>();
        while(num!=1){
            if(hs.contains(num)) return false;
            hs.add(num);
          int total=0;
          while(num>0){
            int t=num%10;
            total+=t*t;
            num/=10;
          }
          num=total;
          len=(int)Math.log10(total)+1;
          //System.out.println(len);
        }
        //System.out.println(num);
        return true;
    }
}
