package interfaces;

import java.io.FileWriter;
import java.io.IOException;

public class ClsSAi implements StorageActions {
    /** Адрес папки, в которой хранятся введённые данные */
    private String dirName; 

    /**
     * Конструктор интерфейса с адресом хранения данных
     * @param dirName
     */
    public ClsSAi(String dirName) {
        this.dirName = "src\\storage\\";
    }

    @Override
    public void SaveNote(String line, String fileName) {
        try (FileWriter wrtr = new FileWriter(dirName+fileName, true)) {
            wrtr.write(line);
            wrtr.flush();
            wrtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
