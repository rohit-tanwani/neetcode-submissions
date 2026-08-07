class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums_set = set()
        for item in nums:
            if item in nums_set:
                return True
            nums_set.add(item)
            
        return False
        