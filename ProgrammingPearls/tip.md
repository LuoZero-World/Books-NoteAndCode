### 各章的“珠玑”
> 各章问题的答案见各章对于的文件夹内

**Chapter 1 Introduction**
&emsp;**明确问题，正确的理解问题答案便会呼之欲出。**
- 如何使用位逻辑运算来实现**位图**？

- 如何生成位于0至n-1之间的k个不同的随机顺序的随机整数？

- 设计一种技术，在第一次访问向量的项时将其初始化，从而避免了创建向量后的初始化工作

**Chapter 2 Aha! Algorithm**
&emsp;**“灵机一动”的启发：排序、二分搜索、标识、翻转等。**
- 给定一个最多包含40亿个**随机排列**的32位整数的顺序文件，找出一个不在文件中的32位整数。

- 如何将一个n元的一维向量向左旋转i个位置(即循环位移)，能否在**常数的空间**和**正比于n的时间**内完成？

**Chapter 3 Data Structures Programs**
&emsp;**通过使用恰当的数据结构来代替复杂的代码，数据的表示形式是程序设计的根本**
- 编写处理日期问题的函数：
    1. 给定两个日期，计算两者之间的天数
    2. 给定一个日期，返回值为周几
    3. 给定月和年，生成该月的日历

- 编写一个 **“格式信函发生器”**，使之可通过数据库中每条记录来生成定制的文档 

**Chapter 4 Write the right program**
&emsp;**断言在程序维护的过程中至关重要**
- **咖啡罐问题**。给定一个盛有一些黑色豆子和一些白色豆子的咖啡罐以及一大推额外的黑色豆子，从罐中**随机选两颗豆子**并重复如下流程，直到罐中**只剩一颗豆子**：
    1. 若为同色豆子，则都弃之并放入一颗黑色豆子；
    2. 若不同色，则将白色豆子放回罐中，丢弃黑色豆子。
证明该过程会终止。最后留在罐中的豆子颜色和最初罐中白豆黑豆的数量有何关系？

- **搜索一个包含1000个整数的有序表**。我们需要让二分搜索变得更快,虽然我们无法减少由算法决定的对数级比较次数。
    