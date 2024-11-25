import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        Menu milliyTaomlar = new Menu("Milliy Taomlar");
        milliyTaomlar.addDish("Osh", 30000, Arrays.asList("Guruch", "Sabzi", "Go'sht", "Ziravorlar"));
        milliyTaomlar.addDish("Somsa", 10000, Arrays.asList("Go'sht", "Piyoz", "Xamir"));
        milliyTaomlar.addDish("Shurva", 25000, Arrays.asList("Go'sht", "Kartoshka", "Sabzi", "Piyoz"));

        Menu fransiyaTaomlari = new Menu("Fransiya Taomlari");
        fransiyaTaomlari.addDish("Baget", 20000, Arrays.asList("Bug'doy non", "Yog'"));
        fransiyaTaomlari.addDish("Kruvasan", 15000, Arrays.asList("Xamir", "Shokolad", "Yog'"));
        fransiyaTaomlari.addDish("Onion Soup", 35000, Arrays.asList("Piyoz", "Suv", "Non"));

        Menu yaponiyaTaomlari = new Menu("Yaponiya Taomlari");
        yaponiyaTaomlari.addDish("Sushi", 50000, Arrays.asList("Guruch", "Baliq", "Yashil qirg'ich"));
        yaponiyaTaomlari.addDish("Ramen", 40000, Arrays.asList("Noodles", "Go'sht", "Tuxum", "Suv"));
        yaponiyaTaomlari.addDish("Tempura", 30000, Arrays.asList("Sabzavotlar", "Qovurilgan moy"));

        Menu muzqaymoqlar = new Menu("Muzqaymoqlar");
        muzqaymoqlar.addDish("Vanil", 10000, Arrays.asList("Sut", "Shakar", "Vanilin"));
        muzqaymoqlar.addDish("Shokolad", 12000, Arrays.asList("Sut", "Shakar", "Shokolad"));
        muzqaymoqlar.addDish("Mevali", 15000, Arrays.asList("Sut", "Meva ekstrakti", "Shakar"));

        Menu ichimliklar = new Menu("Ichimliklar");
        ichimliklar.addDish("Choy", 5000, Arrays.asList("Choy barglari", "Suv", "Shakar"));
        ichimliklar.addDish("Kofe", 10000, Arrays.asList("Kofe donalari", "Suv", "Shakar"));
        ichimliklar.addDish("Sharbat", 15000, Arrays.asList("Meva", "Suv", "Shakar"));

        Menu shirinliklar = new Menu("Shirinliklar");
        shirinliklar.addDish("Tort", 20000, Arrays.asList("Un", "Yog'", "Krem", "Shakar"));
        shirinliklar.addDish("Pechenye", 8000, Arrays.asList("Un", "Shakar", "Yog'"));
        shirinliklar.addDish("Krem bilan Pirojnoe", 15000, Arrays.asList("Krem", "Un", "Shakar"));


        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(milliyTaomlar);
        menus.add(fransiyaTaomlari);
        menus.add(yaponiyaTaomlari);
        menus.add(muzqaymoqlar);
        menus.add(ichimliklar);
        menus.add(shirinliklar);


        ArrayList<Dish> buyurtma = new ArrayList<>();


        while (true) {
            System.out.println("\nAsalomu aleykum, 'Burger King' restoraniga xush kelibsiz!");
            System.out.println("Menyu bilan tanishing:");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + " - " + menus.get(i).categoryName);
            }
            System.out.println((menus.size() + 1) + " - Dasturdan chiqish");
            System.out.print("Tanlovingizni kiriting: ");
            int tanlov = scanner.nextInt();

            if (tanlov == menus.size() + 1) {
                break;
            } else if (tanlov > 0 && tanlov <= menus.size()) {
                Menu tanlanganMenyu = menus.get(tanlov - 1);
                tanlanganMenyu.displayMenu();

                System.out.print("\nTaom raqamini tanlang yoki 0 ni bosing (Orqaga qaytish): ");
                int taomTanlov = scanner.nextInt();
                if (taomTanlov > 0 && taomTanlov <= tanlanganMenyu.getMenuSize()) {
                    Dish tanlanganTaom = tanlanganMenyu.getDish(taomTanlov - 1);
                    buyurtma.add(tanlanganTaom);
                    System.out.println(tanlanganTaom.name + " buyurtmangizga qo'shildi.");
                } else if (taomTanlov != 0) {
                    System.out.println("Noto'g'ri tanlov. Orqaga qaytib davom eting.");
                }
            } else {
                System.out.println("Noto'g'ri tanlov. Iltimos, qaytadan urinib ko'ring.");
            }
        }


        System.out.println("\nBuyurtmalaringiz:");
        double jamiNarx = 0;
        for (Dish d : buyurtma) {
            System.out.println(d);
            jamiNarx += d.price;
        }

        System.out.println("Jami summa: " + jamiNarx + " so'm. Rahmat!");
        scanner.close();
    }
}
