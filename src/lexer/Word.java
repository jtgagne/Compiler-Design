package lexer;

import code_generation.ASMGen;
import symbols.Type;

import java.util.Hashtable;

/**
 * Declares all the reserved words to be used in 'Natural'. Provides a static method to add words to the lexer hashtable
 * Created on 6/5/16.
 * Justin Gagne and Zack Farrer
 * Professor Assiter
 * Wentworth Institute of Technology
 * Compiler Design - Summer 2016
 */
public class Word extends Token {
    public String lexeme = "";
    private String constantId;
    private String register;

    @Override
    public boolean isWord() {
        return true;
    }


    public Word(String s, int tag1) {
        super(tag1);
        lexeme = s;
    }

    public Word(String s, int tag1, int tag2) {
        super(tag1, tag2);
        lexeme = s;
    }

    @Override
    public String toAsmConstant() {
        return super.toAsmConstant();
    }

    @Override
    public String getRegister() {
        return register;
    }

    @Override
    public void setRegister(String register) {
        this.register = register;
    }

    @Override
    public void setConstantId(String constantId) {
        this.constantId = constantId;
    }

    @Override
    public String getConstantId() {
        return constantId;
    }

    @Override
    public String toString() {
        if(this.tag2 == Tag.NULL){
            return "WORD: Lexeme is \'" + lexeme + "\' and tag is " + tag;
        } else{
            return "WORD: Lexeme is " + lexeme + "   Tag1 is " + tag + "   Tag2 is " + tag2;
        }
    }

    public static final Word
        and 	= new Word( "&&", Tag.AND ),
        or  	= new Word( "||", Tag.OR ),
        eq  	= new Word( "==", Tag.EQ  ),
        ne 	    = new Word( "!=", Tag.NE ),
        le  	= new Word( "<=", Tag.LE  ),
        ge  	= new Word( ">=", Tag.GE ),
        assign  = new Word( ":=", Tag.ASSIGNMENT),
        True    = new Word( "true",  Tag.TRUE  ),
        temp    = new Word( "t",     Tag.TEMP  ),
        minus  = new Word( "minus", Tag.MINUS ),
        False   = new Word( "false", Tag.FALSE );


    //Words to be used by the Phrases:
    public static final Word
        andWord 	= new Word( "and", Tag.AND),
        orWord 	    = new Word( "or",  Tag.OR),                                 //This can be part of a _phrase such as "less than or equal to"
        equal 	    = new Word( "equal", Tag.EQ, Tag.INITIALIZER),
        equals      = new Word( "equals", Tag.EQ),                              //if(a equals b)
        to 	        = new Word( "to", Tag.TO, Tag.TERMINAL),                    //This can only occur at the end of a _phrase
        not         = new Word( "not", Tag.NOT, Tag.INITIALIZER),
        less        = new Word( "less", Tag.LESS, Tag.INITIALIZER),             //Initializer means that it must be the the start of a new _phrase to be valid
        than        = new Word( "than", Tag.THAN, Tag.TERMINAL),
        greater     = new Word( "greater", Tag.GREATER, Tag.INITIALIZER),
        is          = new Word( "is", Tag.ASSIGNMENT),
        increase    = new Word( "increase", Tag.INCREASE, Tag.INITIALIZER),
        decrease    = new Word( "decrease", Tag.DECREASE, Tag.INITIALIZER),
        by          = new Word( "by", Tag.NULL, Tag.TERMINAL),
        print       = new Word( "print", Tag.PRINT),
        input       = new Word( "input", Tag.INPUT),
        error       = new Word( "ERROR", Tag.ERROR);

    /**
     * Store the reserved words in a hash table
     * @param words : the Hash table to be used by the lexer
     */
    public static void reserveWords(Hashtable words){

        //Reserved words for control statements
        words.put("if", new Word("if", Tag.IF));
        words.put("else", new Word("else", Tag.ELSE));
        words.put("while", new Word("while", Tag.WHILE));
        words.put("do", new Word("do", Tag.DO));
        words.put("break", new Word("break", Tag.BREAK));
        words.put("for", new Word("for", Tag.FOR));

        //Add all the words defined in this class
        words.put(and.lexeme, and);
        words.put(or.lexeme, or);
        words.put(eq.lexeme, eq);
        words.put(ne.lexeme, ne);
        words.put(le.lexeme, le);
        words.put(ge.lexeme, ge);
        words.put(True.lexeme, True);
        words.put(False.lexeme, False);
        words.put(andWord.lexeme, andWord);
        words.put(orWord.lexeme, orWord);
        words.put(equal.lexeme, equal);
        words.put(equals.lexeme, equals);
        words.put(to.lexeme, to);
        words.put(not.lexeme, not);
        words.put(less.lexeme, less);
        words.put(than.lexeme, than);
        words.put(greater.lexeme, greater);
        words.put(is.lexeme, is);
        words.put(increase.lexeme, increase);
        words.put(decrease.lexeme, decrease);
        words.put(print.lexeme, print);
        words.put(input.lexeme, input);
        words.put(by.lexeme, by);
    }


}
