# -*- coding: utf-8 -*-
"""
Created on Wed Dec 06 15:14:47 2017

@author: liuyi
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
l1 = ListNode(1)
l2 = ListNode(9)
l2.next = ListNode(9)
def addTwoNumbers(l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    result = l1
    p1 = l1
    p2 = l2
    exc = 0
    while p1 != None:
        if p2 != None:
            re = p1.val + p2.val + exc
            exc = re / 10
            val = re % 10
            p1.val = val
            p2 = p2.next
        else:
            p1.val += exc
            exc = p1.val / 10
            p1.val = p1.val % 10
        pre = p1
        p1 = p1.next
    p1 = pre
    print p1.val
    while p2 != None:
        re = p2.val + exc
        exc = re / 10
        val = re % 10
        print re, exc, val
        temp = ListNode(val) 
        p1.next = temp
        pre = p1
        p1 = p1.next
        p2 = p2.next
    if exc != 0:
        temp = ListNode(exc) 
        p1.next = temp
    return result
    
l = addTwoNumbers(l1,l2)
while l !=None:
    print l.val
    l = l.next