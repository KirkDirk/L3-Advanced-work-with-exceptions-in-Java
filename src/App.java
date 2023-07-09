import controllers.NoteController;
import interfaces.ClsDVi;
import interfaces.ClsSAi;
import interfaces.DataVerification;
import interfaces.StorageActions;
import views.ViewNote;

public class App {
    public static void main(String[] args) throws Exception {

    System.out.println("Здравствуйте!");

    StorageActions storageActions = new ClsSAi(null);
    DataVerification dataVerification = new ClsDVi();
    NoteController noteController = new NoteController(storageActions, dataVerification);
    ViewNote viewNote = new ViewNote(noteController);
    viewNote.run();

    }
}