class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        result = nums[0] + nums[1] + nums[2]
        for i in range(len(nums)-2):
            h = i+1;e = len(nums)-1
            while h < e:
                sume = nums[i] + nums[h] + nums[e]
                if sume == target:
                    return sume
                
                if abs(result-target) > abs(sume-target):
                    result = sume
                    
                if sume > target:
                    e -= 1
                elif sume < target:
                    h += 1
        return result