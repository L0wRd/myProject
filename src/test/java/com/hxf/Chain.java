package com.hxf;

import java.util.List;

/**
 * @author: hxf
 * @date: 2019/10/14 16:27
 * @description:
 */
public class Chain {

    private List<ChainHandler> handlers;

    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed() {
        if (index >= handlers.size()) return;
        handlers.get(index++).execute(this);
    }
}
