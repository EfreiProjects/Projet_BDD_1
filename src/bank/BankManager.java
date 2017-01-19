package bank;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * A class that provides access to the bank database. Each object of
 * this class must create a dedicated connection to the database.
 * <p>
 * <b>Note: DO NOT alter this class's interface.</b>
 * 
 * @author Busca
 * 
 */
public class BankManager {

    // CLASS FIELDS
    //
    // example of a create table statement executed by createDB()
    private static final String CREATE_TABLE_DUMMY = "create table DUMMY (" + 
	    "ATT int, " + 
	    "primary key (ATT)" + 
	    ")";

    /**
     * Creates a new BankManager object. This creates a new connection to
     * the specified database.
     * 
     * @param url
     *            the url of the database to connect to
     * @param user
     *            the login name of the user
     * @param password
     *            his/her password
     */
    public BankManager(String url, String user, String password) throws SQLException {
    	// TODO Auto-generated method stub
    }

    /**
     * Creates the schema of the bank's database. This includes all the schema
     * elements: tables, triggers, views, etc. If the database already exists,
     * this method first deletes it using "drop" statements. The database is
     * empty after this method returns.
     * <p>
     * The method will execute a sequence of hard-coded statements, as shown 
     * above.
     * 
     * 
     * @throws SQLException
     *             if an SQL exception occurs
     */
    public void createDB() throws SQLException {
    	// TODO Auto-generated method stub
    }

    /**
     * Creates a new account with the specified number. This number uniquely 
     * identifies bank accounts.
     * 
     * @param number
     *            the number of the account
     * @return <code>true</code> if the method succeeds and <code>false</code>
     *         otherwise
     * @throws SQLException
     *             if an SQL exception occurs
     * 
     */
    public boolean createAccount(int number) throws SQLException {
    	// TODO Auto-generated method stub
    	return false;
    }

    /**
     * Returns the balance of the specified account.
     * 
     * @param number
     *            the number of the account
     * @return the balance of the account
     * @throws SQLException
     *             if an SQL exception occurs
     */
    public double getBalance(int number) throws SQLException {
    	// TODO Auto-generated method stub
    	return 0;
    }

    /**
     * Adds the specified amount to the specified account. A call to this method
     * performs a deposit if the amount is a positive value, and a withdrawal
     * otherwise. A debit operation without insufficient funds must be refused.
     * 
     * @param number
     *            the number of the account
     * @param amount
     *            the amount to add to the account's balance
     * @return the new balance of the account, or -1.0 if the withdrawal could
     *         not be performed
     * @throws SQLException
     *             if an SQL exception occurs
     */
    public double addBalance(int number, double amount) throws SQLException {
    	// TODO Auto-generated method stub
    	return 0;
    }

    /**
     * Transfers the specified amount between the specified accounts.
     * 
     * @param from
     *            the number of the debited account
     * @param to
     *            the number of the credited account
     * @param amount
     *            the amount to transfert
     * @return <code>true</code> if the method succeeds and <code>false</code>
     *         otherwise
     * @throws SQLException
     *             if an SQL exception occurs
     */
    public boolean transfer(int from, int to, double amount) throws SQLException {
    	// TODO Auto-generated method stub
    	return false;
    }

    /**
     * Returns the list of operations on the specified account in the specified
     * time interval.
     * 
     * @param number
     *            the number of the account
     * @param from
     *            start date/time (inclusive)
     * @param to
     *            end date/time (inclusive)
     * @return the list of operations on the account
     * @throws SQLException
     *             if an SQL exception occurs
     */
    public List<Operation> getOperations(int number, Date from, Date to) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

}

