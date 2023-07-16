package exception;

public class ExNoData extends Exception{
    public ExNoData() {
    }

    public void exNoData() {
        System.out.println("Exception: NoData - Нет введённых данных\n");
    }

}
