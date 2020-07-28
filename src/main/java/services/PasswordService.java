package services;

import controllers.ClientController;

import java.util.LinkedList;

public class PasswordService {

    private ClientController listener = null;
    private LinkedList<Integer> password;

    private boolean correct;

    public PasswordService() {
        password = new LinkedList<>();
        correct = false;
    }

    public void addListener(ClientController listener) {
        this.listener = listener;
    }

    private void notifyListener() {
        this.listener.listenPassword(false);
    }

    public void push(int number) {
        password.add(number);
        if (password.size() == 8) {
            System.out.println(password);
            notifyListener();
        }
    }
}
