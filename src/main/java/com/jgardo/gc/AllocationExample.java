package com.jgardo.gc;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;

public class AllocationExample {
    // launch with VM params: -Xmx1024m -Xms1024m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -Xloggc:gc.log
    public static void main(String[] args) throws InterruptedException {
        // fetching some data
        System.out.println("4 seconds to launch visualVm");
        System.gc();
        Thread.sleep(4000);

        createTabWaitAndLaunchGC(toMiB(1));
        createTabWaitAndLaunchGC(toMiB(10));
        createTabWaitAndLaunchGC(toMiB(100));
        createTabWaitAndLaunchGC(toMiB(200));
        createTabWaitAndLaunchGC(toMiB(250));
        createTabWaitAndLaunchGC(toMiB(270));   // 1
        createTabWaitAndLaunchGC(toMiB(272));   // 2
        createTabWaitAndLaunchGC(toMiB(300));   // 3
        createTabWaitAndLaunchGC(toMiB(400));   // 4
        createTabWaitAndLaunchGC(toMiB(500));   // 5
        createTabWaitAndLaunchGC(toMiB(600));   // 6
        createTabWaitAndLaunchGC(toMiB(700));   // 7
        createTabWaitAndLaunchGC(toMiB(800));   // 8
        createTabWaitAndLaunchGC(toMiB(900));   // 9
        createTabWaitAndLaunchGC(toMiB(1000));  // 10

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
