class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }

        StringBuilder output = new StringBuilder("");
        String delimiter = ":";
        for (String s : strs) {
            output.append(s.length()).append(delimiter).append(s);
        }

        return output.toString();
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
