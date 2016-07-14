package symbols;
import java.util.*; import lexer.*; import inter.*;

/**
 * Class used to store the variables of a natural program
 * Justin Gagne and Zack Farrer
 * Professor Assiter
 * Wentworth Institute of Technology
 * Compiler Design - Summer 2016
 */
public class Env {

	private Hashtable table;
	protected Env prev;

	public Env(Env n) {
		table = new Hashtable();
		prev = n;
		System.out.printf("New environment scope instantiated\n");
	}

	public void put(Token w, Id i) { table.put(w, i); }

	public Id get(Token w) {
		for( Env e = this; e != null; e = e.prev ) {
			Id found = (Id)(e.table.get(w));
			if( found != null ) return found;
		}
		return null;
	}
}
