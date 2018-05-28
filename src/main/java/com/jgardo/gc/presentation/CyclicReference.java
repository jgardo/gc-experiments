package com.jgardo.gc.presentation;

public class CyclicReference {

    private static class A {
        B b;
    }

    private static class B {
        A a;
    }

    public void someMethod() {
        A a = new A();
        B b = new B();
        a.b = b;
        b.a = a;

        a = null;
        b = null;
    }
}
