class Solution {
public:
    int minAddToMakeValid(string s){
        stack<char> st;
        int unmatchedClose = 0;

        for (char c : s) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (!st.empty() && st.top() == '(') {
                    st.pop();
                } else {
                    unmatchedClose++;
                }
            }
        }
        return st.size() + unmatchedClose;
    }
};




