import java.text.DecimalFormat;
import java.util.Scanner;

public class MenuConversor {
    public void Menu() {
        System.out.println("Conversor de Moeda em tempo real.");
        System.out.println("====================================================");
        Scanner leitura = new Scanner(System.in);
        BuscaCotacao buscaCotacao = new BuscaCotacao();
        System.out.println("Digite a sigla da moeda a ser convertida");
        String moeda1 = leitura.nextLine();
        System.out.println("Digite a sigla da moeda alvo");
        String moeda2 = leitura.nextLine();
        try {
            Moeda novaMoeda = buscaCotacao.buscaCotacao(moeda1, moeda2);
            //System.out.println(novaMoeda);
            System.out.println("Digite o valor a ser convertido:");
            double valor = leitura.nextDouble();
            double convertida = valor* novaMoeda.conversion_rate();
            DecimalFormat fim = new DecimalFormat("##,###.00");
            System.out.println("O valor da moeda convertida é: "+ fim.format(convertida) +" "+moeda2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("ERRO MenuConversor");
    }
}
}