import java.util.concurrent.atomic.AtomicLong;

public class Shop {
    private int[] arr;
    private AtomicLong sum = new AtomicLong(0);

    public Shop(int[] arr) {
        this.arr = arr;
    }

    public void shopSum(int[] arr) {
        int arrSum = 0;
        for (int i : arr) {
            arrSum += i;
        }
        sum.addAndGet(arrSum);
        System.out.println("Выручка в " + Thread.currentThread().getName() + " - " + sum + " рублей.");
    }

    public long getSum() {
        return sum.get();
    }
}
