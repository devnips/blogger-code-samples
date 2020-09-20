package com.blogspot.devnip.lombok.value;

/**
 * Immutable class using simple Java features
 */
public final class BasicImmutable {
    private final int id;
    private final String name;

    public BasicImmutable(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}