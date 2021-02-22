package one.future;

/**
 * @author chenxinwei
 * @date 2021/1/28 18:12
 **/
public class Host {

    public Data request(final int count, final char c) {
        System.out.println("\t request(" + count + ", " + c + ") Begin");

        final FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                futureData.setRealData(realData);
            }
        }.start();

        System.out.println("\t request(" + count + ", " + c + ") END");
        return futureData;
    }
}
