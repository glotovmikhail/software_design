package LRUCache;

/**
 * Created by mikhail on 25.10.18.
 */
public class Node<K, V> {
    K key;
    V val;
    Node<K, V> next;
    Node<K, V> prev;

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}
