package exception;

public class ExIncorrectData extends Exception{
    public ExIncorrectData(){}
    public void exIncorrectData(){
        System.out.println("Exception: ExIncorrectData - Введённые данные неверны\n");
    }    
}
