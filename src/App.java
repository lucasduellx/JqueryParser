import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        InputStream inputstream;
        inputstream = new FileInputStream("jquery.txt");
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
        //textao = textao.replaceAll("\n", "");
        System.out.println(textao);
        outputbr.write(textao);

        inputstream.close();
        outputbr.close();
    }
}
