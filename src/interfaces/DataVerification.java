package interfaces;

import models.ClsNote;

public interface DataVerification {
    /** Проверка наличия неправильных символов в введенном ФИО */
    String CheckWrongCharInName(String name);
    /** Проверка формата введенной даты рождения */
    String CheckIncorrectDate(String date);
    /** Проверка формата введенного номера телефона */
    String CheckIncorrectPhoneNumber(int number);
    /** Проверка на совпадение записываемых данных */

    /**
     * Проверка на пустотность Записи
     * @param note проверяемая Запись
     * @return 
     */
    boolean CheckNoteIsNull(ClsNote note);

    boolean CheckPartLineIsGender(String partLine);
    
}
