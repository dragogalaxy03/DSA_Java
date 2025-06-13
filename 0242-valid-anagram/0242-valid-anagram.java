class Solution {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int s2 = t.length();

        if(s1!=s2){
            return false;
        }
        int arr[] = new int[26];
        for(int i=0; i<s1; i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s2;i++){
            arr[t.charAt(i)-'a']--;
            if(arr[t.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
        
    }
}