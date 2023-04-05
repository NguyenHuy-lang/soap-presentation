package io.spring.guides.gs_producing_web_service.repository;

import java.util.Objects;

public class MyKey {
    private final String a;
    private final String b;

    public MyKey(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return Objects.equals(a, myKey.a) && Objects.equals(b, myKey.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}