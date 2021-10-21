
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if head == None:
            return None
        first_big = head
        while first_big.next != None:
            if first_big.val >= x:
                break
            else:
                first_big = first_big.next
        if first_big == head:
            cur = first_big.next
            cur_pre = first_big
            if cur == None:
                return head 
            while cur != None:
                if cur.val < x:
                    cur_pre.next = cur.next
                    cur.next = first_big
                    head = cur
                    break
                else:
                    if cur.next != None:
                        cur = cur.next
                        cur_pre = cur_pre.next
                    else:
                        return head
        pre = head
        while pre.next != first_big:
            pre = pre.next
        cur = first_big.next
        cur_pre = first_big
        while cur != None:
            if cur.val < x:
                pre.next = cur
                pre = pre.next
                cur_pre.next = cur.next
                cur.next = first_big
                cur = cur_pre.next
            else:
                cur = cur.next
                cur_pre = cur_pre.next
        return head


def main():
    input_list = input().split(" ")
    NodeVal = []
    NodeVal = eval(input_list[0])
    x = int(input_list[1])
    head = ListNode(0)
    cur = head
    for val in NodeVal:
        cur.val = val
        cur_new = ListNode(0)
        cur.next = cur_new
        cur = cur.next
    sol = Solution()
    head = sol.partition(head, x)
    cur = head
    while cur.next != None:
        print(cur.val)
        cur = cur.next


if __name__ == '__main__':
    main()
