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
// Deal getDeal(String ID)
// Deal[] getAllDeals()


public class DealLedgerTests extends Assert {

}