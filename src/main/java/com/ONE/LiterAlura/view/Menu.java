package com.ONE.LiterAlura.view;

import com.ONE.LiterAlura.controllers.AuthorController;
import com.ONE.LiterAlura.controllers.BookController;
import com.ONE.LiterAlura.models.Author;
import com.ONE.LiterAlura.models.Book;
import com.ONE.LiterAlura.models.Language;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

   private static final Scanner scanner = new Scanner(System.in);

   private static BookController bookController;
   private static AuthorController authorController;

    public Menu(BookController bookController, AuthorController authorController) {
        Menu.bookController = bookController;
        Menu.authorController = authorController;
    }

    public static void show(){

        String escolha;
        do{
            System.out.println("\n   LiterAlura, a sua biblioteca de livros : ");
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros em um determinado idioma");
            System.out.println("0 - Sair");

            escolha = scanner.nextLine();

            switch (escolha){
                case "0":
                    break;
                case "1":
                    searchBookByTitle();
                    break;
                case "2":
                    printAllSearchedBooks();
                    break;
                case "3":
                    printAllSearchedAuthors();
                    break;
                case "4":
                    printAllSearchedAuthorsAlive();
                    break;
                case "5":
                    searchBookByLanguage();
                    break;
                default:
                    System.out.println("Digite uma opção válida, '"+escolha+"' não é um número de 0 a 5.");
                    break;
            }
        }while(!escolha.equals("0"));
    }

    private static void printAllSearchedBooks(){
        System.out.println("\nLivros: ");
        bookController.getSearchedBooks().forEach(System.out::println);
    }

    private static void printAllSearchedAuthors() {
        System.out.println("\nAutores: ");
        authorController.getSearchedAuthors().forEach(System.out::println);
    }

    private static void printAllSearchedAuthorsAlive() {
        System.out.print("Digite o ano que deseja pesquisar o autor: ");
        Integer year = scanner.nextInt();
        scanner.nextLine();

        List<Author> authorsAlive = authorController.getSearchedAuthorsAliveIn(year);
        if(!authorsAlive.isEmpty()){
            System.out.println("\nAutores vivos em " + year + ":");
            authorsAlive.forEach(System.out::println);
        }else System.out.println("Não há autores vivos neste ano!");
    }


    private static void searchBookByLanguage() {
        System.out.println("\nDigite a linguagem que deseja: (sem acento)");
        String language = scanner.nextLine();
        List<Book> filteredBookList = bookController.getFilteredBooksByLanguage(language);
        int numberOfBooks = filteredBookList.size();

        if(!filteredBookList.isEmpty()){
            System.out.println("\n"+numberOfBooks+" livros encontrados: ");
            filteredBookList.forEach(System.out::println);
        }else System.out.println("Não há livros nesta língua, verifique se foi digitada corretamente");
    }

    private static void searchBookByTitle() {
        System.out.print("Digite o título do livro a ser buscado: ");
        String title = scanner.nextLine();
        Book book = bookController.getBookByTitle(title);
        if(book != null){
            System.out.println( "\nLivro encontrado: \n" + book );
        } else System.out.println( "\nLivro não encontrado!" );

    }
}
