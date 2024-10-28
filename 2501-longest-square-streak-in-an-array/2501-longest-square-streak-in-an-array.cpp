using namespace std;

class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        unordered_set<int> numSet(nums.begin(), nums.end());
        
        int max_count = 0;
        
        for (int num : nums) {
            int count = 0;
            long long current = num;
            
            while (numSet.count(current)) {
                count++;
                current = current * current;
                
                // Break if the square is too large to avoid unnecessary iterations
                if (current > INT_MAX) break;
            }
            
            max_count = max(max_count, count);
        }
        
        return (max_count <= 1) ? -1 : max_count;
    }
};

// class Solution {
// public:
//     int longestSquareStreak(vector<int>& nums) {
//         sort(nums.begin(), nums.end());
        
//         int max_count = 0;
//         int k = 0;
//         while(nums.size() != 0){
//             int i = 0;
//             int j = 1;
//             int count = 0;
//             while(j<nums.size()){
//                 long long square = static_cast<long long>(nums[i]) * nums[i];
//                 if(square == nums[j]){
//                     count++;
//                     i = j;
//                     j = i+1;
//                 }
//                 else j++;
//             }
//             if (count > 0) count++; // to count the first member of the sequence
//             max_count = max(max_count, count); 
//             nums.erase(nums.begin());
//         }
//         return (max_count == 0) ? -1 : max_count ;
//     }
// };