工厂方法：
1、主要目的是为了解耦对象使用者与具体类型之间的紧耦合关系
2、使一个类的实例化延迟到其子类
3、符合开闭原则和依赖导致原则
4、缺点：客户可能仅仅为了创建一个特定的ConcreateProduct对象，就不得不创建Creator子类的

product
concreteproduct
creator
concretecreator

实例： 读写数据： a.通过数据库读写  b 通过文件读写