/**
 * @param {string} s
 * @return {boolean}
 参考： https://www.cnblogs.com/ariel-dreamland/p/9151000.html
1. 在讨论开头、中间、结尾三个不同位置之前做预处理，去掉字符串首尾的空格，可以采用两个指针分别指向开头和结尾，遇到空格则跳过，
分别指向开头结尾非空格的字符。
2. 对首字符进行处理，首字符只能为数字或者正负号 '+/-"，我们需要定义三个flag以标志我们之前检是否测到过小数点，
自然数和正负号。首字符如为数字或正负号，则标记对应的flag，若不是，直接返回false。
3. 对中间字符的处理，中间字符会出现五种情况，数字，小数点，自然数，正负号和其他字符。
若是数字，标记flag并通过。
若是自然数，则必须是第一次出现自然数，并且前一个字符不能是正负号，而且之前一定要出现过数字，才能标记flag通过。
若是正负号，则之前的字符必须是自然数e，才能标记flag通过。
若是小数点，则必须是第一次出现小数点并且自然数没有出现过，才能标记flag通过。
若是其他，返回false。
4. 对尾字符处理，最后一个字符只能是数字或小数点，其他字符都返回false。
若是数字，返回true。
若是小数点，则必须是第一次出现小数点并且自然数没有出现过，还有前面必须是数字，才能返回true。
 */
var isNumber = function(s) {
  var len = s.length;
  var left = 0;
  var right = len - 1;
  var eExisted = false;
  var dotExisted = false;
  var digitExisited = false;
  // Delete spaces in the front and end of string
  while (s[left] == ' ') ++left;
  while (s[right] == ' ') --right;
  // If only have one char and not digit, return false
  if (left >= right && (s[left] < '0' || s[left] > '9')) return false;
  //Process the first char
  if (s[left] == '.') dotExisted = true;
  else if (s[left] >= '0' && s[left] <= '9') digitExisited = true;
  else if (s[left] != '+' && s[left] != '-') return false;
  // Process the middle chars
  for (var i = left + 1; i <= right - 1; ++i) {
      if (s[i] >= '0' && s[i] <= '9') digitExisited = true;
      else if (s[i] == 'e' || s[i] == 'E') { // e/E cannot follow +/-, must follow a digit
          if (!eExisted && s[i - 1] != '+' && s[i - 1] != '-' && digitExisited) eExisted = true;
          else return false;
      } else if (s[i] == '+' || s[i] == '-') { // +/- can only follow e/E
          if (s[i - 1] != 'e' && s[i - 1] != 'E') return false;
      } else if (s[i] == '.') { // dot can only occur once and cannot occur after e/E
          if (!dotExisted && !eExisted) dotExisted = true;
          else return false;
      } else return false;
  }
  // Process the last char, it can only be digit or dot, when is dot, there should be no dot and e/E before and must follow a digit
  if (s[right] >= '0' && s[right] <= '9') return true;
  else if (s[right] == '.' && !dotExisted && !eExisted && digitExisited) return true;
  else return false;
};
//这一题就是各种情况要考虑清楚，是一大堆if else所组成的逻辑~
