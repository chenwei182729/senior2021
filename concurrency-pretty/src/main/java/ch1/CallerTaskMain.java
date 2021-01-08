package ch1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chenxinwei
 * @date 2021/1/8 13:40
 **/
public class CallerTaskMain {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();

        try {
            //等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello";
    }
}
