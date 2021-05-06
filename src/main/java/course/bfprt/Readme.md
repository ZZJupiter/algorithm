# bfprt算法

## 算法过程
1) 我们将BFPRT算法看成一个函数bfprt(int[] arr,int k)，返回值是第k大或是第k小的值。

2) 将数组按照5个为一组进行分组，最后剩下的不足5个的为一组，此项操作时间复杂度是O(n)；

3) 将每组的5个数进行排序，因为每组只有5个数进行排序，一个组排序的时间复杂度是O(1),这个操作的时间复杂度是O(n);

4) 将每组的中位数取出来构成一个新的数组newArr，这个数组的长度大约是n/5，所以这个操作的时间复杂度是O(n);

5) 求出新数组的中位数，即递归调用bfprt(newArr,newArr.length/2)，假设原来的问题时间复杂度是T(n)，则这个操作的时间是T(n/5);

6) 使用步骤4求出的中位数进行partition，这一步骤最少可以排除掉arr的3/10，在对剩下的进行bfprt，这个操作的时间是T(7n/10);

整个过程的时间复杂度是T(n) = T(n/5) + T(7n/10) + O(n) = O(n)