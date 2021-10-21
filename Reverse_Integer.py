def reverse(x):
    """
    :type x: int
    :rtype: int
    """

    str_x = str(x)
    zhan = []
    reverse_x = []
    digit = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    result = ""

    for i in str_x:
        if i in digit:
            zhan.append(i)
        else:
            reverse_x.append(i)
    while len(zhan) != 0:
        if zhan[-1] == "0":
            zhan.pop()
        else:
            break
    if len(zhan) == 0:
        return 0
    while len(zhan) != 0:
        reverse_x.append(zhan[-1])
        zhan.pop()
    for i in reverse_x:
        result = result + i
    return int(result)

w = reverse(0)
print(w)