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
        /** Переменная для зацикливания меню. Пока true - продолжаем ввод данных. Значение true присвается 
         * при ответе пользователя на запрос getContinued, имеющий любое значение отличное от n или N.
         */
        boolean continuation = true;
        do {
            try {
                /** Запрос пользователю на ввод данных */
                String dataLine = prompt("Введите данные через пробел: ФИО, пол (m/f), дата рождения (dd.mm.yyyy), номер телефона:\n");
                /** Пытаемся расшифровать введённые данные */
                ClsNote note = noteController.ParsData(dataLine);
                /** Сохраняем введённые данные */
                noteController.saveNoteToTxt(note);
                /** Запрашиваем повтор ввведения */
                String getContinued = prompt("Введём ещё данные? y/n: ").toUpperCase();
                if (getContinued.equals("N")) {
                    continuation = false;
                };        
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }                      
        } while (continuation);            
    }
    
    /**
     * Получение данных с одного ввода с консоли
     * @param message - выводимое сообщение
     * @return String
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
