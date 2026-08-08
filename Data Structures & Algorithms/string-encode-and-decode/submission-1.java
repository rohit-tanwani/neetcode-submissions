class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length() + "_" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        
        List<String> result = new ArrayList<String>();
        int i = 0;
        while(i < str.length()) {
            StringBuilder lengthString = new StringBuilder();
            while(str.length() > i && str.charAt(i) != '_' ){
                lengthString.append(str.charAt(i));
                i++;
            }
            i++;
            int length = Integer.valueOf(lengthString.toString());
            int lastIndex = i+length < str.length() ? i+length : str.length();
            String substr = str.substring(i, lastIndex);
            i = i+length;
            result.add(substr);
        }
        return result;
    }
}
