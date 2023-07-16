package controllers;

import exception.ExLessData;
import exception.ExMoreData;
import exception.ExNoGender;
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

    // public NoteController(StorageActions storageActions, DataVerification
    // dataVerification) {
    // }

    /**
     * Метод для расшифровки введённых данных
     * 
     * @param line строка, введённая пользователем в консоль
     * @return класс Note
     * @throws ExLessData
     * @throws ExMoreData
     */
    public ClsNote ParsData(String line) {
        ClsNote note = new ClsNote();
        /** Разбиваем введённые данные на части */
        String[] noteArrStrings = line.split(" ");
        /**
         * Проверяем введенное количество данных. ФИО = 3, пол = 1
         * дата рождения = 1, телефон = 1. Всего получается 6
         */
        if (noteArrStrings.length < 6)
            try {
                throw new ExLessData();
            } catch (ExLessData e) {
                e.exLessData();
            }
        if (noteArrStrings.length > 6)
            try {
                throw new ExMoreData();
            } catch (ExMoreData e) {
                e.exMoreData();
            }
        /** Проверяем введенные данные */
        for (String partLine : noteArrStrings) {
            /** Проверяем односимвольное значение на соответствие полу в формате: m/f */
            if (partLine.length() == 1) {
                if (partLine.toLowerCase().equals("f") ||
                        partLine.toLowerCase().equals("m")) {
                    note.setGender(partLine);
                } else {
                    try {
                        throw new ExNoGender();
                    } catch (ExNoGender e) {
                        e.exNoGender();
                    }
                }
            /** Проверяем значение с точками на соответствие дате в формате dd.mm.yyyy */
            } else if (partLine.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] dateArrStrings = partLine.split(".\\");
            } else {
                
            }
            
        }
        return note;
    }

    // Это не нужно, если используется только один раз в ParsData
    // String[] LineToNoteArrStrings(String line){
    // String[] noteArrStrings= line.split(" ");
    // return noteArrStrings;
    // }

    /**
     * Метод преобразования класса Note в строку в определенной последовательности
     * для сохранения в файл
     * 
     * @param note передаваемая Запись для преобразования
     * @return строка для сохранения в файл
     */
    String NoteToLine(ClsNote note) {
        String line = note.getLastName() + " " +
                note.getFirstName() + " " +
                note.getPatronymic() + " " +
                note.getGender() + " " +
                note.getBirthDate() + " " +
                note.getPhoneNumber() + "\n";
        return line;
    }

    public void saveNoteToTxt(ClsNote note) {
        // dataVerification.CheckNoteIsNull(note);
        // if (note == null) {
        // try {
        // throw new ExNoData();
        // } catch (Exception e) {
        // ((ExNoData) e).exNoData();
        // }
        // }
        // else {
        String line = NoteToLine(note);
        storageActions.SaveNote(line);
        // }
    }
}
