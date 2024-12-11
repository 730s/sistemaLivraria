import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {

    private Livro livro;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private int id;
    private static int contadorId = 1;

    public Emprestimo(LocalDate dataEmprestimo, String nomeCliente, Livro livro) {
        this.id = contadorId++;
        this.dataEmprestimo = dataEmprestimo;
        this.nomeCliente = nomeCliente;
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void devolverLivro(){
        this.dataDevolucao = LocalDate.now();
        this.livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", nomeUsuario='" + nomeCliente + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
