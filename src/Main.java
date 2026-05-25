import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Condominio> moradores = new ArrayList<>();

    public static void main(String[] args){

        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- Sistema de Reservas ---");
            System.out.println("1 - Cadastrar apartamento e morador");
            System.out.println("2 - Cadastrar area comum");
            System.out.println("3 - Cadastrar reserva");
            System.out.println("4 - Listar moradores");
            System.out.println("5 - Listar areas comuns");
            System.out.println("6 - Listar reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            String opcao = scanner.nextLine().trim();
            switch (opcao) {
                case "1":
                    cadastrarApartamentoMorador(scanner, moradores);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "0":
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");


    }
        private static void cadastrarApartamentoMorador(Scanner scanner, List<Condominio> moradores) {
        System.out.print("Digite o numero do apartamento: ");
        String apartamento = scanner.nextLine().trim();
        System.out.print("Digite o nome do morador: ");
        String nome = scanner.nextLine().trim();

        Condominio morador = new Condominio();
        morador.setApartamento(apartamento);
        morador.setNome(nome);
        moradores.add(morador);

        System.out.println("Morador cadastrado: " + nome + " (apartamento " + apartamento + ")");
    }
}


class AreaComum{
    private String nome;
    private int capacidadeMaxima;
    LocalTime horaLimiteDeSemana;
    LocalTime horaLimiteFinalDeSemana;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}


class Condominio{
    private String nome;
    private String apartamento;
    private final List<Reserva> reservas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}

class Convidado {
    String nome;
    String rg;
    String cpf;

    public Convidado(String nome, String rg, String cpf) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }



}

class Reserva{
    Condominio responsavel;
    AreaComum area;
    LocalDateTime dataHoraInicio;
    LocalDateTime dataHoraFim;
    ArrayList<Convidado> convidados = new ArrayList<>();

    
    public void adicionarConvidado(Convidado conv){
        if (convidados.size() < area.getCapacidadeMaxima()){
            convidados.add(conv);
            System.out.println("Convidado adicionado: " + conv.nome);
        } else{
            System.out.println("Limite de convidados atingido.");
        }
    }

    public void removerConvidado(String cpf){
        for (Convidado conv: convidados){
            if (conv.cpf.equals(cpf)){
                convidados.remove(conv);
                System.out.println("Convidado removido: " + conv.nome);
                return;
            }
        }
        System.out.println("Convidado não encontrado");
    }
}

class Gerenciador{

}