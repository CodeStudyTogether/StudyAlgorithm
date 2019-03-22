func mySqrt(x int) int {
    return int(math.Sqrt(float64(x)))
}

//在有序数组中，找到最后一个小于等于给定值的数
func mySqrt2(x int) int {
    low, high := 0, x
    for low <= high {
        //防止大数相加溢出
        //位运算更高效
        mid := low + (high-low)>>1
        product := mid * mid
        if product > x {
            high = mid - 1
        } else {
            if (mid == x) || (mid+1)*(mid+1) > x {
                //遍历最后一个数 || 下一个数大于目标值
                return mid
            }
            //下一个数小于等于目标值，所以mid不是最后一个数
            low = mid + 1
        }
    }
    return -1
}
