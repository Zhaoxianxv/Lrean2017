package com.zxx.final_tag;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ENcore on 2016/3/9.
 */
public class ReqGenerate {

    private static AtomicInteger pageCount = new AtomicInteger(0);

    public static String genPageTag(String name) {
        String pageTag = name + pageCount.incrementAndGet();
        return pageTag;
    }
}
