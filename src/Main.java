import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();

        int flag = 0;
        char opc = ' ';
        String lastname;

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("WELCOME TO CRISBANK");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        if (persons.isEmpty()) {
            System.out.println("Eres nuestro primer cliente, realicemos tu registro");
            persons.add(registerPerson());
        }

        do {
            System.out.println("Do you have an Account?");
            opc = sn.next().charAt(0);
            sn.nextLine();
            switch (opc) {
                case 'y':
                    System.out.println("Whats ur lastname?");
                    lastname = sn.nextLine();

                    int opc2 = 0;
                    float amount= 0;
                    for (Person last : persons) {
                        if (lastname.equals(last.getApellido())) {
                            System.out.println("Hola " + last.getName());
                            System.out.println("NIP:");
                            int nipIngresado = sn.nextInt();
                            sn.nextLine();
                            if (nipIngresado != last.getPin()) {
                                System.out.println("NIP incorrecto");
                                break;
                            }
                            System.out.println("Que quieres realizar hoy?");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3.Exit");
                            opc2 = sn.nextInt();
                            switch (opc2){
                                case 1:
                                    System.out.println("For how much?");
                                    amount = sn.nextFloat();
                                    last.deposit(amount);
                                    System.out.println("LISTO, tu saldo ahora es de: " + last.getBalance());

                                    break;
                                case 2:
                                    System.out.println("For how much?");
                                    amount = sn.nextFloat();
                                    last.withdraw(amount);
                                    System.out.println("LISTO, tu saldo ahora es de: " + last.getBalance());

                                    break;
                                case 3:
                                    flag =1 ;
                                    break;
                            }
                        } else {
                            System.out.println("Wrong Lastname");
                            System.out.println("Try again");
                        }

                    }
                    break;
                case 'n':
                    persons.add(registerPerson());
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (flag == 0);

    }

    public static Person registerPerson() {
        Scanner sn = new Scanner(System.in);
        float saldoIni = 0;
        String name;
        String lastname;
        int nip;

        System.out.println("Whats ur name?");
        name = sn.nextLine();
        System.out.println("Whats ur lastname?");
        lastname = sn.nextLine();
        System.out.println("Whats ur Initial Balance?");
        saldoIni = sn.nextFloat();
        System.out.println("Type your NIP");
        nip = sn.nextInt();

        var person = new Person(name, lastname, saldoIni, nip);

        return person;
    }
}