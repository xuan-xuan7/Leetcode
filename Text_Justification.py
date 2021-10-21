def fullJustify(words, maxWidth):
    """
    :type words: List[str]
    :type maxWidth: int
    :rtype: List[str]
    """

    # 贪心算法，尽可能多的插入单词

    result_list = []
    cur_len = maxWidth
    count = 0
    result_list.append([])
    result = []

    for word in words:
        word_len = len(word)
        if (cur_len - word_len) >= 0:
            cur_len -= word_len
            result_list[count].append(word)
            if cur_len > 0:
                result_list[count].append(" ")
                cur_len -= 1
            else:
                count += 1
                result_list.append([])
                cur_len = maxWidth
        else:
            n = len(result_list[count])
            if n == 2:
                for i in range(cur_len):
                    result_list[count].append(" ")
                count += 1
                result_list.append([])
                cur_len = maxWidth
            else:
                if n % 2 == 0:
                    space = cur_len + 1
                    result_list[count].pop()
                    word_num = int(n / 2)
                    per_space = []
                    per_space_num = space // (word_num-1)
                    for i in range(word_num-1):
                        per_space.append(per_space_num)
                    space_mod = space % (word_num-1)
                    for i in range(space_mod):
                        per_space[i] += 1
                    for i in range(1, word_num):
                        add = " "
                        for j in range(per_space[i-1]):
                            add += " "
                        result_list[count][2 * i - 1] = add
                    count += 1
                    result_list.append([])
                    cur_len = maxWidth
                else:
                    count += 1
                    result_list.append([])
                    cur_len = maxWidth
            cur_len -= word_len
            result_list[count].append(word)
            if cur_len > 0:
                result_list[count].append(" ")
                cur_len -= 1
            else:
                count += 1
                result_list.append([])
                cur_len = maxWidth


    for row in result_list:
        row_str = ""
        for ch in row:
            row_str += ch
        result.append(row_str)
    if result[-1] == "":
        result.pop()
    add = maxWidth - len(result[-1])
    for i in range(add):
        result[-1] += " "

    return result

result = fullJustify(["ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"],16)
print(result)