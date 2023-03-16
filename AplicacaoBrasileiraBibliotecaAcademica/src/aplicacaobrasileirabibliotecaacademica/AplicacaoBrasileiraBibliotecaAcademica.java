
package aplicacaobrasileirabibliotecaacademica;
import java.util.ArrayList;
import java.util.Scanner;


public class AplicacaoBrasileiraBibliotecaAcademica {
	
	protected ArrayList<Cliente> carteiraClientes;
	protected ArrayList<Funcionario> quadroFuncionarios;
	protected ArrayList<Livro> acervoLivros;
	protected ArrayList<Emprestimo> logEmprestimos;
	
	
	
	
	static boolean autenticarLogin() {
		boolean estaAutenticado;
		estaAutenticado= true;
		return estaAutenticado;
	}
	
	static int mostrarMenuPrincipal() {
		Scanner INPUTUSER = new Scanner(System.in);
		int inputOpcaoMenu;
		
		System.out.println("\n\n========== MENU PRINCIPAL ==========");

		System.out.println("\nEscolha uma opção\n");
		System.out.println("1 - NOVO");
		System.out.println("2 - BUSCA");
		System.out.println("3 - ATUALIZAÇÃO");
		System.out.println("4 - ADMIN");
		System.out.println("0 - ENCERRAR");


		System.out.print("\n=> ");
		inputOpcaoMenu = INPUTUSER.nextInt();
			
		return inputOpcaoMenu;	
	}
	
	private static void mostrarMenuNovo() {
		Scanner USERINPUT = new Scanner(System.in);
		int inputOpcaoNovo;
		int opcaoNovo;
		
		
		do {
			System.out.println("\n\n========== NOVO ==========");
			
			System.out.println("\nEscolha uma opção\n");
			
			
			System.out.println("1 - Novo Empréstimo");
			System.out.println("2 - Novo Cliente");
			System.out.println("3 - Novo Livro");
			System.out.println("0 - Voltar");
			
			
			System.out.print("\n=> ");
			inputOpcaoNovo = USERINPUT.nextInt();
			opcaoNovo = inputOpcaoNovo;
			
			switch (opcaoNovo) {
				case 1:
					
					break;
				case 2:
					
					
					break;
				case 3:
					
					break;
				case 0:
					
					break;					
				default:
					throw new AssertionError();
			}
			
		} while (opcaoNovo != 0);	
	}
	
	private static void mostrarMenuBusca() {
		Scanner USERINPUT = new Scanner(System.in);
		int inputOpcaoBusca;
		int opcaoBusca;
		
		
		do {
			System.out.println("\n\n========== BUSCA ==========");
			
			System.out.println("\nEscolha uma opção\n");
			
			
			System.out.println("1 - Ver Empréstimos");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Acervo");
			System.out.println("0 - Voltar");
			
			
			System.out.print("\n=> ");
			inputOpcaoBusca = USERINPUT.nextInt();
			
			opcaoBusca = inputOpcaoBusca;
			
			switch (opcaoBusca) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 0:
					
					break;					
				default:
					throw new AssertionError();
			}
			
		} while (opcaoBusca != 0);
	}
	
	private static void mostrarMenuAtualizacao() {
		Scanner USERINPUT = new Scanner(System.in);
		int inputOpcaoAtualizacao;
		int opcaoAtualizacao;
		
		
		do {
			System.out.println("\n\n========== ATUALIZAÇÃO ==========");
			
			System.out.println("\nEscolha uma opção\n");
			
			
			System.out.println("1 - Adiar / Alterar Empréstimo");
			System.out.println("2 - Atualizar Perfil do Cliente");
			System.out.println("3 - Editar Informações do Acervo");
			System.out.println("0 - Voltar");
			
			
			System.out.print("\n=> ");
			inputOpcaoAtualizacao = USERINPUT.nextInt();
			
			opcaoAtualizacao = inputOpcaoAtualizacao;
			
			switch (opcaoAtualizacao) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 0:
					
					break;					
				default:
					throw new AssertionError();
			}
			
		} while (opcaoAtualizacao != 0);
	}
	
	private static void mostrarMenuAdmin() {
		Scanner USERINPUT = new Scanner(System.in);
		int inputOpcaoAdmin;
		int opcaoAdmin;
		
		
		do {
			System.out.println("\n\n========== ADMIN ==========");
			
			System.out.println("\nEscolha uma opção\n");
			
			
			System.out.println("1 - Empréstimos");
			System.out.println("2 - Clientes");
			System.out.println("3 - Acervo");
			System.out.println("4 - Funcionários");
			System.out.println("0 - Voltar");
			
			
			System.out.print("\n=> ");
			inputOpcaoAdmin = USERINPUT.nextInt();
			
			opcaoAdmin = inputOpcaoAdmin;
			
			switch (opcaoAdmin) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 0:
					
					break;					
				default:
					throw new AssertionError();
			}
			
		} while (opcaoAdmin != 0);
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("SINCRONIZANDO REPOSITÓRIOS");
		Scanner INPUTUSER = new Scanner(System.in);
		
		System.out.println("Bem Vinde");
		System.out.println("\n ==== MUDA TELA ==== \n");
		
		int opcaoLogin = 1;
		boolean autenticado = false;
		String loginEmail;
		String loginSenha;
		Funcionario objetoFuncionarioLogado;
		int nivelFuncionarioLogado = 0;
		
		while(autenticado == false) {
			System.out.println("Preencha os dados abaixo para acessar ");
			System.out.print("ID: ");
			loginEmail = INPUTUSER.next();
			System.out.print("Senha: ");
			loginSenha = INPUTUSER.next();
			
			if(autenticarLogin()) {
				autenticado = true;
				//objetoFuncionarioLogado = quadroFuncionarios[XXXX] ;
				nivelFuncionarioLogado = 1;
				break;
			}
			
			if(opcaoLogin == 0) {
				System.out.println("Encerrando Aplicação");
				break;
			}
		}
		
		int opcaoMenuPrincipal;
		do {
			opcaoMenuPrincipal = mostrarMenuPrincipal();

			switch (opcaoMenuPrincipal) {
				case 1:
					mostrarMenuNovo();
					break;
				case 2:
					mostrarMenuBusca();
					break;
				case 3:
					mostrarMenuAtualizacao();
					break;
				case 4:
					if (nivelFuncionarioLogado != 1) {
						System.out.println("Você não tem permissão para acessar esta área. Contate o administrador.");
					} else {
						mostrarMenuAdmin();
					}
					break;
				case 0:
					System.out.println("Encerrando Aplicação...");
					break;					
				default:
					throw new AssertionError();
			}
		} while (opcaoMenuPrincipal != 0);

	}


	
}

