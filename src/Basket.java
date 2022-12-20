import java.util.HashMap;
import java.util.Map;

public class Basket
{
    public static double vat = 0.17; //17% vat
     Map<String, Integer> basket;
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
}
