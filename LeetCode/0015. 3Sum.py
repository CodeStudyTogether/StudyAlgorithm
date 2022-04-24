class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        L = []
        
        for i in range(len(nums)-2):
            if  i > 0 and nums[i] == nums[i-1]:
                continue
            h = i+1;e = len(nums)-1
            while h < e:
                sume = nums[i] + nums[h] + nums[e]
                if sume < 0:
                    h += 1
                elif sume > 0:
                    e -= 1
                else:
                    L.append((nums[i],nums[h],nums[e]))
                    while h < e and nums[h] == nums[h+1]:
                        h += 1
                    while h < e and nums[e] == nums[e-1]:
                        e -= 1
                    h += 1;e -= 1
        return L
