func plusOne(digits []int) []int {
    if len(digits)==0 {
        return digits
    }
    
    for i := len(digits) -1; i>=0; i-- {
         if digits[i] < 9 {
             digits[i]++ //如果是1,2,3这种，直接返回
             return digits
         }
         digits[i] = 0
    }
 
    length := len(digits)+1
    res := make([]int, length)
    
    res[0] = 1
    return res
}
