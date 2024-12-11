import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;

        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor(1, "Monteiro Lobato", LocalDate.of(1882,04, 18));
        Autor autor2 = new Autor(2, "Jim Davis", LocalDate.of(1945, 07, 28));
        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        Livro livro1 = new Livro(1, "Turma da Mônica em: Uma Foto do Limoeiro", autor1);
        Livro livro2 = new Livro(2, "Garfiel, o Rei da Preguiça", autor2);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        boolean continuar = true;
        String menuAtual = "principal";

        while (continuar){
            switch (menuAtual){
                case "principal":
                    System.out.println("Escolha uma opção:\n" +
                            "1. Livros\n" +
                            "2. Autores\n" +
                            "3. Sair");
                    String opcaoPrincial = scanner.nextLine();
                    switch (opcaoPrincial){
                        case "1":
                            menuAtual = "livros";
                            break;
                        case "2":
                            menuAtual = "autores";
                            break;
                        case "3":
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente!");
                    }
                    break;
                case "livros":
                    System.out.println("Escolha uma opção:\n" +
                            "1. Exibir inventário de livros\n" +
                            "2. Adicionar livro\n" +
                            "3. Remover Livro\n" +
                            "4. Atualizar Livro\n" +
                            "5. Buscar Livro\n" +
                            "6. Realizar Empréstimo\n" +
                            "7. Devolver Livro\n" +
                            "8. Exibir Livros disponíveis\n" +
                            "9. Voltar ao menu principal");
                    String opcaoLivros = scanner.nextLine();
                    switch (opcaoLivros){
                        case "1":
                            System.out.println(biblioteca.listarLivros());
                            break;
                        case "2":
                            System.out.println("Informe o ID do Livro que deseja adicionar: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Insira o nome do Livro: ");
                            String nomeLivro = scanner.nextLine();
                            System.out.println("Insira o ID do autor: ");
                            int idAutor = scanner.nextInt();
                            scanner.nextLine();
                            Autor autor = biblioteca.buscarLivroPorID(idAutor).getAutor();
                            Livro livro = new Livro(id, nomeLivro, autor);
                            biblioteca.adicionarLivro(livro);
                            System.out.println("Livro adicionado com sucesso!");
                            break;
                        case "3":
                            System.out.println("Insira o ID do livro que deseja remover: ");
                            int idLivroRemovido = scanner.nextInt();
                            biblioteca.removerLivro(idLivroRemovido);
                            scanner.nextLine();
                            break;
                        case "4":
                            System.out.println("Insira o ID do livro que deseja atualizar: ");
                            int idLivroAtualizar = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Informe o novo título: ");
                            String novoTitulo = scanner.nextLine();
                            biblioteca.atualizarLivro(idLivroAtualizar, novoTitulo);
                            break;
                        case "5":
                            System.out.println("Informe o ID do Livro que você procura: ");
                            int idLivro = scanner.nextInt();
                            biblioteca.buscarLivroPorID(idLivro);
                            break;
                        case "6":
                            System.out.println("Informe o ID do Livro que você emprestar: ");
                            int idLivroEmprestimo = scanner.nextInt();
                            Livro livroResultado = biblioteca.buscarLivroPorID(idLivroEmprestimo);
                            System.out.println("Insira seu nome: ");
                            scanner.nextLine();
                            String nomeCliente = scanner.nextLine();
                            biblioteca.emprestarLivro(livroResultado, nomeCliente);
                            break;
                        case "7":
                            System.out.println("Insira o ID do empréstimo: ");
                            
                            int idEmprestimo = scanner.nextInt();
                            biblioteca.devolverLivro(idEmprestimo);
                            scanner.nextLine();
                            break;
                        case "8":
                            System.out.println("Livros disponíveis:");
                            Livro livrosDisponiveis = (Livro) biblioteca.listarLivrosDisponiveis();
                            System.out.println(livrosDisponiveis);
                            break;
                        case "9":
                            menuAtual = "principal";
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente!");
                    }
                    break;
                case "autores":
                    System.out.println("Escolha uma opção:\n" +
                            "1. Exibir autores\n" +
                            "2. Adicionar autor\n" +
                            "3. Editar autor\n" +
                            "4. Remover autor\n" +
                            "5. Voltar ao menu principal");
                    String opcaoAutores = scanner.nextLine();
                    switch (opcaoAutores){
                        case "1":
                            System.out.println(biblioteca.listarAutores());
                            break;
                        case "2":
                            System.out.println("Insira o ID: ");
                            int idAutor = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Informe o nome do Autor: ");
                            String nomeAutor = scanner.nextLine();
                            System.out.println("Insira a data de nascimento: [dd/MM/yyyy]");
                            String nascimento = scanner.nextLine();
                            DateTimeFormatter formatteer = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate dataNascimento = LocalDate.parse(nascimento, formatteer);
                            Autor autor = new Autor(idAutor, nomeAutor, dataNascimento);
                            biblioteca.adicionarAutor(autor);
                            break;
                        case "3":
                            System.out.println("Insira o ID do autor: ");
                            int idAutorA = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Informe o novo nome desejado: ");
                            String novoNome = scanner.nextLine();
                            biblioteca.atualizarAutor(idAutorA, novoNome);
                            break;
                        case "4":
                            System.out.println("Insira o ID do autor que deseja remover: ");
                            int idAutorRemovido = scanner.nextInt();
                            biblioteca.removerAutor(idAutorRemovido);
                            break;
                        case "5":
                            menuAtual = "principal";
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente!");
                            break;
                    }
                    break;
            }
        }
        scanner.close();
    }
}