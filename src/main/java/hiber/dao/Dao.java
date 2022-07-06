package hiber.dao;

import java.util.List;

public interface Dao<T, V> {
   void add(T obj);
   List<T> getAll();
   T getBy(V obj);
}
