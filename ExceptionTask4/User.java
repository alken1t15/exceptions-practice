package ExceptionTask4;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class User {
    Basket basket;
    public ArrayList<Product> basketArray = new ArrayList<>();
    private String login;
    private String pass;
    Locale locFR = new Locale("fr");
    NumberFormat numberFormat4 = NumberFormat.getCurrencyInstance(locFR);

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public void buy() {
        if (basketArray.isEmpty()) {
            System.err.println("У вас нету товаров в корзине которые вы можете купить");
        } else {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            long temp = 0;
            Iterator<Product> iter = basketArray.iterator();
            System.out.println("Дата:                                 " + formater.format(date));
            System.out.println("                                                ");
            System.out.println("Продукты                   Рейтинг          Цена");
            System.out.println("------------------------------------------------");
            while (iter.hasNext()) {
                Product enter = iter.next();
                temp += enter.getPrice();
                System.out.println(enter.getName() + "          " + enter.getRating() + "            " + numberFormat4.format(enter.getPrice()));
                //System.out.printf("%s          %1.1f           %s\n",enter.getName(),enter.getRating(),numberFormat4.format(enter.getPrice()));
            }
            System.out.println("------------------------------------------------");
            System.out.printf("Итого                                     %s", numberFormat4.format(temp));
            basket = new Basket(basketArray);
            basketArray.clear();
        }
    }

    public void showBasket() {
        if (basketArray.isEmpty()) {
            System.err.println("Товаров в корзине нету");
        } else {
            Iterator<Product> iter = basketArray.iterator();
            System.out.println("Товары которые находиться в корзине: ");
            while (iter.hasNext()) {
                Product enter = iter.next();
                System.out.printf("Название товара: %s его рейтинг: %1.1f его цена: %s\n", enter.getName(), enter.getRating(), numberFormat4.format(enter.getPrice()));
            }
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}