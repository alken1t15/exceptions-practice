package ExceptionTask3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите логин");
            String login = bufferedReader.readLine();
            System.out.println("Введите пароль");
            String pass = bufferedReader.readLine();
            System.out.println("Введите пароль еще раз");
            String confirmPass = bufferedReader.readLine();
            boolean inputs = input(login, pass, confirmPass);
            System.out.println("Пароль соотвествует требования? " + inputs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean input(String login, String pass, String confirmPass) {
        try {
            if (login.length() < 20) {
                if (pass.length() < 20 && pass.equals(confirmPass)) {
                    return true;
                } else {
                    throw new WrongPasswordException("Пароль не соотвествует требованиям");
                }
            } else {
                throw new WrongLoginException("Логин слишком длинный");
            }
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        } catch (WrongLoginException exx) {
            System.out.println(exx.getMessage());
        }
        return false;
    }
}