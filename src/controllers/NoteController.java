package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import exception.ExIncorrectData;
import exception.ExLessData;
import exception.ExMoreData;
import exception.ExMoreNumberPhone;
import exception.ExNoGender;
import interfaces.StorageActions;
import models.ClsNote;

public class NoteController {
    private StorageActions storageActions;

    public NoteController(StorageActions storageActions) {
        this.storageActions = storageActions;
    }

    /**
     * Метод для расшифровки введённых данных
     * 
     * @param line строка, введённая пользователем в консоль
     * @return класс Note
     * @throws ExLessData исключение недостатка введённых данных
     * @throws ExMoreData исключение избытка введённых данных
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
        String fio = ""; // Переменная для сбора вводимых ФИО
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
                DateTimeFormatter dtf =new DateTimeFormatterBuilder()
                                        .parseCaseInsensitive()
                                        .appendPattern("dd.MM.yyyy")
                                        .toFormatter(Locale.ENGLISH);
                try {
                    LocalDate ld = LocalDate.parse(partLine, dtf); // переменная ld используется только для парсинга даты
                    note.setBirthDate(partLine);
                } catch (DateTimeParseException e) {
                    System.out.println("Exception: DataTimeParseException - Дата рождения введена в неверном формате\n");
                }
                /** Проверяем значение с цифрами на соответствие телефонному номеру размером не больше 11 цифр */
            } else if (partLine.matches("[0-9]+")) {
                if (partLine.length() < 12) {
                    note.setPhoneNumber(partLine);
                } else {
                    try {
                        throw new ExMoreNumberPhone();
                    } catch (ExMoreNumberPhone e) {
                        e.exMoreNumberPhone();
                    }
                }
                /** Проверяем значение ФИО на наличие в введенных данных только букв */
            } else if (partLine.matches("[A-Za-z]+")) {
                fio += partLine + " ";
                /** Здесь собираются все данные, которые не распознаны по заданным условиям */
            } else {
                try {
                    throw new ExIncorrectData();
                } catch (ExIncorrectData e) {
                    e.exIncorrectData();
                }
            }

        }
        /** Собираем fio в текущий экземпляр класса Note, исходя из условия, что 
         * во-первых, вводится фамилия, потом имя, потом отчество
         */
        String[] fioStrings = fio.split(" ");
        if (fioStrings.length == 3) {
            note.setLastName(fioStrings[0]);
            note.setFirstName(fioStrings[1]);
            note.setPatronymic(fioStrings[2]);
        } else
            try {
                throw new ExIncorrectData();
            } catch (ExIncorrectData e) {
                e.exIncorrectData();
            }
        /** Проверяем данные в текущем экземпляре класса Note. Выводим информацию об 
         * отсутствующих сведениях в случае, если какие-то из введённых данных не распарсились.
         * Это помогает определить в каких данных нужно внести корректировку
         */
        if (note.getLastName() == null)
            System.out.println("В введённых данных отсутствует фамилия");
        if (note.getFirstName() == null)
            System.out.println("В введённых данных отсутствует имя");
        if (note.getPatronymic() == null)
            System.out.println("В введённых данных отсутствует отчество");
        if (note.getGender() == null)
            System.out.println("В введённых данных отсутствует пол");
        if (note.getBirthDate() == null)
            System.out.println("В введённых данных отсутствует дата рождения");
        if (note.getPhoneNumber() == null)
            System.out.println("В введённых данных отсутствует телефонный номер");
        return note;
    }

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

    /**
     * Метод для записи данных в файл. Имя файла формируется из введённой фамилии и расширения txt
     * @param note
     */
    public void saveNoteToTxt(ClsNote note) {      
        String line = NoteToLine(note);
        String fileName = note.getLastName() + ".txt";
        storageActions.SaveNote(line, fileName);
    }
}
