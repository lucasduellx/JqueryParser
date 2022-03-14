import java.io.*;
import java.util.*; 

public class App {

    public static Map<String, List<Integer>> findOperators() throws Exception{
        Map<String, List<Integer>> operators = new HashMap<String, List<Integer>>(); 
        InputStream input = new FileInputStream("jquery3.txt");
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        br.close();
        reader.close();
        input.close();
        Boolean stringMode = false;

        List<Integer> addition = new LinkedList<Integer>(); // + OK
        List<Integer> subtraction = new LinkedList<Integer>(); // - OK
        List<Integer> multiplication = new LinkedList<Integer>(); // * OK
        List<Integer> exponentiation = new LinkedList<Integer>(); // ** OK
        List<Integer> division = new LinkedList<Integer>(); // / OK
        List<Integer> modulus  = new LinkedList<Integer>(); // % OK
        List<Integer> increment = new LinkedList<Integer>(); // ++ OK
        List<Integer> decrement = new LinkedList<Integer>(); // -- OK

        List<Integer> additionAssignment = new LinkedList<Integer>(); // += OK
        List<Integer> subtractionAssignment = new LinkedList<Integer>(); // -= OK
        List<Integer> multiplicationAssignment = new LinkedList<Integer>(); // *= OK
        List<Integer> exponentiationAssignment = new LinkedList<Integer>(); // **= OK
        List<Integer> divisionAssignment = new LinkedList<Integer>(); // /= OK
        List<Integer> modulusAssignment  = new LinkedList<Integer>(); // %= OK
        List<Integer> equal = new LinkedList<Integer>(); // = OK

        List<Integer> equal_to = new LinkedList<Integer>(); // == OK
        List<Integer> equal_equal = new LinkedList<Integer>(); // ===  OK
        List<Integer> not_equal = new LinkedList<Integer>(); // != OK
        List<Integer> not_equal_equal = new LinkedList<Integer>(); // !==  OK
        List<Integer> greater_than = new LinkedList<Integer>(); // > OK
        List<Integer> less_than = new LinkedList<Integer>(); // < OK
        List<Integer> greater_than_equal = new LinkedList<Integer>(); // >=  OK
        List<Integer> less_than_equal = new LinkedList<Integer>(); // <= OK
        List<Integer> ternary = new LinkedList<Integer>(); // ? OK

        List<Integer> logical_and = new LinkedList<Integer>(); // && OK
        List<Integer> logical_or = new LinkedList<Integer>(); // || OK
        List<Integer> logical_not = new LinkedList<Integer>(); // ! OK

        List<Integer> type_of = new LinkedList<Integer>(); // typeof OK
        List<Integer> instance_of = new LinkedList<Integer>(); // instanceof OK

        List<Integer> and = new LinkedList<Integer>(); // & OK
        List<Integer> or = new LinkedList<Integer>(); // | OK
        List<Integer> not = new LinkedList<Integer>(); // ~ OK
        List<Integer> xor = new LinkedList<Integer>(); // ^ OK
        List<Integer> left_shift = new LinkedList<Integer>(); // << OK
        List<Integer> right_shift = new LinkedList<Integer>(); // >> OK
        List<Integer> un_right_shift = new LinkedList<Integer>(); // >>> OK

        for (int i = 0; i < linha.length(); i++) {
            if(stringMode && linha.charAt(i)== '"') stringMode= false;
            else if(linha.charAt(i)== '"') stringMode = true;
            if(!stringMode){
                if(linha.charAt(i) == '+') {
                    if(linha.charAt(i+1) == '+'){
                        increment.add(i);
                        i+=1;
                    }
                    else if(linha.charAt(i+1) == '='){
                        additionAssignment.add(i);
                        i+=1;
                    }
                    else{
                        addition.add(i);
                    }
                }
                else if(linha.charAt(i) == '-') {
                    if(linha.charAt(i+1) == '-'){
                        decrement.add(i);
                        i+=1;
                    }
                    else if(linha.charAt(i+1) == '='){
                        subtractionAssignment.add(i);
                        i+=1;
                    }
                    else{
                        subtraction.add(i);
                    }
                }
                else if(linha.charAt(i) == '*'){
                    if(linha.charAt(i+1) == '*' && linha.charAt(i+2) == '='){
                        exponentiationAssignment.add(i);
                        i+=2;
                    }
                    else if(linha.charAt(i+1) == '='){
                        multiplicationAssignment.add(i);
                        i+=1;
                    }
                    else if(linha.charAt(i+1) == '*'){
                        exponentiation.add(i);
                        i+=1;
                    }
                    else{
                        multiplication.add(i);
                    }
                }
                else if(linha.charAt(i) == '/'){
                    if(linha.charAt(i+1) == '='){
                        divisionAssignment.add(i);
                        i+=1;
                    }
                    else{
                        division.add(i);
                    }
                }
                else if(linha.charAt(i) == '%'){
                    if(linha.charAt(i+1) == '='){
                        modulusAssignment.add(i);
                        i+=1;
                    }
                    else{
                        modulus.add(i);
                    }
                }
                else if(linha.charAt(i) == '!'){
                    if(linha.charAt(i+1) == '=' && linha.charAt(i+2) == '='){
                        not_equal_equal.add(i);
                        i+=2;
                    }
                    else if(linha.charAt(i+1) == '='){
                        not_equal.add(i);
                        i+=1;
                    }
                }
                else if(linha.charAt(i) == '>'){
                    if(linha.charAt(i+1) == '='){
                        greater_than_equal.add(i);
                        i+=1;
                    }
                    else if(linha.charAt(i+1) == '>' && linha.charAt(i+2) == '>'){
                        un_right_shift.add(i);
                        i+=2;
                    }
                    else if(linha.charAt(i+1) == '>'){
                        right_shift.add(i);
                        i+=1;
                    }
                    else{
                        greater_than.add(i);
                    }
                }
                else if(linha.charAt(i) == '<'){
                    if(linha.charAt(i+1) == '='){
                        less_than_equal.add(i);
                        i+=1;
                    }
                    else if(linha.charAt(i+1) == '<'){
                        left_shift.add(i);
                        i+=1;
                    }
                    else{
                        less_than.add(i);
                    }
                }
                else if(linha.charAt(i) == '='){
                    if(linha.charAt(i+1) == '=' && linha.charAt(i+2) == '=' ){
                        equal_equal.add(i);
                        i+=2;
                    }
                    else if(linha.charAt(i+1) == '='){
                        equal_to.add(i);
                        i+=1;
                    }
                    else{
                        equal.add(i);
                    }
                }
                else if(linha.charAt(i) == '?'){
                    ternary.add(i);
                }
                else if(linha.charAt(i) == '&'){
                    if(linha.charAt(i+1) == '&'){
                        logical_and.add(i);
                        i+=1;
                    }
                    else{
                        and.add(i);
                    }
                }
                else if(linha.charAt(i) == '|'){
                    if(linha.charAt(i+1) == '|'){
                        logical_or.add(i);
                        i+=1;
                    }
                    else{
                        or.add(i);
                    }
                }
                else if(linha.charAt(i) == '!'){
                    logical_not.add(i);
                }
                else if(linha.charAt(i) == '~'){
                    not.add(i);
                }
                else if(linha.charAt(i) == '^'){
                    xor.add(i);
                }
                else if(linha.charAt(i) == 't'){
                        int aux = linha.indexOf("typeof",i);
                        if(aux != -1){
                            if(!type_of.contains(aux)){
                                type_of.add(aux);
                            }
                        }
                }
                else if(linha.charAt(i) == 'i'){
                    int aux = linha.indexOf("instanceof",i);
                    if(aux != -1){
                        if(!type_of.contains(aux)){
                            type_of.add(aux);
                        }
                    }
                }
            }
        }
        operators.put("+", addition);
        operators.put("-", subtraction);
        operators.put("*", multiplication);
        operators.put("**", exponentiation);
        operators.put("/", division);
        operators.put("%", modulus);
        operators.put("++", increment);
        operators.put("--", decrement);
        operators.put("+=", additionAssignment);
        operators.put("-=", subtractionAssignment);
        operators.put("*=", multiplicationAssignment);
        operators.put("**=", exponentiationAssignment);
        operators.put("/=", divisionAssignment);
        operators.put("%=", modulusAssignment);
        operators.put("=", equal);
        operators.put("==", equal_to);
        operators.put("===", equal_equal);
        operators.put("!=", not_equal);
        operators.put("!==", not_equal_equal);
        operators.put(">", greater_than);
        operators.put("<", less_than);
        operators.put(">=", greater_than_equal);
        operators.put("<=", less_than_equal);
        operators.put("?", ternary);
        operators.put("&&", logical_and);
        operators.put("||", logical_or);
        operators.put("!", logical_not);
        operators.put("typeof", type_of);
        operators.put("instanceof", instance_of);
        operators.put("&", and);
        operators.put("|", or);
        operators.put("~", not);
        operators.put("^", xor);
        operators.put("<<", left_shift);
        operators.put(">>", right_shift);
        operators.put(">>>", un_right_shift);
        return operators;
    }

