package two.future;

/**
 * @author chenxinwei
 * @date 2021/2/22 18:36
 **/
public class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    @Override
    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.getContent();
    }

    public synchronized void setRealData(RealData readdata) {
        if (ready) {
            return;
        }
        this.realData = readdata;
        this.ready = true;
        notifyAll();
    }
}
