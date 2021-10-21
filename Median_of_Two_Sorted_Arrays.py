from typing import List
import sys
import math


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        length = m + n
        if m == 0 and n == 0:
            return None
        elif m != 0 and n == 0:
            if m % 2 == 0:
                return float((nums1[int(m / 2 - 1)] + nums1[int(m / 2)]) / 2)
            else:
                k = math.floor(m / 2)
                return float(nums1[k])
        elif m == 0 and n != 0:
            if n % 2 == 0:
                return float((nums2[int(n / 2 - 1)] + nums2[int(n / 2)]) / 2)
            else:
                k = math.floor(n / 2)
                return float(nums2[k])
        else:
            if length % 2 == 0:
                k = int(length / 2)
            else:
                k = int((length + 1) / 2)
            t = min(len(nums1), len(nums2), math.floor(k / 2))
            while t != 0:
                if nums1[t - 1] < nums2[t - 1]:
                    nums1 = nums1[t:]
                    k = k - t
                    t = min(len(nums1), len(nums2), math.floor(k / 2))
                else:
                    nums2 = nums2[t:]
                    k = k - t
                    t = min(len(nums1), len(nums2), math.floor(k / 2))
            if k > 1:
                if len(nums1) == 0:
                    if length % 2 == 0:
                        k1 = nums2[k - 1]
                        k2 = nums2[k]
                        return (k1 + k2) / 2
                    else:
                        return nums2[k - 1]
                else:
                    if length % 2 == 0:
                        k1 = nums1[k - 1]
                        k2 = nums1[k]
                        return (k1 + k2) / 2
                    else:
                        return nums1[k - 1]
            else:
                if length % 2 == 0:
                    if len(nums1) != 0 and len(nums2) != 0:
                        if nums1[0] < nums2[0]:
                            k1 = nums1[0]
                            if len(nums1) > 1:
                                nums1 = nums1[1:]
                                if nums1[0] < nums2[0]:
                                    k2 = nums1[0]
                                else:
                                    k2 = nums2[0]
                            else:
                                k2 = nums2[0]
                        else:
                            k1 = nums2[0]
                            if len(nums2) > 1:
                                nums2 = nums2[1:]
                                if nums1[0] < nums2[0]:
                                    k2 = nums1[0]
                                else:
                                    k2 = nums2[0]
                            else:
                                k2 = nums1[0]
                    elif len(nums1) == 0:
                        k1 = nums2[0]
                        k2 = nums2[1]
                    else:
                        k1 = nums1[0]
                        k2 = nums1[1]
                    return (k1 + k2) / 2
                else:
                    if len(nums1) != 0 and len(nums2) != 0:
                        if nums1[0] < nums2[0]:
                            return nums1[0]
                        else:
                            return nums2[0]
                    elif len(nums1) == 0:
                        return nums2[0]
                    else:
                        return nums1[0]


def main():
    input_list = []
    for line in sys.stdin:
        temp = line.split()
        if len(temp) == 0:
            break
        input_list.extend(temp)
    nums1 = eval(input_list[0])
    nums2 = eval(input_list[1])
    sol = Solution()
    print(sol.findMedianSortedArrays(nums1, nums2))


if __name__ == '__main__':
    main()
