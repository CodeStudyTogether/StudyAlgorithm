public class Solution {
    /**
     * 直接递归就可以：
     * 规则是，下一位填入的数字，不得小于当前的，其他没有了
     剑指offer的做法是找出n个数字中m的数字的组合方法是，把n个数字分成两部分：第一个字符和其他的字符。如果组合中包括第一个字符，那么就在其余字符中找到m-1个组合；如果组合中不包括第一个字符，那么就在其余字符中找到m个字符。所以变成了递归的子问题。
     * */
    List<List<Integer>> result;
    public void find(int n,int remains,List<Integer> tmp,int index){
        if(remains==0){
            List<Integer> t= new ArrayList<Integer>();
            t.addAll(tmp);
            result.add(t);
            return ;
        }
        //注意最右边那个条件，是为了防止无用的递归，因为剩下的位数必须要足够，所以加入了一个判断
        for(int i=index;i<=n && i+remains-1<=n;i++){
            tmp.add(i);
            find(n,remains-1,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        result=new ArrayList<List<Integer>>();
        find(n,k,new ArrayList<Integer>(),1);
        return result;
    }
}
