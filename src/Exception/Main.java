package Exception;

public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_";

    public static void main(String[] args) {
        try {
            checkCredential("admin", "356", "366");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException e) {
            System.out.println("Неправильно введен логин");
        } catch (WrongPasswordException e) {
            System.out.println("Неправильно введен пароль");
        } finally {
            System.out.println("Проверка не пройдена");
        }
    }

    public static void checkCredential(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!login.matches(REGEX)) {
            throw new WrongLoginException();
        }
        if (password.length() > 20) {
            throw new WrongPasswordException();
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}
