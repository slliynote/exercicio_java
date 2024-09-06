package Exercicios;
import java.util.Scanner;
public class contador {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);
        } catch (parametrosInvalidosException exception) {
            System.out.println(" O segundo valor de ser maior que o primeiro");
        }

    }

    static void contar(int parametroUm, int parametroDois) throws parametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new parametrosInvalidosException();
        }

        int contagem = parametroDois - parametroUm;
        for (int i = 0; i < contagem; i++) {
            System.out.println("Imprimindo o número" + i);
        }
    }

}

