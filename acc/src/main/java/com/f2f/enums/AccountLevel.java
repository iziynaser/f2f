package com.f2f.enums;

public enum AccountLevel {

    GROUP(1),
    MAIN(2),
    SUB(3),
    DETAIL(4),
    EXTRA_LEVEL(5),
    ADVANCED_DETAIL(6);

    private final int order;

    AccountLevel(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

}
