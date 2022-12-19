import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        //System.out.println(Arrays.toString("1-1-1-1-133-3-3-4-56-7-u8-75--v-b-fgbn-fgnfgn-fgn-gfg0".split("")));
        String[] basketstr = new String[] {"3-2", "2-8", "5-1", "6-8"};

        Basket basket = new Basket();

        for (String i: basketstr)
        {
            //System.out.println(i.split("-")[0] + "    " + Integer.valueOf(i.split("-")[1]));
            basket.addItem(i.split("-")[0],Integer.valueOf(i.split("-")[1]));
        }
        basket.printBasket();
    }
}
