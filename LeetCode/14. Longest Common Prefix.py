class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        res = ''
        if len(strs) > 0:
            strs.sort()
            a = strs[0]
            b = strs[len(strs) - 1]
            
            for i in range(len(a)):
                if a[i] == b[i]:
                    res += b[i]
                else:
                    return res
        return res