package view;

import controller.PacienteController;
import model.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PacienteController controller = new PacienteController();
        int opcao;

        do {
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Pacientes");
            System.out.println("0. Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número: ");
                    int numero = sc.nextInt();
                    System.out.print("Peso: ");
                    double peso = sc.nextDouble();
                    System.out.print("Altura: ");
                    double altura = sc.nextDouble();
                    controller.incluirPaciente(numero, peso, altura);
                    break;
                case 2:
                    System.out.print("Número do Paciente: ");
                    int numAlt = sc.nextInt();
                    System.out.print("Novo Peso: ");
                    double pesoAlt = sc.nextDouble();
                    System.out.print("Nova Altura: ");
                    double alturaAlt = sc.nextDouble();
                    controller.alterarPaciente(numAlt, pesoAlt, alturaAlt);
                    break;
                case 3:
                    System.out.print("Número do Paciente para excluir: ");
                    int numExc = sc.nextInt();
                    controller.excluirPaciente(numExc);
                    break;
                case 4:
                    for (Paciente p : controller.consultarPacientes()) {
                        p.listarPaciente();
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
