package exception;

/** Исключение, обрабатывающее случай, когда во введённых данных отсутствует 
 * значения m или f, обозначающие пол
 */
public class ExNoGender extends Exception {
    public ExNoGender(){}
    public void exNoGender(){
        System.out.println("Exception: ExNoGender - Не найдены данные о поле\n");
    }
}
