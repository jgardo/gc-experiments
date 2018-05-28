package com.jgardo.gc.presentation;

import java.util.logging.Logger;

public class GCRootsExample {
    public static final Logger LOGGER = Logger.getLogger("nana");

    private final Object object = new Object();

    public void someMethod(Object param) {
        int someInt = 0;
        Integer someInteger = new Integer(12);
        synchronized (object) {
            someInteger = someInt + someInteger;

//          here GC is performed
        }
//      (some other senslessCode...)
    }
}
