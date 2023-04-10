package biblioteca.services;

import biblioteca.validations.Validador;

import java.util.ArrayList;


public class BibliotecaService {
    public static ArrayList<String> todosISBNCadastrados = new ArrayList<>();
    public static PersistenciaService persistenciaService = new PersistenciaService();



    public BibliotecaService() {
        todosISBNCadastrados = persistenciaService.lerISBNPersisitidos();
        System.out.println(todosISBNCadastrados);
        Validador validador = new Validador();
    }

    public static void setTodosISBNCadastrados(String newISBN) {
        todosISBNCadastrados.add(newISBN);
        persistenciaService.persistirEntidade(todosISBNCadastrados);
    }



}