    public static Map<String, List<Integer>> findBrackets() throws Exception{
        Map<String, List<Integer>> brackets = new HashMap<String, List<Integer>>(); 
        InputStream input = new FileInputStream("jquery3.txt");
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        br.close();
        reader.close();
        input.close();
        Boolean stringMode = false;
        List<Integer> bracketsOpen = new LinkedList<Integer>();
        List<Integer> bracketsClose = new LinkedList<Integer>();
        List<Integer> keyOpen = new LinkedList<Integer>();
        List<Integer> keyClose = new LinkedList<Integer>();
        List<Integer> pv = new LinkedList<Integer>();
        List<Integer> squareOpen = new LinkedList<Integer>();
        List<Integer> squareClose = new LinkedList<Integer>();

        for (int i = 0; i < linha.length(); i++) {
            if(stringMode && linha.charAt(i)== '"') stringMode= false;
            else if(linha.charAt(i)== '"') stringMode = true;
            if(!stringMode){
                if(linha.charAt(i) == '(') bracketsOpen.add(i);
                else if(linha.charAt(i) == ')') bracketsClose.add(i);
                else if(linha.charAt(i) == '{') keyOpen.add(i);
                else if(linha.charAt(i) == '}') keyClose.add(i);
                else if(linha.charAt(i) == ';') pv.add(i);
                else if(linha.charAt(i) == '[') squareOpen.add(i);
                else if(linha.charAt(i) == ']') squareClose.add(i);
            }
        }
        brackets.put("(", bracketsOpen);
        brackets.put(")", bracketsClose);
        brackets.put("[", squareOpen);
        brackets.put("]", squareClose);
        brackets.put("{", keyOpen);
        brackets.put("}", keyClose);
        brackets.put(";", pv);
        return brackets;
    }

