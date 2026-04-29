class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }

        String output = "";
        String delimiter = ":";
        for (String s : strs) {
            output += s.length() + delimiter + s;
        }

        return output;
    }

    public List<String> decode(String str) {
        List result = new ArrayList();
        String delimiter = ":";
        // 5:apple6:orange5:hello5:world
        for (int i = 0; i < str.length();) {
            int delimiterIndex = Integer.valueOf(str.indexOf(delimiter, i));
            int beginIndex = delimiterIndex + 1;
            int endIndex = beginIndex + Integer.valueOf(str.substring(i, delimiterIndex)); // 7

            result.add(str.substring(beginIndex, endIndex));

            i = endIndex;
        }

        return result;
    }
}
