class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) return s;

        StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
