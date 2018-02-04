class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dic = {'(':')','{':'}','[':']'}
        stack = []
        for c in s:
            if c in '({[':
                stack.append(dic[c])
            elif len(stack) == 0 or c != stack.pop():
                return False
        return not len(stack)