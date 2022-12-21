import java.time.LocalDate;
import java.time.LocalTime;

public abstract class PrintReceipt implements IPrintReceiptService {
    public static void print(Basket basket) {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        double total = 0;
        double rand = (int) (Math.random() * 100000);

        System.out.printf("%24s\n", "CASH RECEIPT");
        System.out.printf("%24s\n", "Supermarket 123");
        System.out.printf("%30s\n", "12 MilkyWay Galaxy/Earth");
        System.out.printf("%28s\n", "Tel. +123-456-789");
        System.out.printf("%s %s %s %s %s %s %s %s\n", "Cashier:No", rand, "DATE:", today.getDayOfMonth(), "/",
                today.getMonthValue(), "/", today.getYear());
        System.out.printf("%24s %s %s %s %s %s\n", "TIME:", time.getHour(), ":", time.getMinute(), ":", time.getSecond());
        System.out.println("_______________________________________\n");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "QTY", "DESCRIPTION", "PRICE", "TOTAL");
        for (String i : basket.basket.keySet()) {
            Double finalPrice = ItemRepository.getPrice(i) * DiscountService.checkDiscount(i);
            System.out.printf("%-10s %-11s %-10s %-10s\n", basket.basket.get(i), ItemRepository.getName(i),
                    ItemRepository.getPrice(i), finalPrice * basket.basket.get(i));
            total += finalPrice * basket.basket.get(i);
        }
        System.out.println("_______________________________________");
        System.out.printf("%s %24.2f", "\nTAXABLE TOT. ", total);
        System.out.printf("%s %24.2f", "\nVAT 17%      ", total * basket.vat);
        System.out.printf("%s %24.2f", "\nTOTAL        ", total + total * basket.vat);
    }
}
