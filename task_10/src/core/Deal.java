package core;
import java.time.LocalDate;
import java.util.HashMap;
// Deal - an integral component of the deal ledger.
// The deal can be constructed by calling DealLedger.addDeal().
// Methods -
// void addDoc(int sum, String ID, DocType type, String Date)
// void removeDoc(String ID)
// String[] getAllDocsID()
// int getDocsSum()
// Document getDoc(String ID)
// void setDate(String Date)
// String getDate()

public class Deal {
    private HashMap<String, Document> children = new HashMap<String, Document>();
    private String stringDate;

    Deal(String date) {
        this.setDate(date);
    }

    public void setDate(String date) throws IllegalArgumentException {
        if (!DealLedger.isDateCorrect(date)) throw new IllegalArgumentException(
                "The date is incorrect. \n" +
                "It should be a number of YYYYMMDD format:\n" +
                "the YYYY year should be in range of 0001-9999,\n" +
                "the MM month should be in range of 01-12,\n" +
                "and the DD day should be in range of 01-28-29-30-31 depending on the month, \n" +
                "and the date of the deal should be no younger than the date of the oldest child document (if any)"
        );
        this.stringDate = date;
    }
    public void addDoc(int sum, String id, DocType type, String date) {
        Document doc = new Document(this, date, type, sum);
        if (id == null) {throw new NullPointerException();}
        if (children.containsKey(id)) {throw new IllegalArgumentException();}
        if (Integer.parseInt(date) < Integer.parseInt(this.stringDate)) {throw new IllegalArgumentException();}
        children.put(id, doc);
    }
    public void removeDoc(String id) {
        if (id == null) {throw new NullPointerException();}
        if (!children.containsKey(id)) {throw new IllegalArgumentException();}
        children.remove(id);

    }
    public String[] getAllDocsID() {
        return children.keySet().toArray(new String[0]);
    }
    public int getDocsSum() {
        int sum = 0;
        String[] idList = this.getAllDocsID();
        for (String s : idList) {
            sum += children.get(s).getSum();
        }
        return sum;
    }
    public Document getDoc(String id) {return children.get(id);}
    public String getDate() {return stringDate;}
}
