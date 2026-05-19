import java.time.*;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){

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


class condomino{
    private String nome;
    private String apartamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApartemento() {
        return apartamento;
    }

    public void setApartemento(String apartemento) {
        this.apartamento = apartemento;
    }
}

class convidado {
    String nome;
    String rg;
    String cpf;

    public convidado(String nome, String rg, String cpf) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }
}

class reserva{
    condomino responsavel;
    AreaComum area;
    LocalDateTime dataHoraInicio;
    LocalDateTime dataHoraFim;

    ArrayList<convidado> convidados = new ArrayList<>();

    public void adicionarConvidado(convidado conv){
        if (convidados.size() < area.getCapacidadeMaxima()){
            convidados.add(conv);
            System.out.println("Convidado adicionado: " + conv.nome);
        } else{
            System.out.println("Limite de convidados atingido.");
        }
    }

    public void removerConvidado(String cpf){
        for (convidado conv: convidados){
            if (conv.cpf.equals(cpf)){
                convidados.remove(conv);
                System.out.println("Convidado removido: " + conv.nome);
                return;
            }
        }
        System.out.println("Convidado não encontrado");
    }
}

class gerenciador{

}