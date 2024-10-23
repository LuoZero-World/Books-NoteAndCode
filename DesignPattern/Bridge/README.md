类的功能层次结构：父类具有基本功能 子类新增新功能
类的实现层次结构：父类定义接口 子类实现接口

func_hierarchy 属于功能层次
impl_hierarchy 属于实现层次，使用了Template Method，也可以使用Abstract Factory

一言以蔽之，Bridge模式是将抽象与实现相分离，关键在于Display.java中的impl字段
(更可以组合各种各样的impl字段在Display中)