package one.future2;

/**
 * @author chenxinwei
 * @date 2021/1/28 18:32
 **/
public class FutureData implements Data {
    private Data realData;
    private boolean ready = false;

    public synchronized void setRealData(Data realData) {
        if (ready) {
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        if (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }

}
