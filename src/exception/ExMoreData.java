package exception;

/** Исключение, обрабатывающее избыток введённых данных */
public class ExMoreData extends Exception{
    public ExMoreData(){}
    public void exMoreData(){
        System.out.println("Exception: ExLessData - Введённых данных больше, чем требуется\n");
    }
}
