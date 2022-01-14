package core;
import java.time.LocalDate;
import java.util.HashMap;
// DealLedger - A general ledger of deals, which themselves contain documents.
// However, manipulations such as adding and removing documents to deals are done with deals.
// One can - make such a deal ledger through a constructor, create new deals in it,
// seek through this deal ledger for deals,
// remove deals from the ledger,
// get the list of all the deals with all their calculated sums,
// Methods -
// void addDeal(String ID, String Date)
// void removeDeal(String ID)
// Deal getDeal(String ID)
// String[] getAllDealsID()

public class DealLedger {
    private HashMap<String, Deal> children = new HashMap<String, Deal>();

    public DealLedger() {}

    public void addDeal(String id, String date) {
        Deal deal = new Deal(date);
        if (id == null) {throw new NullPointerException();}
        if (children.containsKey(id)) {throw new IllegalArgumentException();}
        children.put(id, deal);
    }
    public void removeDeal(String id) throws NullPointerException {
        if (children.get(id) == null) throw new NullPointerException();
        children.remove(id);
    }
    public Deal getDeal(String id) throws NullPointerException {
        if (children.get(id) == null) throw new NullPointerException();
        return children.get(id);

    }
    public String[] getAllDealsID() {
        return children.keySet().toArray(new String[0]);
    }
    protected static boolean isDateCorrect(String stringDate) {
        char[] yearChar = new char[4];
        char[] monthChar = new char[2];
        char[] dayChar = new char[2];
        stringDate.getChars(0, 4, yearChar, 0);
        stringDate.getChars(4, 6, monthChar, 0);
        stringDate.getChars(6, 8, dayChar, 0);
        int year = Integer.parseInt(String.valueOf(yearChar));
        int month = Integer.parseInt(String.valueOf(monthChar));
        int day = Integer.parseInt(String.valueOf(dayChar));

        try {
            LocalDate.of(year, month, day);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
}
