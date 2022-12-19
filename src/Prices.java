import java.util.HashMap;
import java.util.Map;
import java.lang.NullPointerException;

public class Prices
{
    private final String id;
    private final String name;
    private final Double price;
    private static Map<String, Prices> prices;

    static
    {
        prices = new HashMap<>();
        new Prices("1","Milk",  6.20);
        new Prices("2","Butter",  9.90);
        new Prices("3","Bread",  7.50);
        new Prices("4","Beans",  11.20);
        new Prices("5","Meat",  23.0);
        new Prices("6","Bananas",  7.80);
    }

    private Prices(String id, String name, Double price)
    {
        this.id = id;
        this.price = price;
        this.name = name;
        prices.put(id,this);
    }

    static Double getPrice(String itemId)
    {
        if (prices.containsKey(itemId))
        {
            return prices.get(itemId).price;
        }
        return 0.;
    }
    static String getName(String itemId)
    {
            try
            {
                prices.containsKey(itemId);
                return prices.get(itemId).name;
            }
            catch (NullPointerException e)
            {
                System.out.println("Product with this id does not exist");
                //throw new RuntimeException(e);
            }
            return "";
    }
}

