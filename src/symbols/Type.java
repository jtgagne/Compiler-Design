package symbols;
import lexer.*;

import java.util.Hashtable;

/**
 * Class used for defining the reserved names of variable types
 * Created by Justin Gagne on 6/5/16.
 */
public class Type extends Word {
    public int width = 0;          // width is used for storage allocation

    @Override
    public boolean isType() {
        return true;
    }

    @Override
    public boolean isWord() {
        return false;
    }

    public Type(String s, int tag, int w)
    {
        super(s, tag);
        width = w;
    }

    //TODO: Maybe add tag values for each individual data type?
    // ********************************************************
    // Constants
    // **********************************************************
    public static final Type
            Void    = new Type( "void", Tag.NULL, 0),
            Int     = new Type( "int",   Tag.INT, 4 ),
            Long    = new Type( "long", Tag.LONG, 8),
            Float   = new Type( "float", Tag.FLOAT, 8 ),
            Double  = new Type( "double", Tag.DOUBLE, 16),
            Char    = new Type( "char",  Tag.CHAR, 1 ),
            Bool    = new Type( "boolean",  Tag.BOOL, 1 );


    /**
     * Call to reserve the various data types.
     * @param words the hashtable to be used by the lexer
     */
    public static void reserveTypes(Hashtable words){
        if(words == null){
            words = new Hashtable();
        }
        words.put(Int.lexeme, Int);
        words.put(Long.lexeme, Long);
        words.put(Float.lexeme, Float);
        words.put(Double.lexeme, Double);
        words.put(Char.lexeme, Char);
        words.put(Bool.lexeme, Bool);
    }

    // **********************************************************
    // Predicate to determine if numeric type
    // **********************************************************
    public static boolean numeric(Type p) {
        return p == Type.Char || p == Type.Int || p == Type.Float || p == Type.Double || p == Type.Long;
    }


    // **********************************************************
    // Numeric type precdence float >> int >> char
    // **********************************************************
    public static Type max(Type p1, Type p2 )
    {

        if ( p1 == Type.Double   || p2 == Type.Double   )
            return Type.Double;

        else if ( p1 == Type.Float || p2 == Type.Float )
            return Type.Float;

        else if ( p1 == Type.Long   || p2 == Type.Long   )
            return Type.Long;

        else if ( p1 == Type.Int   || p2 == Type.Int   )
            return Type.Int;

        else if(p1 == Type.Bool || p2 == Type.Bool){
            return Type.Int;
        }

        else
            return Type.Char;
    }

    @Override
    public String toString() {
        return "TYPE: Lexeme is " + lexeme + " tag is " + tag + " Width is " + width;
    }

    public static boolean isType(int tag){
        return tag == Tag.INT ||
                tag == Tag.LONG ||
                tag == Tag.FLOAT ||
                tag == Tag.DOUBLE ||
                tag == Tag.CHAR ||
                tag == Tag.BOOL;
    }
}

