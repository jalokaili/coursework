public class StmPrintStr extends Stm {
    private final String variableName;

    public StmPrintStr(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void compile() {
        // Emit code to print the string at the given variable's address
        for (char character : variableName.toCharArray()) {
            emit("push " + "'"+character+"'");       // Push the ASCII code of the character onto the stack
            emit("push 1");                 // Push the syscall number for printing a character onto the stack
            emit("sysc");                   // Execute the syscall
        }
    }
}