### 记录在阅读过程中认为有用的一些小点
**Item 3: Enforce the singleton property with a private constructor or an enum type**
实现单例模式时有两点须注意:
- 防止`AccessibleObject.setAccessible`方法利用反射调用私有构造函数。解决方法：修改构造函数，使其在请求创建第二个实例时抛出异常，从而避免被"爆破"。
- 若单例类需要序列化，应防止反序列化时不会创建新的实例。解决方法：声明所有实例字段为`transient`，并提供`readResolve`方法
    ```java
    private Object readResolve() {
        return INSTANCE;
    }
    ```