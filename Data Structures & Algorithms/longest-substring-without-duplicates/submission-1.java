class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charVsIndex = new HashMap<Character, Integer>();

        int currentLength = 0;
        int maxLength = 0;
        int index = 0;
        int lastRemovedIndex = 0;

        for(char ch: s.toCharArray()) {
            currentLength++;
            if(charVsIndex.containsKey(ch)) {
                int endIndex = charVsIndex.get(ch);
                while(lastRemovedIndex <= endIndex) {
                    char removedChar = s.charAt(lastRemovedIndex++);
                    if(charVsIndex.containsKey(removedChar)) {
                        charVsIndex.remove(removedChar);
                        currentLength--;
                    }
                }
            }
            charVsIndex.put(ch, index++);
            if(currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
