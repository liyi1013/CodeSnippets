package TestJava.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 测试string
 * 1、测试split分割
 * 2、testSubString
 */
public class testString {

    /**
     * 1、测试split分割
     */
    static void testSplit() {
        String file = "-rw-r--r-- 1 liyi 1000    142599  5月 13  2022 chrome_100_percent.pak\n";

        String[] fs = file.split(" ");
        System.out.println(Arrays.asList(fs));

//        Arrays.stream(fs).forEach(
//                f -> System.out.println(f)
//        );

        String[] fs2 = file.split("\\s+");
        System.out.println(Arrays.asList(fs2));

    }

    /**
     * 2、testSubString
     */
    private static void testSubString() {
        String s = "pwd: /home/sysop/path1";
        String s2 = "pwd: ";
        String s3 = "pwd:";
        System.out.println(s.substring(5));
        String p = "pwd: ";
        System.out.println(s.substring(p.length()));
        System.out.println(s2.substring(p.length()));
        System.out.println(s3.substring(p.length()));
    }

    public static void main(String[] args) {

        testSplit();
        testSubString();

        List<String> res = new ArrayList<>();
        res.add("123\n345\nd");
        Optional<String> optionalS = res.stream().findFirst();
        List<String> stringList = Arrays.asList(optionalS.orElse("").split("\n"));
        System.out.println(stringList);
    }
}
