package com.jgardo.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TenuringThresholdExample {
    private static final Random RANDOM = new Random();

    private static final List<byte[]> TAB = new LinkedList<>();
//    private static final List<SoftReference<byte[]>> TAB = new LinkedList<>();
//    private static final List<WeakReference<byte[]>> TAB = new LinkedList<>();

    // launch with VM params: -Xmx1024m -Xms1024m -XX:+UseSerialGC
    public static void main(String[] args) throws InterruptedException {
        // fetching some data
        System.out.println("4 seconds to launch visualVm");
        System.gc();
        Thread.sleep(4000);

        int a = 0;
        while (true) {
            for (int i = 0; i< 1000000; i++) {
                createGarbage();
            }
            TAB.add((createWhatever(toMiB(RANDOM.nextInt(10)))));
//            TAB.add(new SoftReference<byte[]>(createWhatever(toMiB(RANDOM.nextInt(10)))));
//            TAB.add(new WeakReference<byte[]>(createWhatever(toMiB(RANDOM.nextInt(10)))));
            System.out.println("Iteration " + a++);

        }
    }

    private static void createGarbage() {
        new BigDecimal("10000000000000000000000000");
    }

    private static byte[] createWhatever(int size) {
        return new byte[size];
    }

    private static int toMiB(double count) {
        return (int) (count * 1024 * 1024);
    }
}
