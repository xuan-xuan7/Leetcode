import heapq

class Solution(object):
    def findMaximizedCapital(self, k, w, profits, capital):
        """
        :type k: int
        :type w: int
        :type profits: List[int]
        :type capital: List[int]
        :rtype: int
        """
        # 大根堆排序
        # 使用heapq可以快速建堆，heapq构建的是小根堆

        project = zip(profits, capital)
        sorted_project = sorted(project, key=lambda x:x[1], reverse=True)
        n = len(profits)
        cur_heap = []

        while k > 0:
            while True:
                if len(sorted_project) != 0 and sorted_project[-1][1] <= w:
                    heapq.heappush(cur_heap, -sorted_project[-1][0])
                    sorted_project.pop()
                else:
                    break
            if len(cur_heap) != 0:
                w = w - heapq.heappop(cur_heap)
                k -= 1
            else:
                break
        return w

solution = Solution()
w = solution.findMaximizedCapital(10, 0, [1,2,3], [0,1,2])
print(w)