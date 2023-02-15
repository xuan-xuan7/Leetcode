# 裴蜀定理
# 若g是a和b的最大公约数，那么存在整数x和y,使得ax+by=g
# 可以推广到n个数的情况上
# 从头开始遍历数组，求出已经遍历过的元素的最大公约数，只要出现1的情况，就可以结束遍历
# reduce()函数用法

from functools import reduce
import math


class Solution:
    def isGoodArray(self, nums: list[int]) -> bool:
        return reduce(math.gcd, nums) == 1