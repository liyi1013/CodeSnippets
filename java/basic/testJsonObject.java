package TestJava.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class testJsonObject {


    static void test1() {
        JSONObject job = new JSONObject();
        job.put("flag", 0);

        System.out.println(job.getInteger("flag"));
        System.out.println(job.getInteger("unknown"));
        if (Integer.valueOf(0).equals(job.getInteger("flag"))) {
            System.out.println("00000");
        }
        if (Integer.valueOf(0).equals(job.getInteger("unknown"))) {
            System.out.println("unknown");
        }
    }

    /**
     * 测试直接从jsonString中取不存在的对象，看返回是什么
     */
    static void test2() {
//        List<String> s=null;
//        System.out.println("s.size: "+s.size());

        String js = "{\"name\":\"a\"}";
        List<String> ll = JSON.parseObject(js).getJSONArray("list").toJavaList(String.class);
        System.out.println(ll.toString());
    }


    public static void main(String[] args) {
//        test1();
        test2();
    }
}
