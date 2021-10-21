def chalkReplacer(chalk, k):
    """
    :type chalk: List[int]
    :type k: int
    :rtype: int
    """

    n = len(chalk)
    per_loop = 0

    for i in chalk:
        per_loop += i

    rest = k % per_loop

    for student_num in range(n):
        rest -= chalk[student_num]
        if rest < 0:
            return student_num


num = chalkReplacer([3,4,1,0], 25)
print(num)
