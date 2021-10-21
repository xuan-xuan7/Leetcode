def romanToInt(s):
    """
    :type s: str
    :rtype: int
    """

    convert = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
    special = ["I", "X", "C"]
    num = 0
    n = len(s)

    for i in range(n):
        if s[i] not in special:
            num += convert[s[i]]
        else:
            if i != n-1:
                if s[i] == "I" and (s[i+1] == "V" or s[i+1] == "X"):
                    num -= convert[s[i]]
                elif s[i] == "X" and (s[i+1] == "L" or s[i+1] == "C"):
                    num -= convert[s[i]]
                elif s[i] == "C" and (s[i+1] == "D" or s[i+1] == "M"):
                    num -= convert[s[i]]
                else:
                    num += convert[s[i]]
            else:
                num += convert[s[i]]
    return num


num = romanToInt("MCMXCIV")
print(num)