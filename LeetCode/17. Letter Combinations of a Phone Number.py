class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        d = {"0":" ","1":" ","2":"abc","3":"def","4":"ghi","5":"jkl","6":"mno","7":"pqrs","8":"tuv","9":"wxyz"}
        if len(digits) == 0:
            return []
        elif len(digits) == 1:
            return list(d[digits])
        elif "0" in digits or "1" in digits:
            return False
        
        l_dig = len(digits)
        res = [""]
        for i in range(l_dig):
            strs = d[digits[i]];temp = []
            for j in range(len(res)):
                for k in range(len(strs)):
                    temp.append(res[j] + strs[k])
            res = temp
        return res