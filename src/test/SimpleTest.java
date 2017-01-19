package test;

import java.sql.SQLException;

import bank.BankManager;

/**
 * The squeleton of a simple test program for {@link BankManager}.
 * 
 * @author Busca
 * 
 */
public class SimpleTest {

    //
    // CONSTANTS
    //
    private static final int MAX_ACCOUNTS = 10;
    private static final int MAX_CUSTOMERS = 5;

    //
    // CLASS FIELDS
    //
    private static int testTotal = 0;
    private static int testOK = 0;

    //
    // HELPER CLASSES
    //
    /**
     * Emulates a customer performing bank operations.
     * 
     * @author Jean-Michel Busca
     * 
     */
    static class CustomerEmulator extends Thread {

	private BankManager manager;
	private String customer;

	/**
	 * Creates a new customer emulator with the specified name, using the
	 * specified BankManager object. Note: the BankManager object is
	 * dedicated to the customer (no two customers share the same
	 * BankManager object).
	 * 
	 * @param m
	 *            the BankManager objec that the customer uses to perform
	 *            bank operations.
	 * @param c
	 *            the name of the customer.
	 */
	public CustomerEmulator(BankManager m, String c) {
	    manager = m;
	    customer = c;
	}

	public String toString() {
	    return customer + "[" + manager + "]";
	}

	public void run() {
	    System.out.println(this + ": starting");

	    // TODO complete the test

	    System.out.println(this + ": exiting");
	}

    }

    //
    // HELPER METHODS
    //
    private static void check(String test, boolean ok) {
	testTotal += 1;
	System.out.print(test + ": ");
	if (ok) {
	    testOK += 1;
	    System.out.println("ok");
	} else {
	    System.out.println("FAILED");
	}
    }

    private static void singleUserTests(BankManager m, String c) throws SQLException {

	// TODO complete the test

	// test example: we assume account #1 has just been created; we
	// check that a 1 000 deposit on account #1 works as expected
	double b = m.addBalance(1, 1000.0);
	check("addBalance", b == 1000.0);

	// TODO complete the test

    }

    //
    // MAIN
    //
    public static void main(String[] args) {

	// check parameters
	if (args.length != 3) {
	    System.err.println("usage: SimpleTest <url> <user> <password>");
	    System.exit(-1);
	}

	try {
	    // create the BankManager object
	    BankManager manager = new BankManager(args[0], args[1], args[2]);

	    // create the database
	    manager.createDB();

	    // populate the database
	    for (int i = 0; i < MAX_ACCOUNTS; i++) {
		manager.createAccount(i + 1);
	    }

	    // execute single-user tests
	    singleUserTests(manager, "single-customer");

	    // execute multi-user tests
	    for (int i = 0; i < MAX_CUSTOMERS; i++) {
		BankManager m = new BankManager(args[0], args[1], args[2]);
		new CustomerEmulator(m, "multi-customer" + i).start();
	    }

	} catch (Exception e) {
	    System.err.println("test aborted: " + e);
	    e.printStackTrace();
	}

	// print test results
	if (testTotal == 0) {
	    System.out.println("no test performed");
	} else {
	    String r = "test results: ";
	    r += "total=" + testTotal;
	    r += ", ok=" + testOK + "(" + ((testOK * 100) / testTotal) + "%)";
	    System.out.println(r);
	}

    }
}
