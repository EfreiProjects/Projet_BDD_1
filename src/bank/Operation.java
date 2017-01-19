package bank;

import java.util.Date;

/**
 * The description of an account operation as used in the application interface.
 * <p>
 * <b>Note: DO NOT alter this class.</b>
 * 
 * @author Busca
 * 
 */
public class Operation {

    //
    // INSTANCE FIELDS
    //
    private int number; // the account's number
    private double amount; // the amount deposited/withdrawn
    private Date date; // the date/time of operation

    //
    // CONSTRUCTOR
    //
    public Operation(int n, double a, Date d) {
    	this.number = n;
    	this.amount = a;
    	this.date = d;
    }

    @Override
    public String toString() { return "Movement [number=" + number + ", amount=" + amount + ", date=" + date + "]"; }

    //
    // ACCESSORS
    //
    public int getNumber() { return number; }

    public double getAmount() { return amount; }

    public Date getDate() { return date; }

    //
    // IDENTITY
    //
    @Override
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + number;
		return result;
    }

    @Override
    public boolean equals(Object obj) {
		if (this == obj)
		    return true;
		if (obj == null)
		    return false;
		if (getClass() != obj.getClass())
		    return false;
		Operation other = (Operation) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
		    return false;
		if (date == null) {
		    if (other.date != null)
			return false;
		} else if (!date.equals(other.date))
		    return false;
		if (number != other.number)
		    return false;
		return true;
    }

}
