package interfaces;

public interface StorageActions {
   /**
    * Запись введённых данных в файл. 
    * @param line данные, представленные в упорядоченной строке 
    * @param fileName имя файла, формируемое из фамилии и расширения txt
    */
    void SaveNote(String line, String fileName);
    
}
