import controllers.NoteController;
import interfaces.ClsSAi;
import interfaces.StorageActions;
import views.ViewNote;

public class App {
    public static void main(String[] args) throws Exception {

    System.out.println("\nЗдравствуйте!\n");

    StorageActions storageActions = new ClsSAi(null);
    NoteController noteController = new NoteController(storageActions);
    ViewNote viewNote = new ViewNote(noteController);
    viewNote.run();

    System.out.println("\nДо свидания!\n");
    }
}