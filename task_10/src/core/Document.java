package core;

import java.time.LocalDate;
// The document of a deal of a ledger.
// Constructed when calling Deal.addDoc().
// Methods -
// void setDate(String date)
// void setSum(int sum)
// void setType(DocType type)
// String getDate()
// int getSum()
// DocType getType()


public class Document {
    private final Deal parent;
    private String stringDate;
    private DocType type;
    private int sum;

    Document(Deal parent, String stringDate, DocType type, int sum){
        this.parent = parent;
        this.setDate(stringDate);
        this.setType(type);
        this.setSum(sum);
    }
    public void setDate(String date) throws IllegalArgumentException {
        if (!DealLedger.isDateCorrect(date)) throw new IllegalArgumentException(
                """
                        The date provided is incorrect.\s
                        It should be a number of YYYYMMDD format:\s
                        the YYYY year should be in range of 0001-9999,\s
                        the MM month should be in range of 01-12\s
                        and the DD day should be in range of 01-28-29-30-31 depending on the month."""
        );
        if (Integer.parseInt(parent.getDate()) > Integer.parseInt(date)) throw new IllegalArgumentException(
                """
                        The date provided is incorrect.\s
                        It should be no older than the date of the deal, as\s
                        one cannot make payments before beginning the deal."""
        );
        this.stringDate = date;
    }
    public void setSum(int sum) throws IllegalArgumentException {
        if (sum <= 0) throw new IllegalArgumentException("The payment entry is incorrect. \n" +
                "It should be more than zero - negative or zero payments are disallowed.");
        this.sum = sum;
    }
    public void setType(DocType type) {
        if (type == null) {throw new NullPointerException("You shouldn't see this error.\n +" +
                "You somehow have passed a wrong enumerator type.");}
        this.type = type;
    }

    public String getDate() {return stringDate;}
    public int getSum() {return sum;}
    public DocType getType() {return type;}
}
