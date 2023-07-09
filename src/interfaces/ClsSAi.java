package interfaces;

public class ClsSAi implements StorageActions {
    private String filename = "";

    public ClsSAi(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean SaveNote(String line) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SaveNote'");
    }

    @Override
    public boolean CheckFileEmpty(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckFileEmpty'");
    }

    @Override
    public String ReadDataFromFile(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ReadDataFromFile'");
    }
    
}
