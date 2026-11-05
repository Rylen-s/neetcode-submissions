class Solution:
    def leastInterval(self, tasks: List[str], cooldown: int) -> int:
        if len(tasks) == 0:
            return 0
        count = {}

        for task in tasks:
            count[task] = count.get(task,0) + 1
        m = 0
        which = 0
        amt = 0
        for task,val in count.items():
            if val > m:
                m = val
                which = task
                amt = 0
            if val == m:
                amt += 1
        
        return max((m-1)*(cooldown + 1) + amt, len(tasks))