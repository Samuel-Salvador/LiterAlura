package com.ONE.LiterAlura.view;

import com.ONE.LiterAlura.models.Book;
import com.ONE.LiterAlura.services.AuthorService;
import com.ONE.LiterAlura.services.BookService;

import java.util.List;
import java.util.Scanner;

public class Menu {

   private static final Scanner scanner = new Scanner(System.in);

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
        System.out.println(BookService.getSearchedBooks());
    }

    private static void printAllSearchedAuthors() {
        System.out.println(AuthorService.getSearchedAuthors());
    }

    private static void printAllSearchedAuthorsAlive() {
        System.out.print("Digite o ano que deseja pesquisar o autor: ");
        Integer year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Autores vivos em " + year + ":");
        System.out.println(AuthorService.getSearchedAuthorsAliveIn(year));
    }


    private static void searchBookByLanguage() {
        System.out.println("Digite a linguagem que deseja: (en), (pt) ...");
        String language = scanner.nextLine();
        List<Book> filteredBookList = BookService.filterBooksByLanguage(language);
        if(!filteredBookList.isEmpty()){
            System.out.println(filteredBookList);
        }else System.out.println("Não há livros nesta língua, verifique se foi digitada corretamente");
    }

    private static void searchBookByTitle() {
        System.out.print("Digite o título do livro a ser buscado: ");
        String title = scanner.nextLine();
        String correctTitle = title.replaceAll("\\s","%20");
        Book book = BookService.getBookByTitle(correctTitle);
        if(book != null){
            System.out.println( "Livro encontrado: \n" + book );
        } else System.out.println( "Livro não encontrado!" );

    }
}
