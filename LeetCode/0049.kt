import java.util.ArrayList
import java.util.Arrays
import java.util.HashMap

class Solution {//方法很巧妙，查重
    fun groupAnagrams(strs: Array<String>?): List<List<String>> {
        if (strs == null || strs.size == 0) return ArrayList()
        val map = HashMap<String, ArrayList<String>>()
        for (s in strs) {
            val ca = s.toCharArray()//该方法的作用是返回一个字符数组，该字符数组中存放了当前字符串中的所有字符
            Arrays.sort(ca)
            val keyStr = String(ca)
            if (!map.containsKey(keyStr)) map[keyStr] = ArrayList()
            map[keyStr]?.add(s)
        }
        return ArrayList(map.values)
    }
}
