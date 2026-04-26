import java.util.Random;

void main() {
    MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
    Random random = new Random();

    for (int i = 0; i < 10000; i++) {
        String randomName = "Student" + i;

        MyTestingClass student = new MyTestingClass(i, randomName);

        hashTable.put(student, "Data For student " + i);
    }

    int M = hashTable.getM();
    int[] counts = new int[M];

    for (int i = 0; i < M; i++) {
        counts[i] = hashTable.getBucketSize(i);
    }

    System.out.println("Распределение элементов по бакетам:");
    for (int i = 0; i < counts.length; i++) {
        System.out.println("Бакет " + i + ": " + counts[i] + " элементов");
    }

    MyBST<Integer, String> tree = new MyBST<>();
    tree.put(5, "Five");
    tree.put(3, "Three");
    tree.put(8, "Eight");
    tree.put(2, "Two");
    tree.put(4, "Four");

    System.out.println("BST Size: " + tree.size());

    // Итерация (In-order: выведет 2, 3, 4, 5, 8)
    for (var elem : tree) {
        System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
    }
}
