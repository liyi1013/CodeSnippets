package TestJava.basic;

import java.util.Optional;

/**
 * @ClassName optionalTest
 * @Description 测试optinal
 * @Author liyi
 * @Date 2023/8/1 上午10:08
 */
public class optionalTest {

    private static void testB() {
        B b = new B();
        System.out.println(b);
        // 以下，如果b.getName()不为null,返回b.getName()，否则返回bbb
        System.out.println(Optional.ofNullable(b.getName()).orElse("bbb"));

        b.setName("123");
        System.out.println(Optional.ofNullable(b.getName()).orElse("bbb"));
    }

    public static void main(String[] args) {
        testB();
        obj2string(null);
        obj2string(null);
        obj2string("111");
    }

    private static void obj2string(String createAt) {
        Object cc = createAt;
//        System.out.println(cc.toString());
        Object c = Optional.ofNullable(cc).orElse("");
        System.out.println(c.toString());
        System.out.println("".toString());
    }

}


class B {
    String name;
    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}