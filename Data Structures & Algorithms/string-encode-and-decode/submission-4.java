class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }

        StringBuilder output = new StringBuilder("");
        char delimiter = ':';
        for (String s : strs) {
            output.append(s.length()).append(delimiter).append(s);
        }

        return output.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        char delimiter = ':';
        // 5:apple6:orange5:hello5:world
        for (int i = 0; i < str.length();) {
            int delimiterIndex = str.indexOf(delimiter, i);
            int beginIndex = delimiterIndex + 1;
            int endIndex = beginIndex + Integer.parseInt(str.substring(i, delimiterIndex));

            result.add(str.substring(beginIndex, endIndex));

            i = endIndex;
        }

        return result;
    }
}
