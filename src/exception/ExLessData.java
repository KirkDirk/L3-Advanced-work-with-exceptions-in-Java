package exception;

public class ExLessData extends Exception {
    public ExLessData(){}
    public void exLessData(){
        System.out.println("Exception: ExLessData - Введённых данных меньше, чем требуется\n");
    }
}
