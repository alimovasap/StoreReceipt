import java.util.ArrayList;

public class DiscountService {
    private static final double percentDiscount = 10.0; //10%
    private static final double fullPrice = 1.0; //100%
    private static final double DiscountPrice = fullPrice - (percentDiscount / 100); //90%

    static ArrayList<String> discountArray;

    static {
        discountArray = new ArrayList<>();
        discountArray.add("1");
        discountArray.add("2");
        discountArray.add("5");
    }

    public static double checkDiscount(String id) {
        return discountArray.contains(id) ? DiscountPrice : fullPrice;
    }
}
