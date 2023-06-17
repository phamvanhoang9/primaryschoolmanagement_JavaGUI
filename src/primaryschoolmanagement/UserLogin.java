package primaryschoolmanagement;

public interface UserLogin {
    boolean checkLogin(String user, String password);
    void showErrorMessage(String message);
    void loginSuccessful();
}

