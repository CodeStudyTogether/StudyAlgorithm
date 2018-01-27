class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0 or (x%10 == 0 and x != 0):
            return False
        if x <= 9:
            return True
        
        revSum = 0
        while x > revSum:
            revSum = revSum*10 + x%10
            x = x//10
            
        if revSum > 2**31-1:
            return False
        if x == revSum:
            return True
            