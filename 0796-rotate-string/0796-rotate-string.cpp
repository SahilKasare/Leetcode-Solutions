// class Solution {
// public:
//     bool rotateString(string s, string goal) {
//         int first = goal.find(s[0]);
//         std::string new_str = goal.substr(first) + goal.substr(0, first);
//         std::cout << new_str << std::endl;
//         if(new_str == s) return true;
//         return false;
//     }
// };


#include <string>

class Solution {
public:
    bool rotateString(std::string s, std::string goal) {
        if (s.length() != goal.length()) return false;

        std::string doubled = s + s;
        return doubled.find(goal) != -1;
    }
};
