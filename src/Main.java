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
    }}
