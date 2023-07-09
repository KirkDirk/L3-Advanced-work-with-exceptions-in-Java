package controllers;

import interfaces.DataVerification;
import interfaces.StorageActions;

public class NoteController {
    private StorageActions storageActions;
    private DataVerification dataVerification;
    
    public NoteController(StorageActions storageActions, DataVerification dataVerification) {
        this.storageActions = storageActions;
        this.dataVerification = dataVerification;
    }

    // public NoteController(StorageActions storageActions, DataVerification dataVerification) {
    // }

    
}


