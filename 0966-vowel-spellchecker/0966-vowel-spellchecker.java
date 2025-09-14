class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelErrorMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);
            
            String lowerWord = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lowerWord, word);

            String devoweled = devowel(lowerWord);
            vowelErrorMap.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lowerQuery = query.toLowerCase();
                String devoweledQuery = devowel(lowerQuery);

                if (caseInsensitiveMap.containsKey(lowerQuery)) {
                    result[i] = caseInsensitiveMap.get(lowerQuery);
                } else if (vowelErrorMap.containsKey(devoweledQuery)) {
                    result[i] = vowelErrorMap.get(devoweledQuery);
                } else {
                    result[i] = "";
                }
            }
        }

        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
