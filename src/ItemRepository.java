import java.util.HashMap;
import java.util.Map;
import java.lang.NullPointerException;

public class ItemRepository {
    public static Map<String, Item> prices;

    public ItemRepository(String id, String name, Double price) {
        prices.put(id, new Item(id, name, price));
    }

    static {
        prices = new HashMap<>();
        new ItemRepository("1", "Milk", 6.20);
        new ItemRepository("2", "Butter", 9.90);
        new ItemRepository("3", "Bread", 7.50);
        new ItemRepository("4", "Beans", 11.20);
        new ItemRepository("5", "Meat", 23.0);
        new ItemRepository("6", "Bananas", 7.80);
    }

    /*
         static void getItem(String itemId) throws Exception
        {
            if (prices.containsKey(itemId)) {
                System.out.println(prices.get(itemId).getName() + "   " + prices.get(itemId).getPrice());
            }else{
                System.out.println("Product with this id does not exist");
            }
        }
    */
    static Double getPrice(String itemId) {
        if (prices.containsKey(itemId)) {
            return prices.get(itemId).getPrice();
        }
        return 0.;
    }

    static String getName(String itemId) {
        try {
            prices.containsKey(itemId);
            return prices.get(itemId).getName();
        } catch (NullPointerException e) {
            System.out.println("Product with this id does not exist");
            //throw new RuntimeException(e);
        }
        return "";
    }
}


