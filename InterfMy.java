package com.mycompany.persistenta;

import java.sql.SQLException;
import java.util.Scanner;

public class InterfMy {

    public static void main(String[] args) {

        DatabaseMethods methods = null;

        try {
            methods = new DatabaseMethods("jdbc:mysql://localhost/persistenta?serverTimezone=UTC", "root", "123456");
        } catch (SQLException ex) {
            System.out.println("Conectarea la baza de date este imposibila");
            System.exit(1);
        }

        System.out.println("conectarea la baza de date reusita");
        Scanner inoperatie = new Scanner(System.in);
        boolean continuare = true;
        boolean trecere = true;
        boolean davai = true;

        while (continuare) {
            afisareOperatii();

           
            String operatie = inoperatie.nextLine();

            switch (operatie) {

                case "afisare":

                    methods.afisareAngajati();
                    break;
                case "selectare":

                    Scanner inSpecificare = new Scanner(System.in);
                    System.out.println("Introduceti criteriul de cautare:");

                    while (davai) {

                        afisareSelectii();
                        String criteriu = inSpecificare.nextLine();

                        switch (criteriu) {
                            case "name":
                                System.out.println("Nume: ");
                                String name = inSpecificare.nextLine();
                                methods.selectareAngajatiNume(name);

                                break;
                            case "age":
                                System.out.println("Varsta: ");
                                int age = inSpecificare.nextInt();
                                methods.selectareAngajatiVarsta(age);
                                break;
                            case "address":
                                System.out.println("Adresa: ");
                                String address = inSpecificare.nextLine();
                                methods.selectareAngajatiAdresa(address);
                                break;
                            case "salary":
                                System.out.println("Salariu: ");
                                int salary = inSpecificare.nextInt();
                                methods.selectareAngajatiSalariu(salary);
                                break;
                            case "exit":

                                System.out.println("Iesire din program");

                                davai = false;

                            default:

                                System.out.println("Criteriul " + criteriu + " nu exista");
                        }

                    }
                    break;

                case "modificare":
                    Scanner inModificare = new Scanner(System.in);
                    System.out.println("Introduceti ID-ul angajatului:");

                    while (trecere) {

                        System.out.println("Selectati ce doriti sa modificati:");
                        afisareSelectii();
                        String selectie = inModificare.nextLine();
                        System.out.println("Introduceti ID-ul angajatului:");
                        int iD = inModificare.nextInt();
                        switch (selectie) {
                            case "name":

                                System.out.println("Nume: ");
                                String name = inModificare.nextLine();
                                methods.modificareAngajatiNume(name, iD);
                                break;
                            case "age":

                                System.out.println("Varsta: ");
                                int age = inModificare.nextInt();
                                methods.modificareAngajatiVarsta(age, iD);
                                break;
                            case "adress":
                                System.out.println("Adresa: ");
                                String address = inModificare.nextLine();
                                methods.modificareAngajatiAdresa(address, iD);
                                break;
                            case "salary":
                                System.out.println("Salariu: ");
                                int salary = inModificare.nextInt();
                                methods.modificareAngajatiSalariu(salary, iD);
                                break;
                            case "exit":

                                System.out.println("Iesire din program");

                                trecere = false;

                            default:

                                System.out.println("Selectia " + selectie + " nu exista");
                        }

                    }

                    break;
                case "stergere":
                    Scanner inStergere = new Scanner(System.in);
                    System.out.println("introduceti id pentru stergere:");
                    int id = inStergere.nextInt();
                    methods.stergereAngajati(id);
                    inoperatie.nextLine();
                    break;
                case "adaugare":
                    System.out.println("Nume: ");
                    String name = inoperatie.nextLine();
                    System.out.println("Varsta: ");
                    int age = inoperatie.nextInt();
                    inoperatie.nextLine();
                    System.out.println("Adresa: ");
                    String address = inoperatie.nextLine();
                    System.out.println("Salariul: ");
                    int salary = inoperatie.nextInt();
                    inoperatie.nextLine();

                    Person person = new Person(name, age, address, salary);
                    methods.noiAngajati(person);
                    break;
                case "exit":

                    System.out.println("Iesire din program");

                    continuare = false;

                    break;
                default:

                    System.out.println("Optiunea " + operatie + " nu exista");

            }
        }

    }

    public static void afisareOperatii() {
        System.out.println("afisare");
        System.out.println("selectare");
        System.out.println("modificare");
        System.out.println("stergere");
        System.out.println("adaugare");
        System.out.println("exit");
    }

    public static void afisareSelectii() {

        System.out.println("name");
        System.out.println("age");
        System.out.println("address");
        System.out.println("salary");
        System.out.println("exit");

    }
}
