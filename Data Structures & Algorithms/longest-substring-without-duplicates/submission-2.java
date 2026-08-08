class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int pointer = 0;
        String currentMaxString = "";
        while(pointer < s.length()) {
            if(!currentMaxString.contains(String.valueOf(s.charAt(pointer)))) {
                currentMaxString = currentMaxString.concat(String.valueOf(s.charAt(pointer)));
                pointer++;
            } else {
                res = Math.max(res, currentMaxString.length());
                int duplicateIndex = currentMaxString.indexOf(s.charAt(pointer));
                currentMaxString = currentMaxString.substring(duplicateIndex + 1);
            }
        }

        return Math.max(res, currentMaxString.length());
    }
}
