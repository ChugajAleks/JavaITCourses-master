package com.igorrusso.learning.ibm.multithreading.introduction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Igor Russo
 * Date: 11.08.13
 * Time: 22:08
 * Description: synchronized(cache) makes all cache operations thread-safe
 */

public class SimpleCache {
    private final Map cache = new HashMap();

    public Object load(String objectName) {
        // some object is returned
        return new String[]{objectName};
    }

    public void clearCache() {
        synchronized (cache) {
            cache.clear();
        }
    }

    public Object getObject(String objectName) {
        Object o;
        synchronized (cache) {
            o = cache.get(objectName);
            if (o == null) {
                o = load(objectName);
                cache.put(objectName, o);
            }
        }

        return o;
    }


}
