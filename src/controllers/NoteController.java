package controllers;

import interfaces.DataVerification;
import interfaces.StorageActions;
import models.ClsNote;

public class NoteController {
    private StorageActions storageActions;
    private DataVerification dataVerification;
    
    public NoteController(StorageActions storageActions, DataVerification dataVerification) {
        this.storageActions = storageActions;
        this.dataVerification = dataVerification;
    }

    // public NoteController(StorageActions storageActions, DataVerification dataVerification) {
    // }

    public ClsNote ParsData(String line){
        ClsNote note = null;
        return note;
    }
    
    String NoteToLine(ClsNote note){
        String line = note.getLastName() + " " +
                        note.getFirstName() + " " +
                        note.getPatronymic() + " " +
                        note.getGender() + " " +
                        note.getBirthDate() + " " +
                        note.getPhoneNumber() + "\n";
        return line;
    }

    public void saveNoteToTxt(ClsNote note){
        String line = NoteToLine(note);
        storageActions.SaveNote(line);
    }
}


