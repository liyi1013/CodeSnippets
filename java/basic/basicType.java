package TestJava.basic;

public class basicType {
    Double dw;
    double d;

    public static void main(String[] args) {
        basicType t = new basicType();
        // t.TestWapper();
        t.TestString();
    }

    /**
     * 基本类型和他们的包装类
     */
    public void TestWapper() {
        //https://blog.csdn.net/u011480603/article/details/75364931
        //
        // 包装类型出现的原因
        // Java是一个面向对象的语言，基本类型并不具有对象的性质，
        // 为了与其他对象“接轨”就出现了包装类型（如我们在使用集合类型Collection时就一定要使用包装类型而非基本类型），
        // 它相当于将基本类型“包装起来”，使得它具有了对象的性质，并且为其添加了属性和方法，丰富了基本类型的操作

        // 基本类型的优势：数据存储相对简单，运算效率比较高
        // 包装类的优势：有的容易，比如集合的元素必须是对象类型，满足了java一切皆是对象的思想
        // 声明方式不同，基本类型不适用new关键字，而包装类型需要使用new关键字来在堆中分配存储空间；
        // 存储方式及位置不同，基本类型是直接将变量值存储在堆栈中，而包装类型是将对象放在堆中，然后通过引用来使用；
        // 初始值不同，基本类型的初始值如int为0，boolean为false，而包装类型的初始值为null
        // 使用方式不同，基本类型直接赋值直接使用就好，而包装类型在集合如Collection、Map时会使用到

        // 自动装箱，拆箱
        // Integer x = 2;     // 装箱
        // int y = x;         // 拆箱

        // 基本类型的包装类型，为了让基本类型作为对象被使用
        // 8种基本类型
        boolean b = Boolean.valueOf(false);
        byte bb = Byte.valueOf((byte) 1);
        char c = Character.valueOf('c');
        short s = Short.valueOf("1");
        int x = Integer.valueOf(1);
        long l = Long.MAX_VALUE;
        float f = Float.valueOf("1.1");
        double dd = Double.valueOf("1.1");

        System.out.println(dw);   // 默认初始化为null
        System.out.println(d);    // 默认初始化为0.0
    }

    public void TestString() {
        // String 被声明为 final，因此它不可被继承。
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);   // StringBuilder@6
        sb.append("123");     // StringBuilder@6
        System.out.println(sb);   // StringBuilder@6
        String s = sb.toString();
        String ss = "123";
        // StringBuilder 其内容可变
    }
}
