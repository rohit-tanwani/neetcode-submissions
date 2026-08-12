class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int[] charFreq = new int[26];
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            charFreq[s.charAt(right) - 'A']++;

            maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                maxFreq = Math.max(maxFreq, charFreq[i]);
            }

            while (right - left + 1 - maxFreq > k) {
                charFreq[s.charAt(left) - 'A']--;
                left++;

                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, charFreq[i]);
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}   
