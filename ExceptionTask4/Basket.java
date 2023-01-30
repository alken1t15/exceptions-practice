package ExceptionTask4;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    ArrayList<Product> productArrayListBuy = new ArrayList<>();

    public Basket(ArrayList<Product> productArrayList) {
        productArrayListBuy.clear();
        Iterator<Product> iter = productArrayList.iterator();
        while (iter.hasNext()) {
            productArrayListBuy.add(iter.next());
        }
    }
}