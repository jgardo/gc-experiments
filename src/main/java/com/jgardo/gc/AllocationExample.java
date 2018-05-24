package com.jgardo.gc;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;

public class AllocationExample {
    // launch with VM params: -Xmx1024m -Xms1024m -XX:+UseSerialGC
    public static void main(String[] args) throws InterruptedException {
        // fetching some data
        System.out.println("4 seconds to launch visualVm");
        System.gc();
        Thread.sleep(4000);

        createTabWaitAndLaunchGC(toMiB(1));     // 1MiB
        createTabWaitAndLaunchGC(toMiB(10));
        for (int i = 1; i <= 10; i++) {
            createTabWaitAndLaunchGC(toMiB(100 * i));
        }
    }

    // what's KiB - https://pl.wikipedia.org/wiki/Kilobajt

    private static void createTabWaitAndLaunchGC(int size) throws InterruptedException {
        System.out.println("Creating tab with size "+ size);
        createWhatever(size);

        System.out.println("Sleep 2s");
        Thread.sleep(2000);
        System.out.println("GC and sleep 1s");
        System.gc();
        Thread.sleep(1000);

    }

    private static void createWhatever(int size) {
        byte[] tab = new byte[size];
//        boolean[] tab = new boolean[size];
//        new BitSet(size);

//        long[] tab = new long[size];
//        Object[] tab = new Object[size];
//        new ArrayList(size);
//        new HashMap(size);
//        new LinkedList(size);
//        new LinkedList(size);
    }

    private static int toMiB(double count) {
        return (int) (count * 1024 * 1024);
    }
}
