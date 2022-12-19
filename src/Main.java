public class Main
{
    public static void main(String[] args)
    {
        String[] basketstr = new String[] {"3-3", "2-5", "5-1", "6-8"};
        Basket basket = new Basket();

        for (String i: basketstr)
        {
            basket.addItem(i.split("-")[0],Integer.valueOf(i.split("-")[1]));
        }
        basket.printBasket();
        basket.printInConsole();
    }
}
