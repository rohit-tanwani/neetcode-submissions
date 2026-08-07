class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> mapOfSortedStringVsStrings = new HashMap<String, ArrayList<String>>();
        for(String str: strs) {
            String sortedCharacterString = getSortedString(str);
            if(!mapOfSortedStringVsStrings.containsKey(sortedCharacterString)) {
                mapOfSortedStringVsStrings.put(sortedCharacterString, new ArrayList<String>());
            }
            mapOfSortedStringVsStrings.get(sortedCharacterString).add(str);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(String str: mapOfSortedStringVsStrings.keySet()) {
            result.add(mapOfSortedStringVsStrings.get(str));
        }

        return result;
    }

    public String getSortedString(String str) {
        int[] characterArray = new int[26];
        for(char ch: str.toCharArray()) {
            int index = ch - 'a';
            characterArray[index]++;
        }
        String s = "";
        for(int i = 0; i < characterArray.length; i++) {
            int characterCount = characterArray[i];
            while(characterCount-- > 0) {
                s += (char)('a' + i);
            }
        }
        return s;        
    }
}
