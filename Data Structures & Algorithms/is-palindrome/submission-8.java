class Solution {
    public boolean isPalindrome(String s) {
        abc: for(int i = 0, j = s.length() - 1; i < s.length() && j >= 0 && i <= j; i++, j--) {
            char firstChar = s.charAt(i);
            char lastChar = s.charAt(j);

            while(!checkForCharacter(firstChar)) {
                i++;
                if(i >= s.length()) {
                    break abc;
                }
                firstChar = s.charAt(i);
            }

            while(!checkForCharacter(lastChar)) {
                j--;
                if(j < 0) {
                    break abc;
                }
                lastChar = s.charAt(j);
            }

            if(Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkForCharacter(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch >='0' && ch<='9') || (ch >= 'A' && ch <= 'Z'));
    }
    
}
