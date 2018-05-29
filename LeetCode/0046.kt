//46. Permutations
//非递归实现的思路，假设我们有了当前前 i 个元素的组合，当第 i+1个元素加入时，我们需要做的是将这个元素加入之前的每一个结果，并且放在每个结果的每个位置，因为之前的结果没有重复，所以加入新元素的结果也不会有重复
fun permute(num: IntArray): List<List<Int>> {//例如[1,2,3]
    var ans: MutableList<List<Int>> = ArrayList()
    if (num.size == 0) return ans
    val temp = ArrayList<Int>()
    temp.add(num[0])
    ans.add(temp)//ans is [[1]]
    for (i in 1 until num.size) {
        val new_ans = ArrayList<List<Int>>()//create a new [[]]
        for (j in 0..i) {
            for (l in ans) {
                val new_l = ArrayList(l)
                new_l.add(j, num[i])
                new_ans.add(new_l)
            }
        }
        ans = new_ans
    }
    return ans
}