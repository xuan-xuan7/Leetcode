from typing import List

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if len(lists) != 0:
            queue = []
            for i in range(len(lists)):
                if lists[i].val != -1:
                    while lists[i] != None:
                        queue.append(lists[i].val)
                        lists[i] = lists[i].next
            queue.sort()
            head = ListNode(-1, None)
            cur = head
            for i in range(len(queue)):
                cur.val = queue[i]
                if i != len(queue) - 1:
                    cur.next = ListNode(0, None)
                    cur = cur.next
            return head
        else:
            return None


def main():
    input_list = eval(input())
    for j in range(len(input_list)):
        temp = input_list[j]
        head = ListNode(-1, None)
        cur = head
        for i in range(len(temp)):
            cur.val = temp[i]
            if i != len(temp) - 1:
                cur.next = ListNode(0, None)
                cur = cur.next
        input_list[j] = head
    sol = Solution()
    head = sol.mergeKLists(input_list)
    temp = head
    while temp.val != -1:
        print(temp.val)
        temp = temp.next


if __name__ == '__main__':
    main()
