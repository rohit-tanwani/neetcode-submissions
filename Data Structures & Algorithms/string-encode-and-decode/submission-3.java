class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length());
            sb.append("_");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        
        List<String> result = new ArrayList<String>();
        int i = 0;
        
        while(i < str.length()) {
            int length = 0;
            while(str.charAt(i) != '_'){
                length++;
                i++;
            }
            
            int strLength = Integer.valueOf(str.substring(i-length, i));
            String substr = str.substring(i+1, i + strLength+1);
            i += strLength + 1;
            result.add(substr);
        }
        return result;
    }
}
