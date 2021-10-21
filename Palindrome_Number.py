def isPalindrome(x):
    """
    :type x: int
    :rtype: bool
    """

    y = str(x)[::-1]
    print(y)
    if str(x) == y:
        return True
    else:
        return False

print(isPalindrome(121))