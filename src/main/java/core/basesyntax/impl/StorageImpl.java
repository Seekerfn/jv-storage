package core.basesyntax.impl;

import java.util.Objects;

import core.basesyntax.Storage;


public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;

    private int size;

    private Box<K, V>[] items;

    public StorageImpl() {
        items = new Box[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i].getKey(), key)) {
                items[i].setValues(value);
                return;
            }
        }       

        items[size++] = new Box<>(key, value);

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i].getKey(), key)) {
                return items[i].getValue();
            }
        }       
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
