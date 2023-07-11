package views;

import java.util.Scanner;

import controllers.NoteController;
import models.ClsNote;

public class ViewNote {
    private NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        boolean continuation = true;
        do {
            String dataLine = prompt("Введите данные через пробел: ФИО, пол (m/f), дата рождения (дд.мм.гггг) номер телефона:\n");
            ClsNote note = noteController.ParsData(dataLine);
            noteController.saveNoteToTxt(note);
            if (prompt("Введём ещё данные? y/n:").toUpperCase() == "N") {
                continuation = false;
            }            
        } while (continuation);            

    }
    
    /**
     * Получение данных с одного ввода с консоли
     * 
     * @param message - выводимое сообщение
     * @return String
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
