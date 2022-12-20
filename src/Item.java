public class Item {
    private final String id;
    private final String name;
    private final Double price;

    public Item(String id, String name, Double price) {
        this.id = id;
        this.price = price;
        this.name = name;
        ItemRepository.prices.put(id, this);
    }

    public Double getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }
}
