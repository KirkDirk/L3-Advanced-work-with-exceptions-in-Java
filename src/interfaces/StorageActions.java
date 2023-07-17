package interfaces;

public interface StorageActions {
    /** Запись данных в файл 
     * @param filename*/
    void SaveNote(String line, String fileName);
    /** Проверка наличия данных в файле */
    boolean CheckFileEmpty(String filename);
    /** Чтение данных из файла */
    String ReadDataFromFile(String filename);

}
