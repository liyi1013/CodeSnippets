package TestJava.basic;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * [1]查询list中元素是否满足任意条件
 * [2]测试stream转string
 * [3]测试 intStream（string list转int）
 * [4]list 中obj有id重复，自定义属性去重
 * [5] FindFirst
 */
public class streamTest {


    /**
     * [1]查询list中元素是否满足任意条件
     */
    private static void testStreamAnyMatchPattern() {
        List<String> patternList = new ArrayList<>();
        patternList.add("122.*");
        patternList.add("127.*");
        patternList.add("0.0.0.0");

        List<String> ips = new ArrayList<>(Arrays.asList("122.1.1.1", "87.1.1.1", "127.1.1.1"));
        ips.add("0.0.0.0");

        ips.forEach(
                ip -> {
                    if (patternList.stream().anyMatch(
                            item -> Pattern.compile(item).matcher(ip).matches()
                    )) {
                        System.out.println("match " + ip);
                    }
                }
        );
    }

    /**
     * [2]测试stream转string
     */
    private static void testListToString() {
        List<String> containerList = new ArrayList<>(Arrays.asList("container1", "container2", "container3"));

        String s = String.format("list: [%s]", containerList);
        String s2 = String.format("list: %s", containerList);
        String s3 = String.format("list: [\"%s\"]", String.join("\",\"", containerList));
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
    }

    /**
     * [3]测试 intStream（string list转int）
     */
    private static void testList2int() {
        List<String> containerList = new ArrayList<>(Arrays.asList("1", "1", "1"));

        int sum = 0;
        sum += containerList.stream().mapToInt(
                value -> Integer.valueOf(value)
        ).sum();
        System.out.println(sum);


    }

    /**
     * [5] FindFirst
     */
    static void testFindFirst() {
        List<String> res = new ArrayList<>();
        res.add("123\n345\nd");
        Optional<String> optionalS = res.stream().findFirst();
        List<String> stringList = Arrays.asList(optionalS.orElse("").split("\n"));
        System.out.println(stringList);
    }

    public static void main(String[] args) {

//        testStreamAnyMatchPattern();
        testListToString();
        testList2int();

        new streamTest().testGrouped();

        System.out.println("## [5] testFindFirst() ##");
        testFindFirst();

    }

    /**
     * [4]list 中obj有id重复，自定义属性去重
     */
    private void testGrouped() {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge("a", "12"));
        edgeList.add(new Edge("a", "23"));
        edgeList.add(new Edge("b", "34"));
        edgeList.add(new Edge("c", "54"));
        edgeList.add(new Edge("c", "22"));

        System.out.println(edgeList);

        List<Edge> edgeListFiltered = new ArrayList<>();

        Map<String, List<Edge>> grouped = edgeList.stream().collect(Collectors.groupingBy(Edge::getName));
        grouped.forEach(
                (k, v) -> {
                    if (v.size() == 1) {
                        edgeListFiltered.add(v.get(0));
                    } else if (v.size() > 1) {
                        Optional<Edge> max = v.stream().max(Comparator.comparing(Edge::getAge));
                        if (max.isPresent()) {
                            edgeListFiltered.add(max.get());
                        }
                    }
                }
        );
        System.out.println(edgeListFiltered);
    }

    /**
     * 辅助测试类
     */
    class Edge {
        public String name;
        public String age;
        public Edge(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
