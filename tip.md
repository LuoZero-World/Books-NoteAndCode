### 记录在阅读过程中有用的一些点
**Item 3: Enforce the singleton property with a private constructor or an enum type**
&emsp;实现单例模式时有两点须注意:
- 防止`AccessibleObject.setAccessible`方法利用反射调用私有构造函数。解决方法：修改构造函数，使其在请求创建第二个实例时抛出异常，从而避免被"爆破"。
- 若单例类需要序列化，应防止反序列化时不会创建新的实例。解决方法：声明所有实例字段为`transient`，并提供`readResolve`方法。
    ```java
    private Object readResolve() {
        return INSTANCE;
    }
    ```
**Item 7: Eliminate obsolete object references**
&emsp;常见的内存泄漏源有三种：
- **一个类管理它自己的内存时**，程序员应该警惕内存泄漏。当释放一个元素时，该元素中包含的任何对象引用都应该被置为`null`
- 另一个常见的内存泄漏源是**缓存**，将对象引用放入缓存中后，就有可能忘掉它在那里。解决方法是将缓存对象做为键存入`WeakHashMap`中
- **第三个常见来源是侦听器和其他回调**

&emsp;书中提到弱引用`WeakReference<T>`：当一个对象只被弱引用关联时，下一次垃圾回收就可能被回收掉，即使内存并不紧张。而`WeakHashMap`的键是弱引用，值是强引用。当键可以被回收时，值也会一并被回收。

