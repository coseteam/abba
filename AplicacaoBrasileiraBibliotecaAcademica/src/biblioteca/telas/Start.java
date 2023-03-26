package biblioteca.telas;

import biblioteca.services.PersistenciaService;

public class Start {
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        PersistenciaService persistenciaService = new PersistenciaService();
        persistenciaService.lerLivrosPersistidos();
        menuPrincipal.menuPrincipal();
  }

}
