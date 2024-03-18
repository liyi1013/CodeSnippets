package TestJava.basic;

public class testException {

    static int mapper(int d) {
        return 1 / d;
    }

    static int dao(int d) {
        return mapper(d);
    }

    /**
     * 测试错误传递
     */
    static void test() {
        System.out.println("dao 1: " + dao(1));
        System.out.println("dao 2: " + dao(2));
        try {
            System.out.println("dao 0: " + dao(0));
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("end");

    }

    public static void main(String[] args) {
        test();
    }

}
