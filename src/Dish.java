import java.util.List;

public class Dish {
    String name;
    double price;
    List<String> ingredients;

    public Dish(String name, double price, List<String> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return name + " - " + price + " so'm\n  Tarkibi: " + String.join(", ", ingredients);
    }
}
