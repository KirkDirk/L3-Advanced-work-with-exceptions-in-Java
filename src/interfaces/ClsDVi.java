package interfaces;

import exception.ExNoData;
import models.ClsNote;

public class ClsDVi implements DataVerification {
    private String filename;
    private String date;
    private int number;
    
    public ClsDVi(String filename, String date, int number) {
        this.filename = filename;
        this.date = date;
        this.number = number;
    }

    public ClsDVi() {
        super();
    }

    @Override
    public String CheckWrongCharInName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckWrongCharInName'");
    }

    @Override
    public String CheckIncorrectDate(String date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckIncorrectDate'");
    }

    @Override
    public String CheckIncorrectPhoneNumber(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckIncorrectPhoneNumber'");
    }

    @Override
    public boolean CheckNoteIsNull(ClsNote note) {
        if (note == null) {
            try {
                throw new ExNoData();
            } catch (ExNoData e) {
                e.exNoData();
            }
            return true;
        } else return false;
    }

    @Override
    public boolean CheckPartLineIsGender(String partLine) {
        if (partLine.length() == 1 && (
            partLine.toLowerCase().equals("f") ||
            partLine.toLowerCase().equals("m")
        )) {
                return true;
            } else return false;
        }   
}
