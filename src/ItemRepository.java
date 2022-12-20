import java.util.HashMap;
import java.util.Map;
import java.lang.NullPointerException;

public class ItemRepository extends Item {
    public static Map<String, Item> prices;
    public ItemRepository(String id, String name, Double price) {
        super(id, name, price);
    }

    static {
        prices = new HashMap<>();
        new Item("1", "Milk", 6.20);
        new Item("2", "Butter", 9.90);
        new Item("3", "Bread", 7.50);
        new Item("4", "Beans", 11.20);
        new Item("5", "Meat", 23.0);
        new Item("6", "Bananas", 7.80);
    }
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

