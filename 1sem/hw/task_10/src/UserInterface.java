import core.*;

import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    DealLedger dealLedger;
    Deal selectedDeal;
    Document selectedDoc;
    String selectedDealId;
    String selectedDocId;

    UserInterface(Scanner scanner, DealLedger dealLedger) {
        System.out.println("Welcome to the Deal Management System!");
        this.scanner = scanner;
        this.dealLedger = dealLedger;
    }
    public void initiate() {
        addDealDialogue("firstTime");
    }
    private void commandSelection(String state) {
        switch (state) {
            case "dealLedgerLevel" -> {
                System.out.println("""
                                Options:
                                (0) Get the tree of deals and their documents
                                (1) Get the list of deals only
                                (2) Select a deal
                                (3) Add a deal
                                (4) Remove a deal
                                """);
                System.out.print("Enter the number of a command: ");
                String entry = scanner.next();
                switch (entry) {
                    case "0" -> getTheTreeDialogue("");
                    case "1" -> getDealListDialogue("");
                    case "2" -> selectDealDialogue();
                    case "3" -> addDealDialogue("");
                    case "4" -> removeDealDialogue();
                    default -> {
                        System.out.println("Wrong entry. Enter a single number.");
                        commandSelection("dealLedgerLevel");
                    }
                }
            }
            case "dealLevel" -> {
                printTheDealSummary(selectedDealId);
                System.out.print("""
                        Options:
                        (0) Get the list of documents
                        (1) Select a document
                        (2) Add a document
                        (3) Remove a document
                        (4) Get into the main menu
                        
                        """);
                System.out.print("Enter the number of a command: ");
                String entry = scanner.next();
                switch (entry) {
                    case "0" -> getDocsListDialogue("");
                    case "1" -> selectDocDialogue();
                    case "2" -> addDocDialogue();
                    case "3" -> removeDocDialogue();
                    case "4" -> commandSelection("dealLedgerLevel");
                    default -> {
                        System.out.println("Wrong entry. Enter a single number.");
                        commandSelection("dealLevel");
                    }
                }
            }
            case "documentLevel" -> {
                printTheDocSummary(selectedDocId);
                System.out.print("""
                        Options:
                        (0) Change the date
                        (1) Switch the type
                        (2) Change the payment amount
                        (3) Get into the deal menu
                        """);
                System.out.print("Enter the number of a command: ");
                String entry = scanner.next();
                switch (entry) {
                    case "0" -> setDocDateDialogue();
                    case "1" -> setDocTypeDialogue();
                    case "2" -> setDocSumDialogue();
                    case "3" -> commandSelection("dealLevel");
                    default -> {
                        System.out.println("Wrong entry. Enter a single number.");
                        commandSelection("documentLevel");
                    }
                }
            }
        }
    }
    private void addDealDialogue(String state) {
        if (Objects.equals(state, "firstTime")) System.out.println("""
                To begin, make the first deal by entering it's name,
                then specify it's date in YYYYMMDD format:
                YYYY - year, from 0001 to 9999
                MM - month, from 01 to 12
                DD - day, from 01 to 31 or a different day depending on the month.
                An example - ACME 19920620
                """);
        System.out.print("Enter the ID: ");
        String id = scanner.next();
        System.out.print("Enter the date in YYYYMMDD format: ");
        String stringDate = scanner.next();
        try {
            this.dealLedger.addDeal(id, stringDate);
            System.out.println("Success!");
            selectedDeal = dealLedger.getDeal(id);
            commandSelection("dealLedgerLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            if (Objects.equals(state, "firstTime")) addDealDialogue("exceptionRepeat");
            else commandSelection("dealLedgerLevel");
        }
    }
    private void setDocSumDialogue() {
        System.out.println("Keep in mind the payment entry should be more than 0! ");
        System.out.print("Enter the new payment entry, in cents: ");
        String sum = scanner.next();
        try {
            selectedDoc.setSum(Integer.parseInt(sum));
            System.out.println("Success! This payment entry is set.");
            commandSelection("documentLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("documentLevel");
        }
    }
    private void setDocTypeDialogue() {
        System.out.println("1 - bank warrant, 2 - payment order.");
        System.out.print("Enter the type number of the deal: ");
        String typeString = scanner.next();
        DocType type;
        switch (typeString) {
            case "1" -> type = DocType.ERRAND;
            case "2" -> type = DocType.ORDER;
            default -> {
                type = null;
                System.out.println("Wrong type number. Write either 1 or 2.");
                commandSelection("documentLevel");
            }
        }
        selectedDoc.setType(type);
        System.out.println("Success! This type of the deal is set.");
        commandSelection("documentLevel");
    }
    private void setDocDateDialogue() {
        System.out.println("Keep in mind the date should be no older than of the parent deal! ");
        System.out.print("Enter the new date of the document: ");
        String date = scanner.next();
        try {
            selectedDoc.setDate(date);
            System.out.println("Success! This date of the document is set.");
            commandSelection("documentLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("documentLevel");
        }
    }
    // Here rests quite a useless feature.
    //private void setDealDateDialogue() {
    //    System.out.println("Keep in mind the date should be no younger than the oldest document of the deal! ");
    //    System.out.print("Enter the new date of the deal: ");
    //    String date = scanner.next();
    //    try {
    //        selectedDeal.setDate(date);
    //        System.out.println("Success! This date of the deal is set.");
    //        commandSelection("dealLevel");
    //    }
    //    catch (Exception ex) {
    //        System.out.println(ex);
    //        commandSelection("dealLevel");
    //    }
    //}
    private void removeDocDialogue() {
        System.out.print("Enter the ID for the document deleted: ");
        String id = scanner.next();
        try {
            selectedDeal.removeDoc(id);
            System.out.println("Success! This document is gone.");
            commandSelection("dealLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("dealLevel");
        }
    }
    private void addDocDialogue() {
        System.out.print("Enter the arbitrary ID for the document: ");
        String id = scanner.next();
        System.out.print("Enter the date of the document: ");
        String date = scanner.next();
        System.out.println("Select the type of the document - write 1 if it's a bank warrant, or write 2 if it's a payment order.");
        System.out.print("Enter the number of type: ");
        String typeNumber = scanner.next();
        DocType type = null;
        if (Objects.equals(typeNumber, "1")) {type = DocType.ERRAND;}
        else if (Objects.equals(typeNumber, "2")) {type = DocType.ORDER;}
        else {
            System.out.println("Wrong type number - one should enter either 1 or 2 to specify the type.");
            commandSelection("dealLevel");
        }
        System.out.print("And finally, write the number - payment entry (in cents): ");
        int sum = Integer.parseInt(scanner.next());
        try {
            selectedDeal.addDoc(sum, id, type, date);
            System.out.println("Success! The document is added.");
            commandSelection("dealLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("dealLevel");
        }
    }
    private void selectDocDialogue() {
        System.out.print("Enter the ID of the document selected: ");
        String id = scanner.next();
        try {
            selectedDoc = selectedDeal.getDoc(id);
            selectedDocId = id;
            commandSelection("documentLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("dealLevel");
        }
    }
    private void removeDealDialogue() {
        System.out.print("Enter the ID of the deal deleted: ");
        String id = scanner.next();
        try {
            dealLedger.removeDeal(id);
            System.out.println("Success! This deal is gone.");
            commandSelection("dealLedgerLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("dealLedgerLevel");
        }
    }
    private void getDocsListDialogue(String state) {
        String[] ids = selectedDeal.getAllDocsID();
        if (ids.length == 0 && !Objects.equals(state, "withinTreeDialogue"))
            System.out.println("The list of documents is empty. Add a document.");
        else if (!Objects.equals(state, "withinTreeDialogue"))
            System.out.println("The list of documents:");
        for (String id : ids) {
            System.out.print("        ");
            printTheDocSummary(id);
        }
        if (!Objects.equals(state, "withinTreeDialogue")) commandSelection("dealLevel");
    }
    private void selectDealDialogue() {
        System.out.print("Enter the ID of the deal you want to work with: ");
        String entry = scanner.next();
        try {
            selectedDeal = dealLedger.getDeal(entry);
            selectedDealId = entry;
            commandSelection("dealLevel");
        }
        catch (Exception ex) {
            System.out.println(ex);
            commandSelection("dealLedgerLevel");
        }

    }
    private void getDealListDialogue(String state) {
        String[] ids = dealLedger.getAllDealsID();
        if (ids.length == 0) {System.out.println("The list of deals is empty. Add a deal.");}
        else if (!Objects.equals(state, "silent"))  System.out.println("The list of deals:");
        for (String id : ids) {
            selectedDeal = dealLedger.getDeal(id);
            String stringDate = selectedDeal.getDate();
            int[] date = splitDateString(stringDate);
            int dollars = selectedDeal.getDocsSum() / 100;
            int cents = selectedDeal.getDocsSum() % 100;
            System.out.println(
                    "    " +
                    "Deal: ID - " + id +
                    ", Date - " + date[0] + "-" + date[1] + "-" + date[2] +
                    ", Sum - " + dollars + "." + cents + " dollars");
        }
        commandSelection("dealLedgerLevel");
    }
    private void getTheTreeDialogue(String state) {
        String[] ids = dealLedger.getAllDealsID();
        if (!Objects.equals(state, "silent")) System.out.println("The list of deals and their documents:");
        for (String id : ids) {
            System.out.print("    "); // tabulation
            printTheDealSummary(id);
            selectedDealId = id;
            selectedDeal = dealLedger.getDeal(id);

            getDocsListDialogue("withinTreeDialogue");
        }
        commandSelection("dealLedgerLevel");
    }
    private int[] splitDateString(String stringDate) {
        char[] yearChar = new char[4];
        char[] monthChar = new char[2];
        char[] dayChar = new char[2];
        stringDate.getChars(0, 4, yearChar, 0);
        stringDate.getChars(4, 6, monthChar, 0);
        stringDate.getChars(6, 8, dayChar, 0);
        int year = Integer.parseInt(String.valueOf(yearChar));
        int month = Integer.parseInt(String.valueOf(monthChar));
        int day = Integer.parseInt(String.valueOf(dayChar));
        return new int[]{year, month, day};
    }
    private void printTheDealSummary(String id) {
        Deal deal = dealLedger.getDeal(id);
        String stringDate = deal.getDate();
        int[] date = splitDateString(stringDate);
        int dollars = deal.getDocsSum() / 100;
        int cents = deal.getDocsSum() % 100;
        System.out.print(
                "Deal: ID - " + id +
                        ", Date - " + date[0] + "-" + date[1] + "-" + date[2] +
                        ", Sum - " + dollars + "." + cents + " dollars.");
        System.out.print("\n");
    }
    private void printTheDocSummary(String id) {
        Document doc = dealLedger.getDeal(selectedDealId).getDoc(id);
        String type;
        switch (doc.getType()) {
            case ERRAND -> type = "bank warrant";
            case ORDER -> type = "payment order";
            default -> type = "ERROR";
        }
        String stringDate = doc.getDate();
        int[] date = splitDateString(stringDate);
        int dollars = doc.getSum() / 100;
        int cents = doc.getSum() % 100;
        System.out.print("Document: ID - " + id +
                ", Date - " + date[0] + "-" + date[1] + "-" + date[2] +
                ", Type - " + type +
                ", Sum - " + dollars + "." + cents + " dollars."
        );
        System.out.print("\n");
    }
    private void getAllDocsDialogue() {}
}
