package ExceptionTask4;

import ExceptionTask.UserNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import static ExceptionTask4.Categor.commonList;

public class Main {
    public static ArrayList<User> userArrayList = new ArrayList<>();
    public static ArrayList<Product> arrayList1 = new ArrayList<>();
    public static ArrayList<Product> arrayList2 = new ArrayList<>();
    public static ArrayList<Product> arrayList3 = new ArrayList<>();
    public static ArrayList<Product> arrayList4 = new ArrayList<>();

    //TODO массивы с товарами
    static {
        //list1
        arrayList1.add(new Product("МОЛОКО «ADAL»", 300, 5.5));
        arrayList1.add(new Product("ТВОРОГ «ADAL»", 569, 4.5));
        arrayList1.add(new Product("МОЛОКО «БУРНЕНСКОЕ»", 393, 7.8));
        arrayList1.add(new Product("СМЕТАНА «МОЛОЧНЫЙ БИДОНЧИК»", 379, 4.3));
        arrayList1.add(new Product("КЕФИР «МОЛОЧНЫЙ БИДОНЧИК»", 325, 8.8));
        // list2
        arrayList2.add(new Product("ЛИМОНАД «БУРАТИНО»", 349, 3.5));
        arrayList2.add(new Product("ВОДА «TASSAY»", 487, 6));
        arrayList2.add(new Product("НАПИТОК «FORSAGE ENERGY»", 295, 5.9));
        arrayList2.add(new Product("ВОДА «АСЕМ АЙ»", 155, 2.3));
        arrayList2.add(new Product("НАПИТОК «FLASH UP»", 245, 7.7));
        //list3
        arrayList3.add(new Product("ЧАЙ «ШАХ»", 599, 5.5));
        arrayList3.add(new Product("КОФЕ «NESCAFE»", 1899, 7.5));
        arrayList3.add(new Product("КОФЕ «MACCOFFEE»", 73, 8.6));
        arrayList3.add(new Product("КОФЕ «JACOBS»", 2499, 4.2));
        arrayList3.add(new Product("ЧАЙ «АЛЬ-КАЙРАТ»", 1035, 7.3));
        //list4
        arrayList4.add(new Product("СЫР «ЭМИР»", 2999, 2.5));
        arrayList4.add(new Product("КОЛБАСА «АЛ ХАЛАЛ»", 899, 6.5));
        arrayList4.add(new Product("СЫР «СИС»", 2735, 9.6));
        arrayList4.add(new Product("СЫР «SVEZA»", 559, 7.5));
        arrayList4.add(new Product("СЕЛЬДЬ «VICI»", 839, 4.5));
        //userArrayList
        userArrayList.add(new User("jhon", "pass"));
        userArrayList.add(new User("vlad", "smallpass"));
        userArrayList.add(new User("petrov", "bigpass"));
        userArrayList.add(new User("nikita", "goodpass"));
    }

    //TODO Проверка пароля для входа в аккаунт
    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        for (User user : userArrayList) {
            if (login.equalsIgnoreCase(user.getLogin()) && password.equalsIgnoreCase(user.getPass())) {
                return user;
            }
        }
        throw new UserNotFoundException("User is not found");

    }

    public static void inputProfile() throws IOException, UserNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите логин");
        String login = bufferedReader.readLine();
        System.out.println("Введите пароль");
        String pass = bufferedReader.readLine();
        User user = getUserByLoginAndPassword(login, pass);
        System.out.println("Вы успешно вошли в аккаунт");
        viewingCatalog(user);
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Если вы хотите войти зарегестрировать аккаунт введите yes , если нет no");
                String input = bufferedReader.readLine();
                if (input.equalsIgnoreCase("yes")) {
                    UserRegistr.authorization();
                }
                inputProfile();
                System.out.println("Введите команду: exit если вы хотите выйти c программы");
                String word = bufferedReader.readLine();
                if (word.equalsIgnoreCase("exit")) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (UserNotFoundException ex) {
                System.err.println("Такого пользователя нету!!");
                try {
                    Thread.sleep(10);
                    System.out.println("Введите команду: exit если вы хотите выйти c программы");
                    System.out.println("Введите команду: repeat если вы хотите попробовать заново войти");
                    String word = bufferedReader.readLine();
                    if (word.equalsIgnoreCase("exit")) {
                        break;
                    }
                } catch (InterruptedException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //TODO Работа с каталогом
    public static void viewingCatalog(User user) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Categor milkCatalog = new Categor("Молочное", arrayList1);
        Categor drinksCatalog = new Categor("Напитки", arrayList2);
        Categor teaAndCoffee = new Categor("ЧайИКоффе", arrayList3);
        Categor gastronomy = new Categor("Гастрономия", arrayList4);
        System.out.println("Мы можем предложить вам такой каталог продуктов: milkCatalog, drinksCatalog, teaAndCoffee, gastronomy.\nЧтобы войти и посмотреть продукты каталога введите название каталога.\nЧтобы  добавить товар в корзину введите add.\nЧтобы купить товар введите buy.\nЧтобы посмотреть что находиться в корзине введите showBasket.\nЧтобы удалить товар с корзины введите deleteProduct");
        try {
            while (true) {
                String catalog = bufferedReader.readLine();
                switch (catalog) {
                    case "milkCatalog" -> milkCatalog.sortedArray();
                    case "drinksCatalog" -> drinksCatalog.sortedArray();
                    case "teaAndCoffee" -> teaAndCoffee.sortedArray();
                    case "gastronomy" -> gastronomy.sortedArray();
                    case "add" -> {
                        boolean addProduct = false;
                        System.out.println("Введите название товара");
                        String productName = bufferedReader.readLine();
                        Iterator<Product> iter = commonList.iterator();
                        while (iter.hasNext()) {
                            Product enter = iter.next();
                            if (enter.getName().equals(productName)) {
                                addProduct = true;
                                user.basketArray.add(enter);
                                System.out.println("Товар добавлен в корзину");
                            }
                        }
                        if (addProduct == false) {
                            System.err.println("Такого товара нету");
                        }
                    }
                    case "showBasket" -> user.showBasket();
                    case "deleteProduct" -> {
                        boolean deleteProduct = false;
                        System.out.println("Введите название товара");
                        String productNameDelete = bufferedReader.readLine();
                        Iterator<Product> iter2 = user.basketArray.iterator();
                        while (iter2.hasNext()) {
                            Product enter = iter2.next();
                            if (productNameDelete.equals(enter.getName())) {
                                deleteProduct = true;
                                user.basketArray.remove(enter);
                                System.out.println("Товар был удален с корзины");
                                break;
                            }
                        }
                        if (deleteProduct == false) {
                            System.err.println("Такого товара нету");
                        }
                    }
                    case "buy" -> user.buy();
                    case "exit" -> System.out.println("Вы вышли с каталога");
                    default -> System.out.println("Введите команду: exit если вы хотите выйти из каталога");
                }
                break;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}