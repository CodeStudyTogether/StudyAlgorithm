class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        
        sign = -1 if x < 0 else 1
        x = abs(x)
        ans = 0
        while x:
            ans = ans*10 + x%10
            x = x // 10
        
        if ans > 2**31 - 1:
            return 0
        else:
            return ans*sign
        