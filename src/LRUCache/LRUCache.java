package LRUCache;

/**
 * Created by mikhail on 25.10.18.
 */
public class LRUCache<K,V> extends AbstractLRUCache<K,V> {
    public LRUCache(int size) {
        super(size);
    }

    @Override
    protected V getVal(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) return null;
        if (node.prev == null)  {
            return node.val;
        }
        if (node.next == null) {
            this.tail = node.prev;
            this.tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
        return node.val;
    }

    @Override
    protected int putVal(K key, V val) {
        Node<K, V> value = new Node<K, V>(key, val);
        if (cache.containsKey(key)) {
            getVal(key);
            this.head.val = val;
            return 1;
        }
        if (size == maxSize) {
            cache.remove(this.tail.key);
            this.tail = this.tail.prev;
            this.tail.next = null;
            value.next = this.head;
            this.head.prev = value;
            this.head = value;
            cache.put(key, value);
            return 1;
        }
        if (this.head == null) {
            this.head = value;
            this.tail = value;
        } else {
            value.next = this.head;
            this.head.prev = value;
            this.head = value;
            if (this.tail.prev == null) {
                this.tail.prev = value;
            }
        }
        cache.put(key, value);
        size++;
        return 1;
    }
}
