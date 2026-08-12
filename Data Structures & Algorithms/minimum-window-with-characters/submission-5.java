class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }

        int[] charFreq1 = new int[256];
        int[] charFreq2 = new int[256];

        for(char ch: t.toCharArray()) {
            charFreq1[ch]++;
        }       


        int windowStart = 0;
        String result = s;
        boolean stringMatchFinal = false;
        for(int i = 0; i < s.length(); i++) {

            charFreq2[s.charAt(i)]++;
            
            while(windowStart <= i && isStringMatching(charFreq1, charFreq2)) {
                stringMatchFinal = true;
                String substr = s.substring(windowStart, i+1);
                if(result.length() >= substr.length()) {
                    result = substr;
                }

                charFreq2[s.charAt(windowStart)]--;
                windowStart++;
            }
            
        }
        if(!stringMatchFinal) {
            return "";
        }
        return result;
    }

    public boolean isStringMatching(int[] charFreq1, int[] charFreq2) {
        for(int i = 0; i < 256; i++) {
            if(charFreq2[i] < charFreq1[i] && charFreq1[i] != 0){
                return false;
            }
        }

        return true;
    }
}
