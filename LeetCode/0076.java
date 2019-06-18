这道题给了我们一个原字符串S，还有一个目标字符串T，让我们在S中找到一个最短的子串，使得其包含了T中的所有的字母，并且限制了时间复杂度为 O(n)。
https://www.cnblogs.com/springfor/p/3872559.html
https://blog.csdn.net/zjkC050818/article/details/76098195

class Solution {
    public String minWindow(String S, String T) {
      String res = "";
      if(S == null || T == null || S.length()==0 || T.length()==0)//边界情况
          return res;

      //Java语言为内置数据类型char提供了包装类Character类。
      //// HashMap的key为t中各个字符，value为对应字符个数
      HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
      for(int i =0;i < T.length(); i++){
          if(!dict.containsKey(T.charAt(i)))
              dict.put(T.charAt(i), 1);
          else
              dict.put(T.charAt(i), dict.get(T.charAt(i))+1);
      }

      int count = 0;
      int pre = 0;
      int minLen = S.length()+1;
      for(int i=0;i<S.length();i++){
          if(dict.containsKey(S.charAt(i))){
              dict.put(S.charAt(i),dict.get(S.charAt(i))-1);
              if(dict.get(S.charAt(i)) >= 0)
                  count++;

              while(count == T.length()){
                  if(dict.containsKey(S.charAt(pre))){
                      dict.put(S.charAt(pre),dict.get(S.charAt(pre))+1);

                      if(dict.get(S.charAt(pre))>0){
                          if(minLen>i-pre+1){
                              res = S.substring(pre,i+1);
                              minLen = i-pre+1;
                          }
                          count--;
                      }
                  }
                  pre++;
              }
          }//end for if(dict.containsKey(S.charAt(i)))
      }
      return res;
  }
}
