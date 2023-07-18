package exception;

/** Исключение, обрабатывающее недостаток введённых данных */
public class ExLessData extends Exception {
    public ExLessData(){}
    public void exLessData(){
        System.out.println("Exception: ExLessData - Введённых данных меньше, чем требуется\n");
    }
}
