package main;
import gui.LoginWindow;

public class Main {
    public static void main(String[] args) {
        Access access = new Access();

        LoginWindow loginWindow = new LoginWindow(access);
        loginWindow.setVisible(true);

    }
}