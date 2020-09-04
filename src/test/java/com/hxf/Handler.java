package com.hxf;

/**
 * @author: hxf
 * @date: 2019/10/14 16:11
 * @description:
 */
public abstract class Handler {

    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    protected abstract void requestProcess();

    public void execute() {
        requestProcess();
        if (sucessor != null) {
            sucessor.execute();
        }
    }
}
