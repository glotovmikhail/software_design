package LRUCache;

/**
 * Created by mikhail on 25.10.18.
 */
public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, Character> myCache = new LRUCache<Integer, Character>(5);
        for (int i = 0; i < myCache.maxSize + 1; i++) {
            myCache.put(i + 1, (char) (97 + i));
            System.out.print("Value: ");
            System.out.println(myCache.get(i + 1));
        }
        System.out.println("Current TAIL: " + myCache.get(myCache.tail.key));
        System.out.println("Add element with null key: " + myCache.put(null, 'x'));
        System.out.println("Current HEAD: " + myCache.get(myCache.head.key));
        System.out.println("Current TAIL: " + myCache.get(myCache.tail.key));
    }
}
