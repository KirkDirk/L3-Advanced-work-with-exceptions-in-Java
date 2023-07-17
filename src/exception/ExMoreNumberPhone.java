package exception;

public class ExMoreNumberPhone extends Exception{
    public ExMoreNumberPhone() {}
    public void exMoreNumberPhone(){
        System.out.println("Exception: ExMoreNumberPhone - Слишком много цифр в телефонном номере");
    }
}
