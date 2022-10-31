import java.util.Scanner;
public class Emoticons {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Como você está se sentindo hoje?");
        System.out.print("> ");
        String feliz = ":-)"; //variaveis de comparação
        String triste = ":-(";
        Integer contadorFeliz = 0; //variaveis contadores
        Integer contadorTriste = 0;
        String stgAnalise = scan.nextLine();
        for (int i = 0; i < stgAnalise.length(); i++) {
            if (stgAnalise.substring(i).startsWith(feliz)) {
                contadorFeliz ++;
            }
        }   
        for (int i = 0; i < stgAnalise.length(); i++) {
            if (stgAnalise.substring(i).startsWith(triste)) {
                contadorTriste
                 ++;
            }
        }  
        if(contadorTriste == contadorFeliz){
            System.out.println("neutro");
        }
        if(contadorFeliz > contadorTriste){
            System.out.println("divertido");
        }
        if(contadorTriste > contadorFeliz){
            System.out.println("chateado");
        }
        scan.close();
    }
}
