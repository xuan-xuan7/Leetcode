class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        cur = head
        length = 0
        while cur != None:
            length = length + 1
            cur = cur.next
        next_length = k
        cur = head
        pre_k_head = None
        if k > 1:
            while next_length <= length:
                k_head = cur
                pre = cur
                cur = cur.next
                last = cur
                cur = cur.next
                for i in range(0, k - 1):
                    last.next = pre
                    print(last.val, pre.val)
                    if i != (k - 2):
                        pre = last
                        last = cur
                        cur = cur.next
                    else:
                        break
                if pre_k_head != None:
                    pre_k_head.next = last
                pre_k_head = k_head
                if next_length == k:
                    head = last
                next_length = next_length + k
            if pre_k_head != None:
                pre_k_head.next = cur
        return head


def main():
    row = []
    row = input().split(" ")
    k = int(row[1])
    NodeVal = []
    NodeVal = eval(row[0])
    head = ListNode(0, None)
    cur = ListNode(0, None)
    head = cur
    for i in range(0, len(NodeVal)):
        cur.val = NodeVal[i]
        next_node = ListNode(0, None)
        cur.next = next_node
        cur = cur.next
    sol = Solution()
    head = sol.reverseKGroup(head, k)
    cur = head
    while cur != None:
        print(cur.val)
        cur = cur.next


if __name__ == '__main__':
    main()
