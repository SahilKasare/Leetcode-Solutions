class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size(); 
        vector<vector<int>> new_matrix(m, vector<int>(n, 0));
        int sum = 0;
        
        //for 1st row and 1st column we cant have any square
        for(int i=0; i<n; i++){
            new_matrix[0][i] = matrix[0][i];
            sum += new_matrix[0][i];
        }

        for(int i=1; i<m; i++){
            new_matrix[i][0] = matrix[i][0];
            sum += new_matrix[i][0];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 1){
                    new_matrix[i][j] = std::min({new_matrix[i-1][j-1], new_matrix[i-1][j],new_matrix[i][j-1]}) + 1;
                    sum += new_matrix[i][j];
                }
            }
        }
        return sum;
    }
};