# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        num1 = 0
        num2 = 0
        p1 = l1
        p2 = l2
        i = 0
        while p1 != None:
            num1 += p1.val * (10**i)
            i += 1
            p1 = p1.next
        i = 0
        while p2 != None:
            num2 += p2.val * (10**i)
            i += 1
            p2 = p2.next
        num = num1 + num2
        x = num % 10
        num = num / 10
        result = ListNode(x)
        p = result
        while num > 0 :
            x = num % 10
            num = num / 10
            temp = ListNode(x)
            p.next = temp
            p = temp
        return result