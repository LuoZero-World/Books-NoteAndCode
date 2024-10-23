Memento模式可以实现以下功能：
Undo、Redo、History、Snapshot

Memento角色提供了两种接口：
**wide interface**  指所有用于获取恢复对象状态信息的方法的集合，会暴露Memento角色的所有内部信息，因此只有Originator角色可以使用
**narrow interface**  对外部提供此接口，暴露的信息非常有限

划分Caretaker角色和Originator角色的意义在于：职责分担
Caretaker角色决定何时拍摄快照，何时撤销，何时保存Memento角色
Originator角色负责生成Memento角色，以及使用Memento角色恢复状态
因此我们面对大部分需求变更时，只需要关注Caretaker角色