自下而上构建堆，只需要O(n)的时间
证明如下：
在完全二叉树中，高度为h的节点数量为 $\lceil n/2^{h+1}\rceil$,整个树的高度为$\lfloor log_2n\rfloor$
那么堆化总时间是**对所有非叶节点堆化时间的累加**：$$T(n)=\sum_{h=1}^{\lfloor\log_2(n)\rfloor}h\cdot\lceil\frac{n}{2^{h+1}}\rceil$$
即，$$T(n)\approx\frac{n}{2}\left(\sum_{h=1}^\infty\frac{h}{2^h}\right)$$
利用导数和无穷级数公式进行变化，易得和式值为2，故$T(n)=O(n)$