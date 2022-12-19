import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Basket
{
    private final double vat = 0.17;

    private Map<String, Integer> basket;
    public Basket()
    {
        basket = new HashMap<>();
    }
    public void addItem(String itemName, Integer itemCnt)
    {
        if (basket.containsKey(itemName))
        {
            basket.put(itemName, basket.get(itemName) + itemCnt);
        }
        else
        {
            basket.put(itemName, itemCnt);
        }
    }

    public void printBasket()
    {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        PrintStream backupOut = System.out;

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("out.log")) )
        {
            double priceVat = 0;
            double total = 0;
            double rand =(int)(Math.random() * 100000);

            writer.write("%24s\n".formatted("CASH RECEIPT"));
            writer.write("%24s\n".formatted( "Supermarket 123"));
            writer.write("%30s\n".formatted( "12 MilkyWay Galaxy/Earth"));
            writer.write("%28s\n".formatted("Tel. +123-456-789"));
            writer.write("%s %s %s %s %s %s %s %s\n".formatted("Cashier:No", rand, "DATE:", today.getDayOfMonth(), "/", today.getMonthValue(),"/", today.getYear()));
            writer.write("%24s %s %s %s %s %s\n".formatted("TIME:", time.getHour(), ":", time.getMinute(), ":", time.getSecond()));
            writer.write("_______________________________________\n");
            writer.write("%-10s %-10s %-10s %-10s\n".formatted( "QTY", "DESCRIPTION", "PRICE", "TOTAL"));
            for (String i: basket.keySet())
            {
                Double finalPrice = Prices.getPrice(i) * Discount.getDiscount(i);
                writer.write("%-10s %-11s %-10s %-10s\n".formatted( basket.get(i),Prices.getName(i),Prices.getPrice(i),finalPrice * basket.get(i)));
                total +=  Prices.getPrice(i) * basket.get(i);
            }
            writer.write("_______________________________________");
            //System.out.println("TAXABLE TOT  " + total);
            writer.write("%s %24.2f".formatted("\nTAXABLE TOT. ", total));
            writer.write("%s %24.2f".formatted("\nVAT 17%      ", total * vat));
            writer.write("%s %24.2f".formatted("\nTOTAL        ", total +  total * vat));

        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        System.setOut(backupOut);
    }
}
