package controller;

import model.Paciente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private final String arquivo = "pacientes.txt";
    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteController() {
        carregarPacientes();
    }

    private void carregarPacientes() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int numero = Integer.parseInt(dados[0]);
                double peso = Double.parseDouble(dados[1]);
                double altura = Double.parseDouble(dados[2]);
                pacientes.add(new Paciente(numero, peso, altura));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo.");
        }
    }

    private void salvarPacientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Paciente p : pacientes) {
                bw.write(p.getNumero() + ";" + p.getPeso() + ";" + p.getAltura());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo.");
        }
    }

    public void incluirPaciente(int numero, double peso, double altura) {
        pacientes.add(new Paciente(numero, peso, altura));
        salvarPacientes();
    }

    public void alterarPaciente(int numero, double peso, double altura) {
        for (Paciente p : pacientes) {
            if (p.getNumero() == numero) {
                p.setPeso(peso);
                p.setAltura(altura);
                salvarPacientes();
                return;
            }
        }
    }

    public void excluirPaciente(int numero) {
        pacientes.removeIf(p -> p.getNumero() == numero);
        salvarPacientes();
    }

    public List<Paciente> consultarPacientes() {
        return pacientes;
    }
}
