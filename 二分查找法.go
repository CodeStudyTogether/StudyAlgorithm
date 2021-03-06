在一个有序的列表中，要查找的数与列表中间的位置相比，若相等说明找到了，若要查找的数大于列表中间的数，说明要查找的数可能在有序列表的后半部分；若要查找的数小于列表中间的数，说明要查找的数可能在有序列表的前半部分；然后类似上述操作缩短查找范围，最后直到查找到最后一个数，如果不等于要查找的数，那么查找范围就为空。

最坏时间复杂度 O(log n)

最优时间复杂度 O(1)

平均时间复杂度 O(log n)
