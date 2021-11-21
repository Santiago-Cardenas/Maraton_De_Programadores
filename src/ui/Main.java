package ui;

import java.util.Scanner;

import model.Marathon;
import model.Programmer;

public class Main {

    private static Scanner sc;
    private Marathon marathon;

    public Main() {
        sc = new Scanner(System.in);
        marathon = new Marathon();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.mainMenu(false);
    }

    public void mainMenu(boolean exit) {

        if (exit==false) {

            System.out.println("	**MENU** \n"
                    + "1) Add a programmer \n"
                    + "2) Delete a programmer \n"
                    + "3) Search for a programmer \n"
                    + "4) Programmer list \n"
                    + "0) Exit \n");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addProgrammerToList();
                    mainMenu(false);
                    break;

                case 2:
                    deleteProgrammerFromTheList();
                    mainMenu(false);
                    break;

                case 3:
                    searchProgrammer();
                    mainMenu(false);
                    break;

                case 4:
                    System.out.println("Programmer list: ");
                    showListOfProgrammers();
                    mainMenu(false);
                    break;

                default:
                    System.out.println("Goodbye\n");
                    mainMenu(true);
                    break;
            }
        }

    }

    public void addProgrammerToList() {

        System.out.print("Participant name: \n");
        String name = sc.nextLine();

        System.out.print("Participant phone number: \n");
        String phone = sc.nextLine();

        System.out.print("Participant address: \n");
        String address = sc.nextLine();

        System.out.print("Participant email: \n");
        String email = sc.nextLine();

        marathon.addProgrammer(name, phone, address, email);

    }

    public void deleteProgrammerFromTheList() {

        System.out.println("Name of the participant that you want to delete \n");
        String programmerName = sc.nextLine();

        marathon.triggerDelete(programmerName);
        if(marathon.isDoesntExits()==true){
            System.out.println("There is no programmer with that name registered \n");
            marathon.setDoesntExits(false);
        }

    }

    public void searchProgrammer() {

        System.out.println("Enter the name of the participant that you want to search \n");
        String name = sc.nextLine();

        Programmer  searchedProgrammer = marathon.triggerSearchProgrammer(name);
        if(searchedProgrammer == null) {
            System.out.println("There is no programmer with that name registered \n");
        }
        else{
            System.out.println("**Information**");
            System.out.println(searchedProgrammer);
        }
    }

    public void showListOfProgrammers() {
        marathon.triggerInOrder();
    }

}
