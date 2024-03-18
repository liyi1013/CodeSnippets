package TestJava.basic;

import java.util.concurrent.*;

public class asyncTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        asyncTest x = new asyncTest();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        asyncTest.UserInfoService userInfoService = x.new UserInfoService();
        asyncTest.MedalService medalService = x.new MedalService();
        long userId = 666L;
        long startTime = System.currentTimeMillis();

        // 调用用户服务获取用户基本信息
        FutureTask<UserInfo> userInfoFutureTask = new FutureTask<>(new Callable<UserInfo>() {
            @Override
            public UserInfo call() throws Exception {
                return userInfoService.getUserInfo(userId);
            }
        });
        executorService.submit(userInfoFutureTask);

        Thread.sleep(300); // 模拟主线程其它操作耗时

        FutureTask<MedalInfo> medalInfoFutureTask = new FutureTask<>(new Callable<MedalInfo>() {
            @Override
            public MedalInfo call() throws Exception {
                return medalService.getMedalInfo(userId);
            }
        });
        executorService.submit(medalInfoFutureTask);

        UserInfo userInfo = userInfoFutureTask.get();// 获取个人信息结果
        MedalInfo medalInfo = medalInfoFutureTask.get();// 获取勋章信息结果

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");

    }

    class UserInfo {
        String name;
        String des;
        int age;

        UserInfo(String name, String des, int age) {
            this.age = age;
            this.des = des;
            this.name = name;
        }
    }

    class MedalInfo {
        String name;
        String des;

        MedalInfo(String name, String des) {
            this.name = name;
            this.des = des;
        }
    }

    class UserInfoService {

        public UserInfo getUserInfo(Long userId) throws InterruptedException {
            Thread.sleep(300);// 模拟调用耗时
            return new UserInfo("666", "捡田螺的小男孩", 27); // 一般是查数据库，或者远程调用返回的
        }
    }

    class MedalService {

        public MedalInfo getMedalInfo(long userId) throws InterruptedException {
            Thread.sleep(500); // 模拟调用耗时
            return new MedalInfo("666", "守护勋章");
        }
    }
}
