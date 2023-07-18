package exception;

/** Исключение, обрабатывающее отсутствие введённых данных. Видимо лишнее, 
 * поскольку имеется ExLessData */
public class ExNoData extends Exception{
    public ExNoData() {}
    public void exNoData() {
        System.out.println("Exception: NoData - Нет введённых данных\n");
    }

}
