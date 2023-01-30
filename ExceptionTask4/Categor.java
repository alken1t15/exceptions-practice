package ExceptionTask4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Categor {
    private String name;
    private ArrayList<Product> productsList = new ArrayList<>();

    static public ArrayList<Product> commonList = new ArrayList<>();

    Locale locFR = new Locale("fr");
    NumberFormat numberFormat4 = NumberFormat.getCurrencyInstance(locFR);

    public Categor(String name, ArrayList<Product> arrayList) {
        this.name = name;
        Iterator<Product> iter = arrayList.iterator();
        while (iter.hasNext()) {
            Product enter = iter.next();
            productsList.add(enter);
            commonList.add(enter);
        }
    }

    public void viewingCategor() {
        Iterator<Product> iter = productsList.iterator();
        while (iter.hasNext()) {
            Product enter = iter.next();
            System.out.printf("Название товара: %s его рейтинг: %1.1f его цена: %s\n", enter.getName(), enter.getRating(), numberFormat4.format(enter.getPrice()));
        }
    }

    public void sortedArray() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Хотите отсортировать каталог по цене,рейтингу,названию если да видите yes, если нет no");
        String sort1 = bufferedReader.readLine();
        if (sort1.equalsIgnoreCase("yes")) {
            System.out.println("Введите как именно отсортировать: price, rating");
            String sort = bufferedReader.readLine();
            if (sort.equalsIgnoreCase("price")) {
                Comparator priceComparator = new PriceSort();
                Collections.sort(productsList, priceComparator);
                this.viewingCategor();
                // Collections.sort(productsList,Collections.reverseOrder());
            } else if (sort.equalsIgnoreCase("rating")) {
                Comparator priceComparator = new RatingSort();
                Collections.sort(productsList, priceComparator);
                this.viewingCategor();
            }
        } else {
            this.viewingCategor();
        }
    }
}