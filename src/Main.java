public class Main {
    public static void main(String[] args) {
        String[] basketstr = new String[]{"3-5", "2-8", "1-4", "7-10"};
        Basket basket = new Basket();

        for (String i : basketstr) {
            basket.addItem(i.split("-")[0], Integer.valueOf(i.split("-")[1]));
        }
        PrintReceipt.print(basket);
        FilePrintService.print(basket);
    }
}
