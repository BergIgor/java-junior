package com.acme.edu;

public abstract class State {
    private Printer printer;
    private static final String SEP = System.lineSeparator();

    public State(Printer printer){
        this.printer=printer;
    }

    public void log(char message) {
        flush();
        printer.print("char: " + message);
    }

    public void log(boolean message) {
        flush();
        printer.print("primitive: " + message);
    }

    public void log(int... setInt) {
        flush();
        int sumItems = 0;
        for(int item:setInt){
            sumItems += item;
        }
        printer.print(String.valueOf(sumItems));
    }

    protected Printer getPrinter() {
        return printer;
    }

    private String getMatrix(int[][] matrix) {
        flush();
        StringBuilder subString = new StringBuilder("");
        for(int[] array : matrix){
            subString.append( SEP + getOneDimensionArray(array));
        }
        return subString.toString();
    }

    private  String getOneDimensionArray(int[] array) {
        String subString = "";
        subString += "{";
        for(int i=0 ;i< array.length;i++) {
            if(i == 0) {
                subString += array[i];
            }
            else{
                subString += " " + array[i];
            }
            if(i != array.length-1) {
                subString += ",";
            }
        }
        subString += "}";
        return subString ;
    }


    public void log(String... args) {
        flush();
        StringBuilder outputString = new StringBuilder("");
        for(String subString: args) {
            outputString.append(subString);
            outputString.append(SEP);
        }
        printer.print(outputString.toString());
    }

    public void log(Object message) {
        flush();
        printer.print("reference: " + message.toString());
    }

    public abstract void flush();

    public void log(int[][][][] multiDimenArray) {
        flush();
        String subString = "";
        for(int[][][] threeDimenArray : multiDimenArray){
            subString += "{" ;
            for(int[][] twoDimenArray : threeDimenArray){
                subString += "{"  + "{" + getMatrix(twoDimenArray) + "}";
            }
            subString += "}"  ;
        }
        subString += "}";
        subString=subString.replace(SEP, "");
        subString=subString.replace("}", SEP + "}");
        subString=subString.replace("{", "{" + SEP);
        printer.print("primitives multimatrix: " + subString);
    }

    public abstract void checkBuffer(String message);

}
