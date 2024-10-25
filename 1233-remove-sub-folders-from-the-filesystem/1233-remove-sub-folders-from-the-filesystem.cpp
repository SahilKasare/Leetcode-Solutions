class Solution {
public:
        vector<string> removeSubfolders(vector<string>& folders) {
            sort(folders.begin(), folders.end());
            
            vector<string> result;
            
            result.push_back(folders[0]);
            
            for (int i = 1; i < folders.size(); i++) {
                const string& currentFolder = folders[i];
                const string& lastAddedFolder = result.back();
                
                if (currentFolder.find(lastAddedFolder + "/") != 0) {
                    result.push_back(currentFolder);
                }
            }
            
            return result;
        }

    void printFolders(const vector<string>& folders) {
        for (const auto& folder : folders) {
            cout << folder << " ";
        }
        cout << endl;
    }
};