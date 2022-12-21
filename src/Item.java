public class Item {
    private String id;
    private String name;
    private Double price;

    public Item(String id, String name, Double price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
