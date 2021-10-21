def findIntegers(n):
    """
    :type n: int
    :rtype: int
    """

    # 通过观察可以发现，k位的二进制数符合条件的数一共有：a[0]+a[1]+...+a[k-2]个，其中a[]为对应位数的符合条件的二进制数
    # 最后要进行剪枝

    result = []
    result.append(2)
    result.append(1)
    num = 0

    k = len(bin(n)) - 2

    for i in range(2,k):
        result.append(0)
        for j in range(i-1):
            result[i] += result[j]
    for i in range(k):
        num += result[i]

    bin_num = bin(n)[2:]
    while len(bin_num) > 2:
        if bin_num[0:2] == "11":
            break
        elif bin_num[0:2] == "10":
            bin_num = bin_num[2:]
        elif bin_num[0:2] == "01":
            num -= result[len(bin_num)-1]
            bin_num = bin_num[1:]
        else:
            num = num - result[len(bin_num)-1] - result[len(bin_num)-2]
            bin_num = bin_num[2:]
    if len(bin_num) == 1:
        if bin_num[0] == "0":
            num -= 1
    if len(bin_num) == 2:
        if bin_num == "00":
            num -= 2
        elif bin_num == "01":
            num -= 1

    return num


num = findIntegers(18)
print(num)