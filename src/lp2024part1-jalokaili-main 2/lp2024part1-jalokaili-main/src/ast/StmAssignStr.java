public class StmAssignStr extends Stm {
    private final String copyVar;

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    private  String variableName;

    public StmAssignStr(String copyVar, String variableName) {
        this.copyVar = (copyVar);
        this.variableName = (variableName);
    }

    @Override
    public void compile() {
        // Emit the string data with a label
        emit("push "+copyVar);

        emit("load");
        emit("push "+variableName);
        emit("store");


    }
}