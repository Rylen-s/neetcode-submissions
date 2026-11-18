class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        inDegree = [0] * numCourses
        adj_list = defaultdict(list)

        for course, preq in prerequisites:
            inDegree[course] += 1
            adj_list[preq].append(course)
        
        queue = deque()

        for course, preqs in enumerate(inDegree):
            if preqs == 0:
                queue.append(course)
        res = []
        while queue:
            course = queue.popleft()
            res.append(course)
            for nexts in adj_list[course]:
                inDegree[nexts] -= 1
                if inDegree[nexts] == 0:
                    queue.append(nexts)

        return res if len(res) == numCourses else []

