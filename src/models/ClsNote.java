package models;

public class ClsNote {
    /** Класс Запись. Поле Фамилия */
    private String lastName;
    /** Класс Запись. Поле Имя */
    private String firstName;
    /** Класс Запись. Поле Отчество */
    private String patronymic;
    /** Класс Запись. Поле Дата рождения */
    private String birthDate;
    /** Класс Запись. Поле Номер телефона */
    private String phoneNumber;
    /** Класс Запись. Поле Пол */
    private String gender;
   
    public ClsNote(String lastName, String firstName, String patronymic, String birthDate, String phoneNumber,
            String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public ClsNote() {
        super();
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }



}
