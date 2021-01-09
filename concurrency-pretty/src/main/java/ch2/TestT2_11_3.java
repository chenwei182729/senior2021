package ch2;

public class TestT2_11_3 {

    public static void main(String[] args) {
        final TestT2_11_3 testT2_11_3 = new TestT2_11_3();
        System.out.println(testT2_11_3.threadLocalRandomSeed);
    }

    @sun.misc.Contended
    public final static class FilledLong {
        public volatile long value = 0L;
    }

    @sun.misc.Contended("tlr")
    long threadLocalRandomSeed;

    /**
     * Probe hash value ; nonzero if threadLocalRandomSeed initialized
     */
    @sun.misc.Contended("tlr")
    int threadLocalRandomProbe;
    /**
     * Secondary seed isolated from public ThreadLocalRandom sequece
     **/
    @sun.misc.Contended("tlr")
    int threadLocalRandomSecondarySeed;
}
