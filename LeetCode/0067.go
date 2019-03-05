func addBinary(a string, b string) string {
    iA := len(a) - 1
    iB := len(b) - 1
    sum := 0
    ret := make([]byte, max(len(a), len(b))+1)//new 的作用是 初始化 一个指向类型的指针 (*T)， make 的作用是为 slice, map 或者 channel 初始化，并且返回引用 T；新建一个数组长度是a和b最大值再多一位，用来确保可以存放结果
    idx := len(ret) - 1
    for iA >= 0 || iB >= 0 {
        if iA >= 0 {
            sum += int(a[iA] - '0')//char类型的加减法运算
        }
        
        if iB >= 0 {
            sum += int(b[iB] - '0')
        }
        
        ret[idx] = byte(sum & 1) + '0'
        sum = sum >> 1 //一位
        idx--
        iA--
        iB--
    }
    
    if sum > 0 {
        ret[0] = '1'
        return string(ret)
    }
    
    return string(ret[1:])
}

//返回a和b之间的最大值
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
