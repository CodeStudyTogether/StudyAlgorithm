class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        charDict = {}
        start = length = longest = 0  
        for i in range(len(s)):
            if s[i] not in charDict or charDict[s[i]] < start:
                length += 1
                charDict[s[i]] = i
                
                if length > longest:
                    longest = length
                    
            else:
                start = charDict[s[i]] + 1
                charDict[s[i]] = i
                length = i - start + 1
        return longest