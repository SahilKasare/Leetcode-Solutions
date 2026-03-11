class Solution {
    public int bitwiseComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                newStr.append('0');
            } else {
                newStr.append('1');
            }
        }
        return Integer.parseInt(newStr.toString(), 2);
    }
}