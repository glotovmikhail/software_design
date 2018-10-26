package LRUCache;

import java.util.HashMap;

/**
 * Created by mikhail on 25.10.18.
 */

public abstract class AbstractLRUCache<K, V> {
    Node<K, V> head;
    Node<K, V> tail;
    int size;
    int maxSize;
    HashMap<K, Node<K, V>> cache;

    protected AbstractLRUCache() {
        cache = new HashMap<>();
        size = 0;
        maxSize = 2000;
    }

    protected AbstractLRUCache(int maxSize) {
        cache = new HashMap<>();
        size = 0;
        this.maxSize = maxSize;
    }

    public V get(K key) {
        V value = getVal(key);
        if (value == null) {
            return null;
        }
        assert cache.get(key).val == value;
        Node<K, V> cur = head;
        while (cur != null) {
            assert cache.get(cur.key).val == cur.val;
            cur = cur.next;
        }

        return value;
    }

    public int put(K key, V val) {
        int ans = putVal(key, val);
        assert size <= maxSize && cache.get(key) != null && cache.get(key).val == val;
        Node<K, V> cur = head;
        while (cur != null) {
            assert cache.get(cur.key).val == cur.val;
            cur = cur.next;
        }

        return ans;
    }

    protected abstract V getVal(K key);
    protected abstract int putVal(K key, V val);
}
