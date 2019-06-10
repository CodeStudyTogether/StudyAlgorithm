public class Solution {
  //给了字符串T1和字符串T2，试问通过插入、删除、替换等的操作，T1可以通过几步变换成T2
  //给出两个单词word1和word2，计算出将word1转换为word2的最少操作次数。
  //https://blog.csdn.net/u013309870/article/details/75193592
  //Leetcode上好多动态规划的题 ， 一般碰到这样的题，我第一眼是懵逼了，然后深呼吸一下，先用递归把做出来，结果显然，TLE。既然能用递归，就肯定可以用动态规划，然后就把递归变成动态规划，变成动态规划后看能不能再优化空间，如果不能，就直接return了，如果能就优化，这个现在已经成为套路了。
  //http://zgljl2012.com/leetcode-72-edit-distance/ 
  //https://juejin.im/post/5ba26e31e51d450e8477a90a
  public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length(),cost;
        int dp[][]=new int [n+1][m+1];
        //初始化
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int i=0;i<=m;i++)
            dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                cost= word1.charAt(i-1)==word2.charAt(j-1)?0:1;
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+cost);
            }
        }
        return dp[n][m];
    }
}
