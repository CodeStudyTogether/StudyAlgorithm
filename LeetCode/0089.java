//https://blog.csdn.net/u013564276/article/details/51362690

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            return list;
        }
        if (n == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> grayM = grayCode(n - 1);//递归
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2,n); i++) {//递归
            if (i < Math.pow(2, n-1)) { //前面一半的数字不变
                list.add(grayM.get(i));    
            } else { //后面一半的数字反向排列，再在前面添加一个‘1’
                int res =  grayM.get( (int)Math.pow(2, n) - i - 1 ) + (int)Math.pow(2, n - 1);
                list.add(res);  
            }
        }
        return list;
    }
}
