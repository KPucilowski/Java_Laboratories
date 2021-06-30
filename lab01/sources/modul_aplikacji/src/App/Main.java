package App;

import Controller.AplikacjaController;

public class Main {
    public static void main(String[] args) {
        //System.setProperty("java.security.policy","file:C:\\Users\\Krzysztof\\IdeaProjects\\lab1.0\\modul_aplikacji\\src\\myPolicy.policy");
        System.setSecurityManager(new SecurityManager());

        AplikacjaController app = new AplikacjaController();
        app.init();
    }

}
