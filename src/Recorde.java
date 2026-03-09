import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Recorde {

    // Atributos dad classe recorde
    private LocalDate data;
    private double tempo;
    private String nome;

    // Aqui seria o construtor para não mexer na classe
    public Recorde(LocalDate data, double tempo, String nome){
        this.data = data;
        this.tempo=tempo;
        this.nome=nome;
    }

    public LocalDate getData() {
        return data;
    }
    
    public double getTempo() {
        return tempo;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Data: %s | Tempo: %.2f segundos | Atleta: %s", 
                data.format(formatador), tempo, nome);
    }
}
