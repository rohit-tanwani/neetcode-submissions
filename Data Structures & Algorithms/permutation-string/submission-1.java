class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1charFreq = new int[26];

        for(char ch: s1.toCharArray()) {
            s1charFreq[ch-'a']++;
        }

        
        int windowStart = 0;
        int windowEnd = s1.length();

        while(windowEnd <= s2.length()) {
            int[] s2charFreq = new int[26];
            for(int i = windowStart; i < windowEnd; i++) {
                s2charFreq[s2.charAt(i) - 'a']++;
            }

            boolean match = true;
            for(int i = 0; i < 26; i++) {
                if(s1charFreq[i] != s2charFreq[i]) {
                    match = false;
                    break;
                }
            }

            if(match) {
                return true;
            } else{
                windowStart++;
                windowEnd++;
            }
        }
        return false;
    }
}
