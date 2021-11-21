package model;

public class Programmer {

    private Programmer left;
    private Programmer right;

    private String name;
    private String phone;
    private String address;
    private String email;


    public Programmer(String name, String phone, String address, String email) {

        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Programmer getLeft() {
        return left;
    }

    public void setLeft(Programmer left) {
        this.left = left;
    }

    public Programmer getRight() {
        return right;
    }

    public void setRight(Programmer right) {
        this.right = right;
    }

    public void insert(Programmer newProgrammer) throws ProgrammerAlreadyExists {

        if (newProgrammer.getName().compareTo(this.name) < 0) {

            if (this.left == null) {
                this.left = newProgrammer;
            } else {
                this.left.insert(newProgrammer);
            }
        } else if (newProgrammer.getName().compareTo(this.name) > 0) {

            if (this.right == null) {
                this.right = newProgrammer;
            } else {
                this.right.insert(newProgrammer);
            }

        } else {
            throw new ProgrammerAlreadyExists();
        }

    }

    public String toString() {

        return "Name: " +
                name +
                "\nPhone: " + phone +
                "\nAddress: " + address +
                "\nEmail: " +
                email;
    }




}