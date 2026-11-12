/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        // Map
        // Opening and closing an interval
        // At 0 when we start an interval, +1, 40 we close, -1
        // Fill this map, iterate the map, keep a running total, and take the max
        std::map<int, int> m;
        int max = 0;
        int cnt = 0;
        // [1,0,0,-1,1,0,0,0]

        for (auto& i : intervals) {
            m[i.start] += 1;
            m[i.end] -= 1;
        }

        for(const auto& [key,val] : m) {
            cnt += val;
            max = std::max(max, cnt);
        }

        return max;




    }
};
