class Solution {
    public String reverseWords(String s) {
      
        String a[]=s.split(" ");
        String result="";
        for(int i=0;i<a.length;i++){
            char arr[]=a[i].toCharArray();
            int left=0,right=arr.length-1;
            while(left<right){
                char c=arr[left];
                arr[left]=arr[right];
                arr[right]=c;
                left++;
                right--;
            }
            
            String res="";
            for(int j=0;j<arr.length;j++) res+=arr[j];
            result+=res+" ";
        }
        return result.substring(0,result.length()-1);
    }
}
