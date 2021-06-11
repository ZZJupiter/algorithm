# "马拉车"算法笔记

## 概念

1) 原始串中插入"#",不改变原始串的回文结构,并且不论原始串长度是奇数还是偶数,插入"#"后,处理串的长度都是奇数.例如:原始串aba,处理串:#a#b#a#

2) 回文直径,回文半径,例如字符串 "abak" 第一个"a"位置的回文直径是1,回文半径是1,"b"位置的回文直径是3,回文半径是2

3) 回文半径数组,每个字符都记录自己的回文半径,例如字符串"abak"的回文半径数组为[1,2,1,1]

4) 最大回文右边界,以字符串i位置为中心时,i位置+回文半径-1能达到的最大值(即对i位置及i位置以前的位置做回文判断时,能达到的最大右侧下标)

## 暴力解

对字符串每一个位置,定义为i位置,向左右两侧延伸,判断是否是回文,如果是回文,记录此时的最大值

## "马拉车"解法

相暴力解中对每个i位置的字符做回文检测,manacher检测过程中可以根据之前已经记录的回文半径数组直接跳过i位置的检测.

### 场景

L,...i',...,c,...,i,...,R 以c为中心时,最大回文右边界为R,如果待检查的i位置在c与R之间,则必然存在i'已c为中心与i位置对应.

1) 检查i'位置的回文半径,如果i'位置的回文半径向左不超过L位置,则i位置的回文半径向右必定不超过R位置,以i位置为中心的回文串长度必定不会超过以c为中心的回文串长度,跳过i位置,检查下一个位置(i+1)

2) 检查i'位置的回文半径,如果i'位置的回文半径向左超过了L位置,则i位置的回文半径向右必定超过了R位置,便无法确定以i位置为中心的回文半径,此时只能从R+1位置开始逐个尝试,直到发现不在构成回文最右位置X,此时更新c为i,更新R为X-1,检查下一个位置(i+1)
