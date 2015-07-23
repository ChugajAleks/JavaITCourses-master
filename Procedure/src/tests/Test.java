package tests;

/**
 * User: Igor Russo
 * Date: 29.01.13
 * Time: 0:05
 */
public class Test {
    public static void main(String[] args) {
        Parent child = new Child();
        Receiver advancedReceiver = new AdvancedReceiver();
        advancedReceiver.receive(child);

        B b = new B();
        A a = b;
        a.f1();
        a.f2();
        ((B) a).f3();
        ///  a.f3();
    }
}

class A {
    public void f1() {

    }

    public void f2() {

    }
}

class B extends A {
    public void f3() {

    }

    public void f2() {

    }
}

class Parent {
    public void outMe() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    public void outMe() {
        System.out.println("Child");
    }
}

class Receiver {
    public void receive(Parent p) {
        System.out.println("Receiver");
        p.outMe();
    }
}

class AdvancedReceiver extends Receiver {
    public void receive(Child c) {
        System.out.println("AdvancedReceiver");
        c.outMe();
    }
}
