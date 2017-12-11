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
        pre = None
        exc = 0
        n1 = l1 
        n2 = l2
        x = n1.val + n2.val + exc
        val = x % 10
        exc = x / 10
        n1 = n1.next
        n2 = n2.next
        result = ListNode(val)
        p = result
        while (n1 != None) & (n2 != None):
            x = n1.val + n2.val + exc
            val = x % 10
            exc = x / 10
            n1 = n1.next
            n2 = n2.next
            temp = ListNode(val)
            p.next = temp
            p = temp
        if n2 == None:
            n2 = n1
        while n2 != None:
            x = n2.val + exc
            val = x % 10
            exc = x / 10
            temp = ListNode(val)
            p.next = temp
            p = temp
        if exc != 0:
            temp = ListNode(exc)
            p.next = temp
            p = temp
            
        return result