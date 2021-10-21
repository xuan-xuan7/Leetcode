def checkValidString(s):
    """
    :type s: str
    :rtype: bool
    """

    # 栈：重点是要纪录*的数量和位置，最后在进行处理
    # ( 的位置记录为正数， ) 的位置纪录为负数

    zhan = []
    star = []
    n = len(s)

    for i in range(n):
        if s[i] == "(":
            zhan.append(i)
        elif s[i] == ")":
            if len(zhan) != 0 and zhan[-1] >= 0 and s[zhan[-1]] == "(":
                print(zhan[-1])
                zhan.pop()
            else:
                zhan.append(-i)
        else:
            star.append(i)
    print(zhan,star)

    while len(zhan) != 0 and len(star) != 0:
        if zhan[-1] < 0:
            while len(star) !=0 and star[-1] > -zhan[-1]:
                star.pop()
            if len(star) != 0:
                zhan.pop()
                star.pop()
            else:
                return False
        elif zhan[-1] > 0:
            if star[-1] > zhan[-1]:
                zhan.pop()
                star.pop()
            else:
                return False
        else:
            if s[0] == "(":
                if len(star) != 0:
                    star.pop()
                    zhan.pop()
            else:
                return False

    if len(zhan) == 0:
        return True
    else:
        return False


result = checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()")
print(result)