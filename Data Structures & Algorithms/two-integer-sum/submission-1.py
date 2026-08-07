class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_count = {}

        for i in nums:
            if i in nums_count:
                nums_count[i]+=1
            else:
                nums_count[i] = 1

        second_number = None
        first_index = -1
        second_index = -1
        for i in nums:
            first_index+=1
            nums_count[i]-=1
            target_left = target - i
            if target_left in nums_count and nums_count[target_left] > 0:
                second_number = target_left
                break

        for i in nums:
            second_index+=1
            if i == second_number and second_index != first_index:
                break
                 

        return [first_index,second_index]