class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        i = 0
        dnow = {}
        longest = 0
        while i < len(s):
            if s[i] in dnow:
                longest = max(longest, len(dnow))               
                i = dnow[s[i]]+1
                dnow = {}
                continue
            dnow[s[i]]=i
            i += 1
        longest = max(longest, len(dnow))
        return longest