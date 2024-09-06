package Exercicios;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo {
    public static void main(String[] args) {
        System.out.println("processo seletivo");

        analisarCanditado(1400.00);
        analisarCanditado(2344.00);
        analisarCanditado(4586.00);

        System.out.println("\n-- Seleção de canditados --");
        selecaoCandidatos();

        System.out.println("\n-- Seleção de canditados --");
        imprimirSelecionados();

        String[] candidatos = {"maria", "joser", "cezar", "bony", "silvo", "isabela", "marcelo"};
        for (String canditato : candidatos) {
            entrandoEmContato(canditato);
        }
    }

    static void analisarCanditado(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("ligar para canditado");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("ligar para canditado com contra proposta");
        } else {
            System.out.println("aguardando os candidatos");
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"maria", "joser", "cezar", "bony", "silvo", "isabela", "marcelo"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " - valor: " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println(candidato + " - valor -" + salarioPretendido);
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"maria", "joser", "cezar", "bony", "silvo", "isabela", "marcelo"};
        System.out.println("imprimindo canditados listados");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("o candidato do número" + (i + 1) + " é " + candidatos[i]);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("contato realizado com sucesso!");
            }

            if (atendeu) {
                System.out.println("conseguimos o contado com " + candidato + "com" + tentativasRealizadas + "tentativas!");
            } else {
                System.out.println("não conseguimos o contado com " + candidato + "com" + tentativasRealizadas + "tentativas!");
            }
        }while (continuaTentando && tentativasRealizadas < 3) ;
    }
}


