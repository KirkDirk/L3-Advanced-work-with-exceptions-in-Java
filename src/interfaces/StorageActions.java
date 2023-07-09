package interfaces;

public interface StorageActions {
    /** Запись данных в файл */
    boolean SaveNote(String line);
    /** Проверка наличия данных в файле */
    boolean CheckFileEmpty(String filename);
    /** Чтение данных из файла */
    String ReadDataFromFile(String filename);

}
