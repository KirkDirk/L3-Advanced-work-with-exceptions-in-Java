package exception;

public class ExNoGender extends Exception {
    public ExNoGender(){}
    public void exNoGender(){
        System.out.println("Exception: ExNoGender - Не найдены данные о поле\n");
    }
}
