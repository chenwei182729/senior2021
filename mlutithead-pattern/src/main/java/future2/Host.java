package future2;


import java.util.concurrent.TimeUnit;

/**
 * @author chenxinwei
 * @date 2021/1/28 18:41
 **/
public class Host {
    public Data request(int count, char c) {
        System.out.println("\t request(" + count + ", " + c + ") Begin");
        FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                futureData.setRealData(new RealData(count, c));
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("\t request(" + count + ", " + c + ") End");
        return futureData;
    }
}
