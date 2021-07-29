package ru.studentsmanager;

public class ObjectIsNull extends RuntimeException{

    String msg = "Object must not null !!";

    public ObjectIsNull() {
    }

    @Override
    public String getMessage() {
        return super.getMessage()  + " " + msg;
    }
}
