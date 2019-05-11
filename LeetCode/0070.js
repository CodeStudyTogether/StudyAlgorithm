//solution from leetcode discuss
/**
 * @param {number} n
 * @return {number}
 */
//我们知道第 n 阶只与第 n - 1 阶和 第 n - 2 阶有关，关系为ways[n] = ways[n - 1] + ways[n - 2]，存储的时候只需要2个存储单元，本题用ways[0]存 n - 2 阶的走法数，ways[1]存储 n - 1 阶走法数
var climbStairs = function(n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    var one_step_before = 2;
    var two_steps_before = 1;
    var all_ways = 0;
    
    for(var i=2; i<n; i++){
      all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
      one_step_before = all_ways;
    }
    return all_ways;
};
