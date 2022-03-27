import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    private static int SHOPS_COUNT = 4;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {

        LongAdder sum = new LongAdder();

        for (int i = 0; i < SHOPS_COUNT; i++) {
            int[] arr = getArr();
            Shop shop = new Shop(arr);
            Thread shopSum = new Thread(null, () -> shop.shopSum(arr), "Магазин " + (i + 1));
            shopSum.start();
            shopSum.join();
            sum.add(shop.getSum());
        }
        System.out.println("Итоговая сумма по " + SHOPS_COUNT + "-ом магазинам - " + sum.sum() + " рублей");
    }

    public static int[] getArr() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RANDOM.nextInt(2000);
        }
        return arr;
    }

}
