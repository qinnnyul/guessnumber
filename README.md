Questions:
1. 为什么要使用TDD?
   保证代码质量，确保程序的可测性，出错时，能通过测试很快的进行问题定位，减少调试时间。
   TDD也能增强开发的信心，特别是在重构前，单元测试是必要的保证。
2. TDD的步骤是什么 ？
   1.需求分析，写todo列表
   2.写测试案例
   3.解决编译错误，实现逻辑
   4.确保测试通过
   5.对代码不合理地方进行重构
   6.确保测试通过
   7.循环完成所有功能的开发
3. TDD的原则是什么 ？
   测试隔离。不同代码的测试应该相互隔离。对一块代码的测试只考虑此代码的测试
   测试驱动。完成某个功能，某个类，首先编写测试代码，考虑其如何使用、如何测试。然后在对其进行设计、编码。
   先写断言。测试代码编写时，应该首先编写对功能代码的判断用的断言语句，然后编写相应的辅助语句。
   可测试性。功能代码设计、开发时应该具有较强的可测试性。其实遵循比较好的设计原则的代码都具备较好的测试性。比如比较高的内聚性，尽量依赖于接口等。
   及时重构。无论是功能代码还是测试代码，对结构不合理，重复的代码等情况，在测试通过后，及时进行重构。
   小步前进。
4. 你觉得TDD最重要最困难的是什么 ？
   最重要的是需求分析，编写测试案例的同时，需要考虑其正确性，扩展性，易读性，易维护性，甚至重用性。最困难的也在于测试案例的设计。
