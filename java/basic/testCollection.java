package TestJava.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试集合
 * [1] maps的get
 */
public class testCollection {

    /**
     * [1] maps的get
     * 判断maps中是否有元素，可以直接用get,无的话返回null,有的话返回实际的value
     */
    static void testMapsGet() {
        System.out.println("[1] testMapsGet start");

        Map<String, String> maps1 = new HashMap<>();
        maps1.put("1", "1");
        maps1.put("2", "2");

        System.out.println("maps1: " + maps1);
        System.out.println("maps1.get(\"1\"): " + maps1.get("1"));
        System.out.println("maps1.get(\"3\"): " + maps1.get("3"));

        System.out.println("[1] testMapsGet end");
    }

    public static void main(String[] args) {

        testMapsGet();
    }
}