    public static Map<String, List<Integer>> findReservedWord() throws Exception{
        Map<String, List<Integer>> reservedWords = new HashMap<String, List<Integer>>();
        List<String> reservedWordsList = Arrays.asList(
            "abstract",
            "arguments",
            "await",
            "boolean",
            "break",
            "byte",
            "case",
            "catch",
            "char",
            "class",
            "const",
            "continue",
            "debugger",
            "default",
            "delete",
            "do",
            "double",
            "else",
            "enum",
            "eval",
            "export",
            "extends",
            "false",
            "final",
            "finally",
            "float",
            "for",
            "function",
            "goto",
            "if",
            "implements",
            "import",
            "in",
            "instanceof",
            "int",
            "interface",
            "let",
            "long",
            "native",
            "new",
            "null",
            "package",
            "private",
            "protected",
            "public",
            "return",
            "short",
            "static",
            "super",
            "switch",
            "synchronized",
            "this",
            "throw",
            "throws",
            "transient",
            "true",
            "try",
            "typeof",
            "var",
            "void",
            "volatile",
            "while",
            "with",
            "yield"
        );  
        InputStream input = new FileInputStream("jquery3.txt");
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        br.close();
        reader.close();
        input.close();
        Boolean stringMode = false;
        
        for (String string : reservedWordsList) {
            reservedWords.put(string, new ArrayList<Integer>());
        }
        for (int i = 0; i < linha.length(); i++) {
            if(stringMode && linha.charAt(i)== '"') stringMode= false;
            else if(linha.charAt(i)== '"') stringMode = true;
            if(!stringMode){
                if(linha.charAt(i) == 'a'){
                    int aux = linha.indexOf("abstract",i);
                    if(aux != -1){
                        if(!reservedWords.get("abstract").contains(aux)){
                            reservedWords.get("abstract").add(aux);
                        }
                    }
                    aux = linha.indexOf("arguments", i);
                    if(aux != -1){
                        if(!reservedWords.get("arguments").contains(aux)){
                            reservedWords.get("arguments").add(aux);
                        }
                    }
                    aux = linha.indexOf("await", i);
                    if(aux != -1){
                        if(!reservedWords.get("await").contains(aux)){
                            reservedWords.get("await").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'b'){
                    int aux = linha.indexOf("boolean",i);
                    if(aux != -1){
                        if(!reservedWords.get("boolean").contains(aux)){
                            reservedWords.get("boolean").add(aux);
                        }
                    }
                    aux = linha.indexOf("break", i);
                    if(aux != -1){
                        if(!reservedWords.get("break").contains(aux)){
                            reservedWords.get("break").add(aux);
                        }
                    }
                    aux = linha.indexOf("byte", i);
                    if(aux != -1){
                        if(!reservedWords.get("byte").contains(aux)){
                            reservedWords.get("byte").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'c'){
                    int aux = linha.indexOf("case",i);
                    if(aux != -1){
                        if(!reservedWords.get("case").contains(aux)){
                            reservedWords.get("case").add(aux);
                        }
                    }
                    aux = linha.indexOf("catch", i);
                    if(aux != -1){
                        if(!reservedWords.get("catch").contains(aux)){
                            reservedWords.get("catch").add(aux);
                        }
                    }
                    aux = linha.indexOf("char", i);
                    if(aux != -1){
                        if(!reservedWords.get("char").contains(aux)){
                            reservedWords.get("char").add(aux);
                        }
                    }
                    aux = linha.indexOf("class", i);
                    if(aux != -1){
                        if(!reservedWords.get("class").contains(aux)){
                            reservedWords.get("class").add(aux);
                        }
                    }
                    aux = linha.indexOf("const", i);
                    if(aux != -1){
                        if(!reservedWords.get("const").contains(aux)){
                            reservedWords.get("const").add(aux);
                        }
                    }
                    aux = linha.indexOf("continue", i);
                    if(aux != -1){
                        if(!reservedWords.get("continue").contains(aux)){
                            reservedWords.get("continue").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'd'){
                    int aux = linha.indexOf("debugger",i);
                    if(aux != -1){
                        if(!reservedWords.get("debugger").contains(aux)){
                            reservedWords.get("debugger").add(aux);
                        }
                    }
                    aux = linha.indexOf("default", i);
                    if(aux != -1){
                        if(!reservedWords.get("default").contains(aux)){
                            reservedWords.get("default").add(aux);
                        }
                    }
                    aux = linha.indexOf("delete", i);
                    if(aux != -1){
                        if(!reservedWords.get("delete").contains(aux)){
                            reservedWords.get("delete").add(aux);
                        }
                    }
                    aux = linha.indexOf("do{", i);
                    if(aux != -1){
                        if(!reservedWords.get("do").contains(aux)){
                            reservedWords.get("do").add(aux);
                        }
                    }
                    aux = linha.indexOf("double", i);
                    if(aux != -1){
                        if(!reservedWords.get("double").contains(aux)){
                            reservedWords.get("double").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'e'){
                    int aux = linha.indexOf("else",i);
                    if(aux != -1){
                        if(!reservedWords.get("else").contains(aux)){
                            reservedWords.get("else").add(aux);
                        }
                    }
                    aux = linha.indexOf("enum", i);
                    if(aux != -1){
                        if(!reservedWords.get("enum").contains(aux)){
                            reservedWords.get("enum").add(aux);
                        }
                    }
                    aux = linha.indexOf("eval", i);
                    if(aux != -1){
                        if(!reservedWords.get("eval").contains(aux)){
                            reservedWords.get("eval").add(aux);
                        }
                    }
                    aux = linha.indexOf("export", i);
                    if(aux != -1){
                        if(!reservedWords.get("export").contains(aux)){
                            reservedWords.get("export").add(aux);
                        }
                    }
                    aux = linha.indexOf("extends", i);
                    if(aux != -1){
                        if(!reservedWords.get("extends").contains(aux)){
                            reservedWords.get("extends").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'f'){
                    int aux = linha.indexOf("false",i);
                    if(aux != -1){
                        if(!reservedWords.get("false").contains(aux)){
                            reservedWords.get("false").add(aux);
                        }
                    }
                    aux = linha.indexOf("final", i);
                    if(aux != -1){
                        if(!reservedWords.get("final").contains(aux)){
                            reservedWords.get("final").add(aux);
                        }
                    }
                    aux = linha.indexOf("finally", i);
                    if(aux != -1){
                        if(!reservedWords.get("finally").contains(aux)){
                            reservedWords.get("finally").add(aux);
                        }
                    }
                    aux = linha.indexOf("float", i);
                    if(aux != -1){
                        if(!reservedWords.get("float").contains(aux)){
                            reservedWords.get("float").add(aux);
                        }
                    }
                    aux = linha.indexOf("function", i);
                    if(aux != -1){
                        if(!reservedWords.get("function").contains(aux)){
                            reservedWords.get("function").add(aux);
                        }
                    }
                    aux = linha.indexOf("for", i);
                    if(aux != -1){
                        if(!reservedWords.get("for").contains(aux)){
                            reservedWords.get("for").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'g'){
                    int aux = linha.indexOf("goto",i);
                    if(aux != -1){
                        if(!reservedWords.get("goto").contains(aux)){
                            reservedWords.get("goto").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'i'){
                    int aux = linha.indexOf("if",i);
                    if(aux != -1){
                        if(!reservedWords.get("if").contains(aux)){
                            reservedWords.get("if").add(aux);
                        }
                    }
                    aux = linha.indexOf("implements", i);
                    if(aux != -1){
                        if(!reservedWords.get("implements").contains(aux)){
                            reservedWords.get("implements").add(aux);
                        }
                    }
                    aux = linha.indexOf("import", i);
                    if(aux != -1){
                        if(!reservedWords.get("import").contains(aux)){
                            reservedWords.get("import").add(aux);
                        }
                    }
                    aux = linha.indexOf("in", i);
                    if(aux != -1){
                        if(!reservedWords.get("in").contains(aux)){
                            reservedWords.get("in").add(aux);
                        }
                    }
                    aux = linha.indexOf("instanceof", i);
                    if(aux != -1){
                        if(!reservedWords.get("instanceof").contains(aux)){
                            reservedWords.get("instanceof").add(aux);
                        }
                    }
                    aux = linha.indexOf("int", i);
                    if(aux != -1){
                        if(!reservedWords.get("int").contains(aux)){
                            reservedWords.get("int").add(aux);
                        }
                    }
                    aux = linha.indexOf("interface", i);
                    if(aux != -1){
                        if(!reservedWords.get("interface").contains(aux)){
                            reservedWords.get("interface").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'l'){
                    int aux = linha.indexOf("let",i);
                    if(aux != -1){
                        if(!reservedWords.get("let").contains(aux)){
                            reservedWords.get("let").add(aux);
                        }
                    }
                    aux = linha.indexOf("long",i);
                    if(aux != -1){
                        if(!reservedWords.get("long").contains(aux)){
                            reservedWords.get("long").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'n'){
                    int aux = linha.indexOf("native",i);
                    if(aux != -1){
                        if(!reservedWords.get("native").contains(aux)){
                            reservedWords.get("native").add(aux);
                        }
                    }
                    aux = linha.indexOf("new",i);
                    if(aux != -1){
                        if(!reservedWords.get("new").contains(aux)){
                            reservedWords.get("new").add(aux);
                        }
                    }
                    aux = linha.indexOf("null",i);
                    if(aux != -1){
                        if(!reservedWords.get("null").contains(aux)){
                            reservedWords.get("null").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'p'){
                    int aux = linha.indexOf("package",i);
                    if(aux != -1){
                        if(!reservedWords.get("package").contains(aux)){
                            reservedWords.get("package").add(aux);
                        }
                    }
                    aux = linha.indexOf("private",i);
                    if(aux != -1){
                        if(!reservedWords.get("private").contains(aux)){
                            reservedWords.get("private").add(aux);
                        }
                    }
                    aux = linha.indexOf("protected",i);
                    if(aux != -1){
                        if(!reservedWords.get("protected").contains(aux)){
                            reservedWords.get("protected").add(aux);
                        }
                    }
                    aux = linha.indexOf("public",i);
                    if(aux != -1){
                        if(!reservedWords.get("public").contains(aux)){
                            reservedWords.get("public").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'r'){
                    int aux = linha.indexOf("return",i);
                    if(aux != -1){
                        if(!reservedWords.get("return").contains(aux)){
                            reservedWords.get("return").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 's'){
                    int aux = linha.indexOf("short",i);
                    if(aux != -1){
                        if(!reservedWords.get("short").contains(aux)){
                            reservedWords.get("short").add(aux);
                        }
                    }
                    aux = linha.indexOf("static",i);
                    if(aux != -1){
                        if(!reservedWords.get("static").contains(aux)){
                            reservedWords.get("static").add(aux);
                        }
                    }
                    aux = linha.indexOf("super",i);
                    if(aux != -1){
                        if(!reservedWords.get("super").contains(aux)){
                            reservedWords.get("super").add(aux);
                        }
                    }
                    aux = linha.indexOf("switch",i);
                    if(aux != -1){
                        if(!reservedWords.get("switch").contains(aux)){
                            reservedWords.get("switch").add(aux);
                        }
                    }
                    aux = linha.indexOf("synchronized",i);
                    if(aux != -1){
                        if(!reservedWords.get("synchronized").contains(aux)){
                            reservedWords.get("synchronized").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 't'){
                    int aux = linha.indexOf("this",i);
                    if(aux != -1){
                        if(!reservedWords.get("this").contains(aux)){
                            reservedWords.get("this").add(aux);
                        }
                    }
                    aux = linha.indexOf("throw",i);
                    if(aux != -1){
                        if(!reservedWords.get("throw").contains(aux)){
                            reservedWords.get("throw").add(aux);
                        }
                    }
                    aux = linha.indexOf("throws",i);
                    if(aux != -1){
                        if(!reservedWords.get("throws").contains(aux)){
                            reservedWords.get("throws").add(aux);
                        }
                    }
                    aux = linha.indexOf("transient",i);
                    if(aux != -1){
                        if(!reservedWords.get("transient").contains(aux)){
                            reservedWords.get("transient").add(aux);
                        }
                    }
                    aux = linha.indexOf("true",i);
                    if(aux != -1){
                        if(!reservedWords.get("true").contains(aux)){
                            reservedWords.get("true").add(aux);
                        }
                    }
                    aux = linha.indexOf("try",i);
                    if(aux != -1){
                        if(!reservedWords.get("try").contains(aux)){
                            reservedWords.get("try").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'v'){
                    int aux = linha.indexOf("var",i);
                    if(aux != -1){
                        if(!reservedWords.get("var").contains(aux)){
                            reservedWords.get("var").add(aux);
                        }
                    }
                    aux = linha.indexOf("void",i);
                    if(aux != -1){
                        if(!reservedWords.get("void").contains(aux)){
                            reservedWords.get("void").add(aux);
                        }
                    }
                    aux = linha.indexOf("volatile",i);
                    if(aux != -1){
                        if(!reservedWords.get("volatile").contains(aux)){
                            reservedWords.get("volatile").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'w'){
                    int aux = linha.indexOf("while",i);
                    if(aux != -1){
                        if(!reservedWords.get("while").contains(aux)){
                            reservedWords.get("while").add(aux);
                        }
                    }
                    aux = linha.indexOf("with",i);
                    if(aux != -1){
                        if(!reservedWords.get("with").contains(aux)){
                            reservedWords.get("with").add(aux);
                        }
                    }
                }
                else if(linha.charAt(i) == 'y'){
                    int aux = linha.indexOf("yield",i);
                    if(aux != -1){
                        if(!reservedWords.get("yield").contains(aux)){
                            reservedWords.get("yield").add(aux);
                        }
                    }
                }
            }
        }
        return reservedWords;
    }

    public static void main(String[] args) throws Exception {
        InputStream inputstream;
        inputstream = new FileInputStream("jquery.txt");
        OutputStream os = new FileOutputStream("jquery3.txt");
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter outputbr = new BufferedWriter(wr);
        
        InputStreamReader reader = new InputStreamReader(inputstream);
        BufferedReader br = new BufferedReader(reader);

        String texto = "";
        String linha = "";
        while(linha != null){
            texto += linha.trim() + "\n";
            linha = br.readLine();
        }
        String textao = texto.replaceAll("\\/\\*[\\s\\S]*?\\*\\/","");
        textao = textao.replaceAll("\\/\\/.*?\\n", "");
        textao = textao.replaceAll("\\n\\s*?\\n","");
        textao = textao.replaceAll("\n", "");

        Scanner sc=new Scanner(textao);  
        while (sc.hasNext())   
        {  
        String tokens=sc.next();  
        outputbr.write(tokens);  
        }  
        sc.close();  

        inputstream.close();
        outputbr.close();

        Map<String, List<Integer>> brackets = findBrackets();
        brackets.forEach((k, v) -> System.out.println(String.format("Token: %s | Colunas: %s", k, v)));

        Map<String, List<Integer>> operators = findOperators();
        operators.forEach((k, v) -> System.out.println(String.format("Token: %s | Colunas: %s", k, v)));

        Map<String, List<Integer>> rWords = findReservedWord();
        rWords.forEach((k, v) -> System.out.println(String.format("Token: %s | Colunas: %s", k, v)));
    }
}
