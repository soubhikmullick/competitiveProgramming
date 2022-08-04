abstract class Test {
  static final int a = 10;
  int b = 100;
  Test(){

  }
}

interface I1 {
  int a = 11;
  int b = 101;
}

abstract class Test1 implements I1 {
  static final int c = 10;
}

public class AbstractVsInterface extends Test {
  public static void main(String[] args) {
    Test t = new AbstractVsInterface();
    System.out.println(a + " " + t.b);
    t.b = 200;
    System.out.println(t.b);
    HelloJoy2.func(t);
  }
}

class HelloJoy2 {
  public static void func(Test t){
    System.out.println(t.b);
  }
}
