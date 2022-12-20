import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class FilePrintService implements IPrintReceiptService {
    public static void print(Basket basket) {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        PrintStream backupOut = System.out;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out.log"))) {
            double total = 0;
            double rand = (int) (Math.random() * 100000);

            writer.write("%24s\n".formatted("CASH RECEIPT"));
            writer.write("%24s\n".formatted("Supermarket 123"));
            writer.write("%30s\n".formatted("12 MilkyWay Galaxy/Earth"));
            writer.write("%28s\n".formatted("Tel. +123-456-789"));
            writer.write("%s %s %s %s %s %s %s %s\n".formatted("Cashier:No", rand, "DATE:", today.getDayOfMonth(), "/", today.getMonthValue(), "/", today.getYear()));
            writer.write("%24s %s %s %s %s %s\n".formatted("TIME:", time.getHour(), ":", time.getMinute(), ":", time.getSecond()));
            writer.write("_______________________________________\n");
            writer.write("%-10s %-10s %-10s %-10s\n".formatted("QTY", "DESCRIPTION", "PRICE", "TOTAL"));
            for (String i : basket.basket.keySet()) {
                Double finalPrice = ItemRepository.getPrice(i) * DiscountService.checkDiscount(i);
                writer.write("%-10s %-11s %-10s %-10s\n".formatted(basket.basket.get(i), ItemRepository.getName(i), ItemRepository.getPrice(i), finalPrice * basket.basket.get(i)));
                total += finalPrice * basket.basket.get(i);
            }
            writer.write("_______________________________________");
            writer.write("%s %24.2f".formatted("\nTAXABLE TOT. ", total));
            writer.write("%s %24.2f".formatted("\nVAT 17%      ", total * basket.vat));
            writer.write("%s %24.2f".formatted("\nTOTAL        ", total + total * basket.vat));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.setOut(backupOut);
    }
}
