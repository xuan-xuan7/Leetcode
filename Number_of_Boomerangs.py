def numberOfBoomerangs(points):
    """
    :type points: List[List[int]]
    :rtype: int
    """

    # 遍历列表，计算不同点到同一点的距离，并存储在字典中

    hash_dict = {}
    num = 0

    for i in points:
        hash_dict.clear()
        for j in points:
            if i == j:
                continue
            else:
                dis = (i[0]-j[0]) ** 2 + (i[1]-j[1]) ** 2
                if dis in hash_dict.keys():
                    hash_dict[dis].append(j)
                else:
                    hash_dict[dis] = [j]
        for value in hash_dict.values():
            n = len(value)
            num += n * (n-1)

    return num

num = numberOfBoomerangs([[1,1]])
print(num)