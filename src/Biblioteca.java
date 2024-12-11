import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

   private List <Livro> livros = new ArrayList<>();
   private List <Autor> autores = new ArrayList<>();
   private List <Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public List<Livro> listarLivros(){
        return livros;
    }

    public void emprestarLivro(Livro livro, String nomeCliente){
        if (livro.isDisponivel()){
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), nomeCliente, livro);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
            System.out.println("Livro empresatado com sucesso!");
            int idEmprestimo = emprestimo.getId();
            System.out.println("ID do empréstimo: " + idEmprestimo);
        }
        else {
            System.out.println("Livro não disponível para empréstimo");
        }
    }

    public void devolverLivro(int idEmprestimo){
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == idEmprestimo){
                emprestimo.devolverLivro();
                System.out.println("Livro devolvido com sucesso!");
            }
        }
    }

    public List<Livro> listarLivrosDisponiveis(){
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.isDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public Livro buscarLivroPorID(int id){
        for (Livro livro : livros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;
    }

    public void atualizarLivro(int id, String novoTitulo){
        for (Livro livro : livros){
            if (livro.getId() == id){
                livro.setTitulo(novoTitulo);
            }
        }
    }

    public void removerLivro(int id){
        for (Livro livro : livros){
            if (livro.getId() == id){
                livros.remove(livro);
            }
        }
    }

    public List<Autor> listarAutores(){
        return autores;
    }

    public void adicionarAutor(Autor autor){
        autores.add(autor);
        System.out.println("Autor adicionado com sucesso!");
    }

    public void removerAutor(int id){
        for (Autor autor : autores){
            if (autor.getId() == id){
                autores.remove(autor);
            }
        }
    }

    public void atualizarAutor(int id, String novoNome){
        for (Autor autor : autores){
            if (autor.getId() == id){
                autor.setNome(novoNome);
                System.out.println("Autor adicionado com sucesso!");
            }
        }
    }
}
