package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> accounts = new ArrayList<>();
        ArrayList<Integer> balance = new ArrayList<>();
        Human human = new Human();
        Bank bank = new Bank();
        Bankaccount bankaccount = new Bankaccount();
        mainmenu(human, bank, bankaccount, accounts, balance);
    }

    public static void mainmenu(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("---Menu---");
            System.out.println("1. Vytvořit osobu");
            System.out.println("2. Založit účet");
            System.out.println("3. Zrušit účet");
            System.out.println("4. Poslat peníze na jiný účet");
            System.out.println("5. Vybrat peníze z účtu");
            System.out.println("6. Přidat peníze na účet");
            System.out.println("7. Exit");
            int input = sc.nextInt();
            if (input == 1)
                createHuman(human, bank, bankaccount, accounts, balance);
            if (input == 2)
                createAccount(human, bank, bankaccount, accounts, balance);
            if (input == 3)
                removeAccount(human, bank, bankaccount, accounts, balance);
            if (input == 4)
                sendMoneytoanotheraccount(human, bank, bankaccount, accounts, balance);
            if (input == 5)
                withdrawMoneyfromaccount(human, bank, bankaccount, accounts, balance);
            if (input == 6)
                addMoneytoaccount(human, bank, bankaccount, accounts, balance);
            if (input == 7) {
                System.exit(0);
            }
        }
    }

    public static void createHuman(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Vytvořit osobu---");
        System.out.println("Zadejte křestní jméno:");
        human.setName(sc.nextLine());
        System.out.println("Zadejte přijmení:");
        human.setSurname(sc.nextLine());
        System.out.println("Zadejte datum narození");
        human.setDateofbirth(sc.nextLine());
        System.out.println("Zadejte rodné číslo");
        human.setIdnumber(sc.nextLine());
        System.out.println("---Člověk vytvořen---");
        System.out.println("Jméno:" + " " + human.getName());
        System.out.println("Přijmení:" + " " + human.getSurname());
        System.out.println("Datum narození:" + " " + human.getDateofbirth());
        System.out.println("Rodné číslo:" + " " + human.getIdnumber());
        human.setHumancreated(1);
        mainmenu(human, bank, bankaccount, accounts, balance);
    }

    public static void createAccount(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        if (human.getHumancreated() == 0) {
            System.out.println("---Není možné vytvořit účet protože neexistuje žádná osoba!---");
        } else {
            System.out.println("---Založení účtu---");
            System.out.println("Vyberte banku u které si chcete založit účet");
            System.out.println("1. ČSOB");
            System.out.println("2. Česká spořitelna");
            System.out.println("3. Komerční banka");
            System.out.println("4. Airbank");
            int input = sc.nextInt();
            createAccountnumber(bankaccount);
            bankaccount.setAccountexists(1);
            bankaccount.setAccountbalance(0);
            if (input == 1) {
                bankaccount.setAccountprefix("0300");
                System.out.println("-------------------------");
                System.out.println("Bankovní účet vytvořen!");
                bank.setBank("ČSOB");
                System.out.println("Banka" + " " + bank.getBank());
                System.out.println("Vlastník účtu:" + " " + human.getName() + " " + human.getSurname());
                System.out.println("Číslo účtu" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
                System.out.println("-------------------------");
                accounts.add(bank.getBank() + " " + "-" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
            }
            if (input == 2) {
                bankaccount.setAccountprefix("0800");
                System.out.println("-------------------------");
                System.out.println("Bankovní účet vytvořen!");
                bank.setBank("Česká spořitelna");
                System.out.println("Banka" + " " + bank.getBank());
                System.out.println("Vlastník účtu:" + " " + human.getName() + " " + human.getSurname());
                System.out.println("Číslo účtu" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
                System.out.println("-------------------------");
                accounts.add(bank.getBank() + " " + "-" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
            }

            if (input == 3) {
                bankaccount.setAccountprefix("0100");
                System.out.println("-------------------------");
                System.out.println("Bankovní účet vytvořen!");
                bank.setBank("Komerční banka");
                System.out.println("Banka" + " " + bank.getBank());
                System.out.println("Vlastník účtu:" + " " + human.getName() + " " + human.getSurname());
                System.out.println("Číslo účtu" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
                System.out.println("-------------------------");
                accounts.add(bank.getBank() + " " + "-" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
            }

            if (input == 4) {
                bankaccount.setAccountprefix("3030");
                System.out.println("-------------------------");
                System.out.println("Bankovní účet vytvořen!");
                bank.setBank("Airbank");
                System.out.println("Banka" + " " + bank.getBank());
                System.out.println("Vlastník účtu:" + " " + human.getName() + " " + human.getSurname());
                System.out.println("Číslo účtu" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
                System.out.println("-------------------------");
                accounts.add(bank.getBank() + " " + "-" + " " + bankaccount.getAccountnumber() + "/" + bankaccount.getAccountprefix());
            }
        }
        balance.add(0);
        mainmenu(human, bank, bankaccount, accounts, balance);
    }

    public static void createAccountnumber(Bankaccount bankaccount) {
        Random rand = new Random();
        int lowestnumber = 100000000;
        int heighestnumber = 999999999;
        int result = rand.nextInt(heighestnumber - lowestnumber) + lowestnumber;
        bankaccount.setAccountnumber(result);
    }

    public static void removeAccount(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        if (bankaccount.getAccountexists() == 0) {
            System.out.println("---Nelze smazat žádný účet protože žádný neexistuje---");
        } else {
            System.out.println("---Zvolte index účtu který chcete zrušit---");
            System.out.println(accounts);
            int input = sc.nextInt();
            System.out.println("---Účet" + " " + accounts.get(input) + " " + "byl zrušen!---");
            accounts.remove(input);
            System.out.println("Zbývající účty:" + accounts);
        }
        mainmenu(human, bank, bankaccount, accounts, balance);
    }

    public static void sendMoneytoanotheraccount(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        if (bankaccount.getAccountexists() == 0) {
            System.out.println("---Nelze poslat peníze na jiný účet když žádný neexistuje---");
        }
        if (bankaccount.getAccountexists() == 1) {
            System.out.println("---Zvolte index účtu z kterého chcete poslat peníze---");
            System.out.println(accounts);
            int input = sc.nextInt();
            System.out.println("-----------------");
            System.out.println(accounts.get(input));
            System.out.println("Zůstatek účtu:" + " " + balance.get(input) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("---Zvolte index účtu na který chcete poslat peníze---");
            int input2 = sc.nextInt();
            System.out.println("-----------------");
            System.out.println(accounts.get(input2));
            System.out.println("Zůstatek účtu:" + " " + balance.get(input2) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("---Zvolte částku kterou chcete převést na druhý účet---");
            int value = sc.nextInt();
            if (value > balance.get(input)) {
                System.out.println("---Nelze poslat tolik peněz protože zůstatek účtu by byl záporný---");
                sendMoneytoanotheraccount(human, bank, bankaccount, accounts, balance);
            }
            balance.set(input, balance.get(input) - value);
            balance.set(input2, balance.get(input2) + value);
            System.out.println("-----------------");
            System.out.println(accounts.get(input));
            System.out.println("Zůstatek účtu:" + " " + balance.get(input) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("-----------------");
            System.out.println(accounts.get(input2));
            System.out.println("Zůstatek účtu:" + " " + balance.get(input2) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("---Částka" + " " + value + " Kč" + " " + "byla převedena na druhý účet---");

        }
    }

    public static void withdrawMoneyfromaccount(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        if (bankaccount.getAccountexists() == 0) {
            System.out.println("---Nelze vybrat peníze z účtu protože žádný neexistuje---");
        } else {
            System.out.println("---Vyberte index účtu ze kterého si chcete vybrat peníze---");
            System.out.println(accounts);
            int index = sc.nextInt();
            System.out.println("------------------");
            System.out.println(accounts.get(index));
            System.out.println("Zůstatek účtu:" + " " + balance.get(index) + " " + "Kč");
            System.out.println("------------------");
            System.out.println("---Kolik peněz chcete vybrat z účtu?---");
            int value = sc.nextInt();
            if (bankaccount.getAccountbalance() - value < 0) {
                System.out.println("---Nelze vybrat tolik peněz protože zůstatek účtu by byl záporný---");
                withdrawMoneyfromaccount(human, bank, bankaccount, accounts, balance);
            } else {
                bankaccount.setAccountbalance(bankaccount.getAccountbalance() - value);
                balance.set(index, bankaccount.getAccountbalance());
                System.out.println("------------------");
                System.out.println(accounts.get(index));
                System.out.println("Zůstatek účtu:" + " " + balance.get(index) + " " + "Kč");
                System.out.println("------------------");
                System.out.println("---Bylo vybráno" + " " + value + " " + "Kč z vašeho účtu!---");
            }
        }
        mainmenu(human, bank, bankaccount, accounts, balance);
    }

    public static void addMoneytoaccount(Human human, Bank bank, Bankaccount bankaccount, ArrayList<String> accounts, ArrayList<Integer> balance) {
        Scanner sc = new Scanner(System.in);
        if (bankaccount.getAccountexists() == 0) {
            System.out.println("---Nelze vložit peníze na účet protože žádný neexistuje---");
        } else {
            System.out.println("---Vyberte index účtu na který chcete přidat peníze---");
            System.out.println(accounts);
            int index = sc.nextInt();
            System.out.println("------------------");
            System.out.println(accounts.get(index));
            System.out.println("Zůstatek účtu:" + " " + balance.get(index) + " " + "Kč");
            System.out.println("------------------");
            System.out.println("---Kolik peněz chcete na účet vložit?---");
            int value = sc.nextInt();
            bankaccount.setAccountbalance(value + bankaccount.getAccountbalance());
            balance.set(index, bankaccount.getAccountbalance());
            System.out.println("------------------");
            System.out.println(accounts.get(index));
            System.out.println("Zůstatek účtu:" + " " + balance.get(index) + " " + "Kč");
            System.out.println("------------------");
            System.out.println("---Bylo přidáno" + " " + value + " " + "Kč na váš účet!---");
        }
        mainmenu(human, bank, bankaccount, accounts, balance);
    }
}