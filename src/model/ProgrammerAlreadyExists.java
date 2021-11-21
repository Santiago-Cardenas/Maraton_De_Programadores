package model;

public class ProgrammerAlreadyExists extends Exception{
    public ProgrammerAlreadyExists(){
        super("The programmer already exists");
    }
}
