# 最短路径：BFS
# 状态压缩：用mask上第i位表示是否有第i把钥匙

from collections import deque


class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        m = len(grid)
        n = len(grid[0])
        sx = 0
        sy = 0
        key_to_idx = dict()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    sx = i
                    sy = j
                # 是钥匙，并且给钥匙编号
                elif grid[i][j].islower():
                    if grid[i][j] not in key_to_idx:
                        idx = len(key_to_idx)
                        key_to_idx[grid[i][j]] = idx

        # BFS队列
        q = deque([(sx, sy, 0)])
        dist = dict()
        # 记录做过的路程和路程长度
        dist[(sx, sy, 0)] = 0
        while q:
            x, y ,mask = q.popleft()
            # 向四周搜索
            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                # 在范围内且不为墙
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != "#":
                    # 是空房间或者起点
                    if grid[nx][ny] == "." or grid[nx][ny] == "@":
                        # 没有访问过
                        if (nx, ny, mask) not in dist:
                            # 记录走过的路程长度
                            dist[(nx, ny, mask)] = dist[(x, y, mask)] + 1
                            # 进入BFS队列
                            q.append((nx, ny, mask))
                    # 是钥匙
                    elif grid[nx][ny].islower():
                        idx = key_to_idx[grid[nx][ny]]
                        # 这个钥匙没有被获取过
                        if (nx, ny, mask | (1 << idx)) not in dist:
                            # 记录获取钥匙
                            dist[(nx, ny, mask | (1 << idx))] = dist[(x, y, mask)] + 1
                            # 如果所有钥匙均被获取则返回
                            if (mask | (1 << idx)) == (1 << len(key_to_idx)) - 1:
                                return dist[nx, ny, mask | (1 << idx)]
                            q.append((nx, ny, mask | (1 << idx)))
                    # 是锁
                    else:
                        # 是哪一把锁
                        idx = key_to_idx[grid[nx][ny].lower()]
                        # 能开锁，且并没有被遍历过
                        if (mask & (1 << idx)) and (nx, ny, mask) not in dist:
                            dist[(nx, ny, mask)] = dist[(x, y, mask)] + 1
                            q.append((nx, ny, mask))
        return -1