package TestJava.basic;

public class ReferencesAndScopes {
    public static A f3(int b) {
        A a = new A(b);
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        {
            A a3 = f3(3);
            System.out.println(a3);
        }
        System.gc();
    }
}

class A {
    int foo = 0;

    A(int a) {
        this.foo = a;
        System.out.println(String.format("构造A(foo=%s)", this.foo));

    }

    public void finalize() {
        System.out.println("析构A");
    }
}
