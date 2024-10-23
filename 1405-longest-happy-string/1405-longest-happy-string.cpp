class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        std::priority_queue<std::pair<int, char>> pq;

        if (a > 0) pq.push(std::make_pair(a, 'a'));
        if (b > 0) pq.push(std::make_pair(b, 'b'));
        if (c > 0) pq.push(std::make_pair(c, 'c'));

        std::string result = ""; 

        while (!pq.empty()) {
            auto topElement = pq.top();
            pq.pop();

            if (result.size() >= 2 && result[result.size() - 1] == topElement.second && result[result.size() - 2] == topElement.second) {
                if (pq.empty()) break; 

                auto secondElement = pq.top();
                pq.pop();

                result += secondElement.second;
                secondElement.first--;

                if (secondElement.first > 0) {
                    pq.push(secondElement);
                }

                pq.push(topElement);
            } else {
                int countToAppend = std::min(2, topElement.first);
                result.append(countToAppend, topElement.second);

                topElement.first -= countToAppend;
                if (topElement.first > 0) {
                    pq.push(topElement);
                }
            }
        }

        return result;
    }
};


// class Solution {
// public:
//     string longestDiverseString(int a, int b, int c) {
//         priority_queue<pair<char, int>> pq;
//         pq.push(std::make_pair('a', a));
//         pq.push(std::make_pair('b', b));
//         pq.push(std::make_pair('c', c));
//         std::string s = "";
//         while(){
//             std::pair<char, int> topElement = pq.top();// topElement.first , .second
//             if(topElement.second == 0)break;
//             else if(topElement.secons == 1) str.append(1, topElement.first); 
//             else str.append(2, topElement.first);
//         }
//     }
// };