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
        List<Integer> bracketsOpen = new LinkedList<Integer>();
        for (int i = 0; i < linha.length(); i++) {
            if(stringMode && linha.charAt(i)== '"') stringMode= false;
            else if(linha.charAt(i)== '"') stringMode = true;
            if(!stringMode){
                if(linha.charAt(i) == '(') bracketsOpen.add(i);
            }
        }
        operators.put("(", bracketsOpen);
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
        //List<Integer> equal = new LinkedList<Integer>();
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
                // else if(linha.charAt(i) == '='){ 
                //     if(linha.charAt(i+1) == ' ')
                //     equal.add(i);
                // }  
                // NECESSARIO LISTA DE OPERANDOS
            }
        }
        brackets.put("(", bracketsOpen);
        brackets.put(")", bracketsClose);
        brackets.put("[", squareOpen);
        brackets.put("]", squareClose);
        brackets.put("{", keyOpen);
        brackets.put("}", keyClose);
        brackets.put(";", pv);
        //brackets.put("=", equal);
        return brackets;
    }
    public static void main(String[] args) throws Exception {
        InputStream inputstream;
        inputstream = new FileInputStream("jquery2.txt");
        OutputStream os = new FileOutputStream("jquery3.txt");
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter outputbr = new BufferedWriter(wr);
        
        InputStreamReader reader = new InputStreamReader(inputstream);
        BufferedReader br = new BufferedReader(reader);

        List<String> reservedWords = Arrays.asList(
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

        String texto = "";
        String linha = "";
        while(linha != null){
            texto += linha.trim() + "\n";
            linha = br.readLine();
        }
        String textao = texto.replaceAll("\\/\\*[\\s\\S]*\\*\\/","");
        textao = textao.replaceAll("\\/\\/.*?\\n", "");
        textao = textao.replaceAll("\\n\\s*?\\n","");
        textao = textao.replaceAll("\n", "");
        // Pattern pattern = Pattern.compile("(?i)\\b(function)\\b");
        // Matcher matcher = pattern.matcher(textao);
        // while (matcher.find()) {
        //     System.out.println(matcher.group());
        // } 
        // for (String string : reservedWords) {
        //     String regex = "(?i)\\b("+string+")\\b";
        //     textao = textao.replaceAll(regex, "");
        // }
        Scanner sc=new Scanner(textao);  
        while (sc.hasNext())   
        {  
        String tokens=sc.next();  
        outputbr.write(tokens);  
        }  
        sc.close();  
        //System.out.println(textao);
        //outputbr.write(textao);

        inputstream.close();
        outputbr.close();

        Map<String, List<Integer>> brackets = findBrackets();
        brackets.forEach((k, v) -> System.out.println(String.format("key: %s | value: %s", k, v)));
    }
}
