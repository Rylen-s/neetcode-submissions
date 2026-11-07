class Solution {
public:
    int leastInterval(vector<char>& tasks, int cooldown) {
    // Frequency Map
    // Populate map and determine largest freq
    // Determine which other tasks share the largest
    // Use math
    
    std::unordered_map<char, int> map;
    int len = tasks.size();

    int max = 0;
    int cnt = 1;
    for(char c : tasks){
      if (++map[c] > max) {
        max = map[c];
        cnt = 1;
      }
      else if(map[c] == max) {
        cnt++;
      }
    }
    return std::max(len,(cooldown + 1) * (max - 1) + cnt);
    }
};