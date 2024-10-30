### 未列出的设计模式 使用条件

**Facade模式：** 目的在于将关联在一起的错综复杂的类，整理出高层接口。而Facade角色持有这个接口；当我们意识到【在调用某个方法之前先调用这个类注册】等时候时，就该引入Facade角色了

**Proxy模式：** 目的在于通过设置代理人来减轻本人的工作负担。
Proxy角色具有“透明性”：代理角色和实际角色的接口是相同的，我们既可以直接使用代理角色，也可以直接使用实际角色。
通过Proxy模式，我们可以很条理地实现**惰性求值**功能

**State模式：** 用类表示状态，类中实现该状态下的各种操作，以及**状态的迁移**
故而可以将**依赖于状态的操作**分散在各个ConcreteState角色中，分而治之

**Flyweight模式：**目的在于减少内存使用，通过尽量共享实例来避免new出实例