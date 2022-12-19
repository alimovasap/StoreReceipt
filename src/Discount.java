import java.util.ArrayList;

public class Discount
{
    static ArrayList<String> discountArray;

    static
    {
        discountArray = new ArrayList<>();
        discountArray.add("1");
        discountArray.add("2");
        discountArray.add("5");
    }
    public static double getDiscount(String id)
    {
        return discountArray.contains(id)? 0.9 : 1.0;
    }

}
