package interfaces;

import java.io.FileWriter;
import java.io.IOException;

public class ClsSAi implements StorageActions {
    private String dirName; 

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
