class Solution {
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int windowEnd = 1;
        int[] charFreq = new int[26];

        charFreq[s.charAt(0) - 'A']++;
        char highestFreqChar = s.charAt(0);
        int originalK = k;

        int maxLength = 0;
        while(windowEnd < s.length()) {
            if(highestFreqChar == s.charAt(windowEnd)) {
                charFreq[s.charAt(windowEnd) - 'A']++;
                windowEnd++;
            }
            else if(highestFreqChar != s.charAt(windowEnd) && k > 0) {
                k--;
                charFreq[highestFreqChar - 'A']++;
                windowEnd++;
            }
            else if(highestFreqChar != s.charAt(windowEnd) && k == 0) {
                char windowStartChar = charFreq[s.charAt(windowStart) - 'A'] == 0 ? highestFreqChar : s.charAt(windowStart);
                windowStart++;
                charFreq[windowStartChar - 'A']--;
                if(windowStartChar != highestFreqChar && originalK > k) {
                    k++;
                }
            }

            int maxFreq = 0;
            for(int i = 0; i < charFreq.length; i++) {
                if(charFreq[i] > maxFreq) {
                    maxFreq = charFreq[i];
                    highestFreqChar = (char)('A' + i);
                }
            }

            int currentLength = windowEnd - windowStart;
            maxLength = Math.max(currentLength, maxLength);
            if(windowStart == windowEnd) {
                windowEnd++;
                highestFreqChar = s.charAt(windowStart);
            }
        }

        return maxLength;
    }
}
