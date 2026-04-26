public class MyHashTable<K, V> {
    private class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];

        HashNode<K,V> current = head;
        while(current != null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }

        size++;
        HashNode<K,V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K,V> current = chainArray[index];

        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];
        HashNode<K,V> prev = null;

        while (head != null) {
            if (head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;
        if (prev != null) {
            prev.next = head.next;
        }
        else {
            chainArray[index] = head.next;
        }
        return head.value;
    }

    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K,V> current = chainArray[i];
            while (current != null){
                if (current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getkey(V value){
        for (int i = 0; i < M; i++){
            HashNode<K,V> current = chainArray[i];
            while (current != null){
                if (current.value.equals(value)){
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    public int getBucketSize(int index){
        int count = 0;
        HashNode<K,V> current = chainArray[index];
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public int getM(){
        return M;
    }
}
