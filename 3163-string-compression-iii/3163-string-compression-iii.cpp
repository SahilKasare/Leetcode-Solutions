class Solution {
public:
    string compressedString(string word) {
        std::string answer;
        int i = 0;
        while (i < word.size()) {
            char c = word[i];
            int count = 0;
            while (i < word.size() && word[i] == c && count < 9) {
                count++;
                i++;
            }
            answer += std::to_string(count);
            answer.push_back(c);
        }
        return answer;
    }
};

