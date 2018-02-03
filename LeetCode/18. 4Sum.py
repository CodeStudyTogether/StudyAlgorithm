class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        nums.sort()
        res = []
        for i in range(len(nums)-3):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            for j in range(i+1,len(nums)-2):
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                h = j + 1;e = len(nums)-1
                while h < e:
                    sume = nums[i] + nums[j] + nums[e] + nums[h]
                    if sume == target:
                        res.append((nums[i],nums[j],nums[e],nums[h]))
                        while h < e and nums[e] == nums[e-1]:
                            e -= 1
                        while h < e and nums[h] == nums[h+1]:
                            h += 1
                        e -= 1;h += 1
                    elif sume < target:
                        h += 1
                    else:
                        e -= 1
        return res