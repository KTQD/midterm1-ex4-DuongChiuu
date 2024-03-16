import java.lang.Thread;

public class tong {
    static int sum = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        int m = numbers.length;

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < m; i++) {
                sum += numbers[i];
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < m; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.printf("Phần tử lớn nhất trong mảng là: %d\n", max);
        System.out.printf("Tổng của các phần tử trong mảng là: %d", sum);

    }
}
