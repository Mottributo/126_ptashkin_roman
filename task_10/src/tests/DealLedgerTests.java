package tests;

import org.junit.*;
import core.*;

// DealLedger - A general ledger of deals, which themselves contain documents.
// However, manipulations such as adding and removing documents to deals are done with deals.
// One can - make such a deal ledger through a constructor, create new deals in it,
// seek through this deal ledger for deals,
// remove deals from the ledger,
// get the list of all the deals with all their calculated sums,
// Methods -
// void addDeal(String ID, String Date)
// void removeDeal(String ID)
// Deal getDeal(String ID). The part of DealTests
// String[] getAllDealsID()


public class DealLedgerTests extends Assert {
    @Test
    public void createEmptyDealLedger_getAllDeals_LengthEqualsZero() {
        DealLedger dealLedger = new DealLedger();
        assertEquals(0, dealLedger.getAllDealsID().length());
    }
    @Test
    public void makeProperDealLedger_getDealSum() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("20", "20000101");
        dealLedger.getDeal("20").addDoc(100, "1", DocType.ERRAND, "20010101");
        dealLedger.getDeal("20").addDoc(20, "2", DocType.ORDER, "20010101");
        dealLedger.getDeal("20").addDoc(3, "3", DocType.ORDER, "20010101");
        assertEquals(123, dealLedger.getDeal("20").getDocsSum());
    }
    @Test
    public void makeProperDealLedger_getAllDealsID_forEach_getAllDocsID() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("20", "20000101");
        dealLedger.getDeal("20").addDoc(100, "2", DocType.ERRAND, "20010101");
        dealLedger.getDeal("20").addDoc(20, "1", DocType.ORDER, "20010101");
        dealLedger.getDeal("20").addDoc(3, "3", DocType.ORDER, "20010101");
        dealLedger.addDeal("30", "20010101");
        dealLedger.getDeal("30").addDoc(21, "1", DocType.ERRAND, "20201212");
        String[] dealIDs = {"20", "30"};
        String[] docIDs0 = {"2", "1", "3"};
        String[] docIDs1 = {"1"};
        assertArrayEquals(dealIDs, dealLedger.getAllDealsID());
        assertArrayEquals(docIDs0, dealLedger.getDeal(dealLedger.getAllDealsID()[0]).getAllDocsID());
        assertArrayEquals(docIDs1, dealLedger.getDeal(dealLedger.getAllDealsID()[1]).getAllDocsID());
    }
    @Test
    public void addDeal_getAllDeals_LengthEqualsOne_IsTheSameDeal() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        assertEquals(1, dealLedger.getAllDealsID().length());
        assertEquals("ABC888", dealLedger.getAllDealsID()[0]);
    }
    @Test
    public void removeDeal_LengthEqualsZero() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        dealLedger.removeDeal("ABC888");
        assertEquals(0, dealLedger.getAllDealsID().length());
    }
    @Test
    public void addDeals_removeDeals_getAllDeals_InTheOrderOfBeingAdded0() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        dealLedger.addDeal("SomethingRandom9", "20000101");
        dealLedger.addDeal("3dn3429d", "20000101");
        dealLedger.removeDeal("SomethingRandom9");
        String[] testList = {"ABC888", "3dn3429d"};
        assertArrayEquals(testList, dealLedger.getAllDealsID());
    }
    @Test
    public void addDeals_removeDeals_getAllDeals_InTheOrderOfBeingAdded1() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        dealLedger.addDeal("SomethingRandom9", "20000101");
        dealLedger.addDeal("3dn3429d", "20000101");
        dealLedger.removeDeal("SomethingRandom9");
        dealLedger.addDeal("Test","20201212");
        String[] testList = {"ABC888", "3dn3429d", "Test"};
        assertArrayEquals(testList, dealLedger.getAllDealsID());
    }
    @Test
    public void addDeal_getDealDate() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        assertEquals("20000101", dealLedger.getDeal("ABC888").getDate());
    }
    @Test
    public void addDeal_setDealDate() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        dealLedger.getDeal("ABC888").setDate("20010101");
        assertEquals("20000102", dealLedger.getDeal("ABC888").getDate());
    }


    // --------------------- DATE TESTS ----------------------.
    @Test(expected = Exception.class)
    public void addDealWithWrongDate0_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
    }
    @Test(expected = Exception.class)
    public void addDealWithEmptyDate_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "");
    }
    @Test(expected = Exception.class)
    public void addDealWithWrongDate1_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031232");
    }
    @Test(expected = Exception.class)
    public void addDealWithWrongDate3_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20030001");
    }
    @Test(expected = Exception.class)
    public void addDealWithWrongDate4_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20030100");
    }
    @Test(expected = Exception.class)
    public void addDealWithGibberInDate0_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "notANumber");
    }
    @Test(expected = Exception.class)
    public void addDealWithGibberInDate1_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "Some1202numbers9129mixedIn12");
    }
    @Test(expected = Exception.class)
    public void addDealWithDateLongerThanEight_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "1111223342000453452345239");
    }
    @Test(expected = Exception.class)
    public void addDealWithDateShorterThanEight_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "1984");
    }
    @Test(expected = Exception.class)
    public void addDealWithDateOfZeroLength_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "");
    }
    @Test(expected = Exception.class)
    public void changeDealDateToWrongOne_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20010101");
        dealLedger.getDeal("1").setDate("234ng9f4fion");
    }
    @Test(expected = Exception.class)
    public void addDocumentToDeal_WithDateLessThanOfTheDocument_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20201010");
        dealLedger.addDocument(500, "aidi", DocType.ERRAND, "20201009");
    }
    @Test(expected = Exception.class)
    public void addDeal_setDealDate_youngerThanTheOldestDocument_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("ABC888", "20000101");
        dealLedger.getDeal("ABC888").addDoc(678, "9", DocType.ERRAND, "20050101");
        dealLedger.getDeal("ABC888").addDoc(678, "9", DocType.ERRAND, "20041231");
        dealLedger.getDeal("ABC888").setDate("20050101");
    }
    // ---------------- THE END OF DATE TESTS -----------------

    // ---------------- EXCEPTIONS TESTS ----------------------
    @Test(expected = Exception.class)
    public void addDealWithExistingID_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        dealLedger.addDeal("1", "20031230");
    }
    @Test(expected = Exception.class)
    public void addDealWithEmptyID_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal(null, "20031230");
    }
    @Test(expected = Exception.class)
    public void removeDealByID_thatDoesNotExist_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        dealLedger.removeDeal("2");
    }
    @Test(expected = Exception.class)
    public void getDealByID_thatDoesNotExist_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        Deal test = dealLedger.getDealByID("2");
    }
    @Test(expected = Exception.class)
    public void addDoc_withTheExistingID_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        dealLedger.getDeal("1").addDoc(500, "2", DocType.ERRAND, "20031231");
        dealLedger.getDeal("1").addDoc(460, "2", DocType.ORDER, "20041231");
    }
    @Test(expected = Exception.class)
    public void addDoc_withTheNegativeSum_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        dealLedger.getDeal("1").addDoc(-1, "2", DocType.ERRAND, "20031231");
    }
    @Test(expected = Exception.class)
    public void addDoc_withTheZeroSum_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        dealLedger.getDeal("1").addDoc(0, "2", DocType.ERRAND, "20031231");
    }
    @Test(expected = Exception.class)
    public void addDoc_setDocDateOlderThanDealDate_raisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "20031230");
        dealLedger.getDeal("1").addDoc(1, "2", DocType.ERRAND, "20031231");
        dealLedger.getDeal("1").getDoc("2").setDate("20010101");
    }
    // -------------- THE END OF EXCEPTIONS TESTS -------------

    @Test
    public void addDeal_DocumentLengthIsZero() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "12121212");
        Deal deal = dealLedger.getDeal("1");
        assertEquals(0, deal.getAllDocsID().length());
    }
    @Test
    public void addDocument_DealReturnsDocument() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "12121212");
        Deal deal = dealLedger.getDeal("1");

        deal.addDoc(500, "A1", DocType.ERRAND, "20201212");
        assertEquals(1, deal.getAllDocsID().length());
        assertEquals("20201212", deal.getDoc("A1").getDate());
        assertEquals(500, deal.getDoc("A1").getSum());
        assertEquals(DocType.ERRAND, deal.getDoc("A1").getType());
    }
    @Test(expected = Exception.class)
    public void removeDocumentByID_thatDoesNotExist_RaisesException() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "12121212");
        Deal deal = dealLedger.getDeal("1");

        deal.removeDoc("2");
    }
    @Test
    public void MakeAProperDeal_returnAllIDInRaisingOrder_keeps() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("1", "12121212");
        Deal deal = dealLedger.getDeal("1");

        deal.addDoc(500, "A1", DocType.ERRAND, "20201212");
        deal.addDoc(400, "B2", DocType.ORDER, "20201213");
        deal.addDoc(200, "C3", DocType.ORDER, "20201214");
        deal.addDoc(560, "D4", DocType.ERRAND, "20201215");
        String[] test = {"A1", "B2", "C3", "D4"};
        assertArrayEquals(test, deal.getAllDocsID());
    }
    @Test
    public void addDocument_setNewSumTypeDate_getSumTypeDate() {
        DealLedger dealLedger = new DealLedger();
        dealLedger.addDeal("20", "20000101");
        dealLedger.getDeal("20").addDoc(100, "2", DocType.ERRAND, "20010101");
        Document test = dealLedger.getDeal("20").getDoc("2");
        test.setSum(200);
        test.setType(DocType.ORDER);
        test.setDate("99991212");
        assertEquals(200, test.getSum());
        assertEquals(DocType.ORDER, test.getType());
        assertEquals("99991212", test.getDate());
    }
}