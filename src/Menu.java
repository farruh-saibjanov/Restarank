import java.util.ArrayList; // ArrayList uchun kerak
import java.util.List;      // List uchun kerak

public class Menu {
    String categoryName;
    ArrayList<Dish> dishes;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.dishes = new ArrayList<>();
    }

    public void addDish(String name, double price, List<String> ingredients) {
        dishes.add(new Dish(name, price, ingredients));
    }

    public void displayMenu() {
        System.out.println("\n" + categoryName + ":");
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println((i + 1) + ". " + dishes.get(i));
        }
    }

    public Dish getDish(int index) {
        if (index >= 0 && index < dishes.size()) {
            return dishes.get(index);
        } else {
            return null;
        }
    }

    public int getMenuSize() {
        return dishes.size();
    }
}
