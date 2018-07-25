package duotai;

/**
 * Created by menghan on 2018/6/3.
 */
public class A {
    public void show(A obj){
        System.out.println("A and A");
    }

    public void show(D obj){
        System.out.println("A and D");
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        a2.show(b);
    }
}
class B extends A{
    public void show(B obj){
        System.out.println("B and B");
    }

    public void show(A obj){
        System.out.println("B and A");
    }
}
class C extends B{

}
class D extends B{

}
