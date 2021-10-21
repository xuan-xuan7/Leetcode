def twoSum(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    # hash搜索，先建立hash表

    hash_table = {}
    count = 0

    for num1 in nums:
        num2 = target - num1
        if num2 in hash_table:
            return [count, hash_table[num2]]
        else:
            hash_table[num1] = count
        count += 1
    return -1

print(twoSum([2,7,11,15], 26))