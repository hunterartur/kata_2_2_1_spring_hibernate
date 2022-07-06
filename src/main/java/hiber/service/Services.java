package hiber.service;

import java.util.List;

public interface Services<T, V> {
    void add(T obj);

    List<T> getAll();

    T getBy(V obj);
}
