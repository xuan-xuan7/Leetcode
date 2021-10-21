def findLongestWord(s, dictionary):
    """
    :type s: str
    :type dictionary: List[str]
    :rtype: str
    """

    # 将dictionary中字符按长度排序，并且序号小的在前面

    dic_len = {}
    length = len(s)

    for str in dictionary:
        n = len(str)
        if n not in dic_len.keys():
            dic_len[n] = [str]
        else:
            dic_len[n].append(str)


    sort_len = sorted(dic_len.keys(), reverse=True)
    sort_dic = {}
    for i in sort_len:
        sort_dic[i] = dic_len[i]
    for key in sort_dic.keys():
        sort_dic[key].sort()


    for key in sort_dic.keys():
        for string in sort_dic[key]:
            count_str = 0
            count_s = 0
            while count_s != length and count_str != key:
                if s[count_s] == string[count_str]:
                    count_str += 1
                count_s += 1
            if count_str == key:
                return string
    return ""


str = findLongestWord("abce", ["abe","abc"])
print(str)