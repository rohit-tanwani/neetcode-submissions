class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chars = [0] * 26
        print(chars)
        for i in s:
            index = ord(i) - ord('a')
            chars[index]+=1

        for i in t:
            index = ord(i) - ord('a')
            chars[index]-=1

        for i in chars:
            if i != 0:
                return False

        return True
