class Solution {
    fun lengthOfLastWord(s: String): Int {
        var length = 0
        for (i in s.length - 1 downTo 0) {
            if(s[i] == ' '){
                if(length != 0){
                    return length
                }
            } else {
                length++
            }
        }
        return length
    }
}

from leetcode:
class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s.trim { it <= ' ' }.length - s.trim { it <= ' ' }.lastIndexOf(" ") - 1
    }
}
