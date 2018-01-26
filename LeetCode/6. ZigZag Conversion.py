class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if len(s) <= numRows or numRows == 1:
            return s
        row,step = 0,1
        strs = [''] * numRows
        for char in s:
            strs[row] = strs[row] + char
            if row == 0:
                step = 1
            elif row == numRows-1:
                step = -1
            row += step
        return ''.join(strs)