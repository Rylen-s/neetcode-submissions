class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        res = 0
        l , r = 0, len(people) - 1
        while people[r] == limit and r > -1:
            res += 1
            r -= 1
        print(r)
        while l <= r:
            if l == r:
                res += 1
                print("odd")
                break
            if people[l] + people[r] <= limit:
                res += 1
                l += 1
                r -= 1
                print("dub")
            else:
                res += 1
                r -= 1
                print("right too big")
            print(l)
            print(r)
        return res
