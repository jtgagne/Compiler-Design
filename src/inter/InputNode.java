package inter;

import code_generation.AssemblyFile;
import lexer.Print;
import symbols.Type;

/**
 * Class used to create an InputNode to prompt user for data
 * Created by gagnej3 on 8/8/16.
 * Justin Gagne and Zack Farrer
 * Professor Assiter
 * Wentworth Institute of Technology
 * Compiler Design - Summer 2016
 */
public class InputNode extends Stmt {
    private Print mPrint;
    private PrintNode mPrompt;
    private Id mIdentifier;
    private Type mType;

    public InputNode(){

    }

    /**
     * Input node takes a prompt value (Print-Token) and a data type.
     * @param prompt the Print-Token
     * @param identifier the identifier the value is to be stored in
     */
    public InputNode(Print prompt, Id identifier){
        mPrint = prompt;
        mIdentifier = identifier;
        mType = mIdentifier.type;
        mPrompt = new PrintNode(mPrint);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void gen(int b, int a) {
        super.gen(b, a);
        emit(this.toAsmMain());
        AssemblyFile.addData(this.toAsmData());
        AssemblyFile.addToMain(this.toAsmMain());
    }

    /**
     * Generate the assembly code to be added to the main
     * @return the assembly code to complete the action
     */
    @Override
    public String toAsmMain() {
        return String.format("%s %s", mPrompt.toAsmMain(), genInputAsm());
    }

    @Override
    public String toAsmData() {
        return mPrompt.toAsmData();
    }

    /**
     * Generates the input ASM line based on the data type to be stored in
     * @return appropriate assembly code
     */
    private String genInputAsm(){
        switch (mType.lexeme){
            case "int":
                return String.format(
                        "\tli\t $v0, 5\t\t#System call to read in %s\n" +
                        "\tsyscall\n\n" +
                        "\tsw\t $v0, %s\t\t#Store the input in variable: '%s'\n",
                        mType.lexeme, mIdentifier.getName(), mIdentifier.getName());  //System call for reading int
            case "long":
                return String.format(
                        "\tli\t $v0, 5\t\t#System call to read in %s\n" +
                        "\tsyscall\n\n" +
                        "\tsw\t $v0, %s\t\t#Store the input in variable: '%s'\n",
                        mType.lexeme, mIdentifier.getName(), mIdentifier.getName());  //System call for reading int
            case "float":
                return String.format(
                        "\tli\t $v0, 6\t\t#System call to read in %s\n" +
                        "\tsyscall\n\n" +
                        "\ts.d\t $f0, %s\t\t#Store the input in variable: '%s'\n",
                        mType.lexeme, mIdentifier.getName(), mIdentifier.getName());  //System call for reading float
            case "double":
                return String.format(
                        "\tli\t $v0, 7\t\t#System call to read in %s\n" +
                        "\tsyscall\n\n" +
                        "\ts.d\t $f0, %s\t\t#Store the input in variable: '%s'\n",
                        mType.lexeme, mIdentifier.getName(), mIdentifier.getName());  //System call for reading double
            case "char":
                return String.format(
                        "\tli\t $v0, 12\t\t#System call to read in %s\n" +
                        "\tsyscall\n\n" +
                        "\tsb\t $v0, %s\t\t#Store the input in variable: '%s'\n",
                        mType.lexeme, mIdentifier.getName(), mIdentifier.getName()); //System call for reading char
            case "boolean":
                return String.format(
                        "\tli\t $v0, 8\t\t#System call to read in %s\n" +
                        "\tla\t $a0, %s\n" +
                        "\tli\t $a1, 6\t\t#Allow for up to 5 chars\n" +
                        "\tsyscall\n\n" +
                        "\tla\t $a0, %s\t\t#Store the input in variable: '%s'\n",
                        mType.lexeme, mIdentifier.getName(), mIdentifier.getName(), mIdentifier.getName());  //System call to read String.
        }
        return "TYPE ERROR: InputNode\n";
    }
}