import java.util.Iterator;
import java.util.Stack;

public class MyBST<K extends Comparable<K>,V> implements Iterable<MyBST.Node<K,V>>{
    private Node<K,V> root;
    private int size = 0;

    public static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){ return key;}
        public V getValue(){ return value;}
    }

    public int size(){ return size;}

    public void put(K key, V value){
        if (root == null){
            root = new Node<>(key, value);
            size++;
            return;
        }

        Node<K,V> current = root;
        Node<K,V> parrent = null;

        while (current != null){
            parrent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                current = current.left;
            }else if (cmp > 0){
                current = current.right;
            }else{
                current.value = value;
                return;
            }
        }

        Node<K,V> newNode = new Node<>(key,value);
        if (key.compareTo(parrent.key) < 0){
            parrent.left = newNode;
        }
        else{
            parrent.right = newNode;
        }
        size++;
    }

    public V get(K key){
        Node<K,V> current = root;
        while (current != null){
            int cmp = key.compareTo(current.key);
            if (cmp < 0){current = current.left;}
            else if (cmp > 0){current = current.right;}
            else{return current.value;}
        }
        return null;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private Stack<Node<K, V>> stack = new Stack<>();
            private Node<K, V> current = root;

            // Внутренний вспомогательный метод: идем до упора влево
            private void pushLeft(Node<K, V> node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            // Блок инициализации: перед началом итерации загружаем левую ветку
            {
                pushLeft(root);
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Node<K, V> next() {
                Node<K, V> node = stack.pop(); // Берем самый левый узел
                if (node.right != null) {
                    pushLeft(node.right); // Если есть правая ветка, идем туда и снова влево
                }
                return node;
            }
        };
    }
}
