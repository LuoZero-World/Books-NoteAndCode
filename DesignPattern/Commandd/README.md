Command模式 举例解说模式中的登场角色:
顾客点菜，将菜单交给服务员，服务员再将菜单交给厨师，厨师做饭
顾客——Client，负责发起命令，即【生成Command，指定Reciver】
菜单——Command，包含Reciver对象
服务员——Invoker，开始执行命令，即调用Command的API(cmd.execute())
厨师——Reciver，真正完成Command的对象

目的：
实现Reciver和Invoker的解耦，如何做到？
Invoker ——> Reciver  =====>  Invoker  —(Command)—> Reciver