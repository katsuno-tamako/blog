package com.neko.neko.config;

import org.springframework.stereotype.Component;

@Component
public class PageBean {

    private int head;
    private int foot;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getFoot() {
        return foot;
    }

    public void setFoot(int foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "head=" + head +
                ", foot=" + foot +
                '}';
    }
}
