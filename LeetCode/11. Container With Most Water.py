class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i,j = 0,len(height) - 1
        maxArea = 0
        while i < j:
            if height[i] >= height[j]:
                temp = height[j] * (j-i)
                j -= 1
            else:
                temp = height[i] * (j-i)
                i += 1
            maxArea = max(maxArea,temp)
        return maxArea