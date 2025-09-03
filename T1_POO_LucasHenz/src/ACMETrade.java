
import java.util.Collection;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;

public class ACMETrade {

	private Convencao convencao;
	private Federacao federacao;
	private Scanner tec = new Scanner(System.in);  // Atributo para entrada padrao (teclado)
	private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
	private final String nomeArquivoEntrada = "entrada.txt";  // Nome do arquivo de entrada de dados
	private final String nomeArquivoSaida = "saida.txt";  // Nome do arquivo de saida de dados

	public ACMETrade() {
		 this.convencao = new Convencao();
		 this.federacao = new Federacao();
		 this.tec = new Scanner(System.in);
		 this.saidaPadrao = System.out;
	}

	public void executar() {
		redirecionaEntrada();
		redirecionaSaida();

		while (true) {
			if (!tec.hasNextInt()) {
				break;
			}

			int opcao = tec.nextInt();

			if (tec.hasNextLine()) {
				tec.nextLine();
			}

			if (opcao == -1) break;
			switch (opcao) {
				case 0: break;
				case 1:
					CadastrarPais(); break;
				case 2:
					CadastrarAcordo(); break;
				case 3:
					consultarPaisPorSigla(); break;
				case 4:
					consultarAcordoPorCodigo(); break;
				case 5:
					consultarAcordoPelaSiglaDoComprador(); break;
				case 6:
					mudarNomeDePais(); break;
				case 7:
					apagarAcordoPeloPaisComprador(); break;
				case 8:
					listarTodosAcordos(); break;
				case 9:
					listarPaisesComprador(); break;
				case 10:
					mostrarPaisComMaisAcordosVendedor(); break;
				default:
					System.out.println("Opcao invalida");
			}
		}
	}


	public void CadastrarPais() {
		// System.out.print("Qual a SIGLA do pais:");
		String sigla = tec.nextLine();
		// System.out.print("Qual o nome do pais:");
		String nome = tec.nextLine();

		Pais pais = new Pais(sigla, nome);

		boolean resultado = federacao.adicionarPais(pais);
		if(resultado)
			 System.out.println("1: " + pais.getSigla() + ": " + pais.getNome());
		else
			 System.out.println("País repetido!");
	}

	public void CadastrarAcordo() {

		// System.out.print("Qual o codigo do acordo:");
		int codigo = tec.nextInt();
		tec.nextLine();
		Acordo a = convencao.consultarAcordo(codigo);
		if (a != null) {
			System.out.println("2:erro-codigo repetido");
			return;
		}


		// System.out.print("Qual o produto do acordo:");
		String produto = tec.nextLine();

		// System.out.print("Qual a taxa do acordo:");
		double taxa = tec.nextDouble();
		tec.nextLine();

		// System.out.print("Qual a sigla do comprador do acordo:");
		String SiglaComprador = tec.nextLine();
		// System.out.print("Qual a sigla do vendedror do acordo:");
		String SiglaVendedor = tec.nextLine();

		Pais pC = federacao.consultarPaisPorSigla(SiglaComprador);
		Pais pV = federacao.consultarPaisPorSigla(SiglaVendedor);
		if (pC == null) {
			System.out.println("2:erro-comprador inexistente.");
			return;
		}
		if (pV == null) {
			System.out.println("2:erro-vendedor inexistente.");
			return;
		}

		Acordo acordo = new Acordo(codigo, produto, taxa, pC, pV);

		boolean resultado = convencao.adicionarAcordo(acordo);
		if(resultado)
			System.out.println("2: " + acordo.getCodigo() + ": " + acordo.getProduto() + ": " + acordo.getTaxa() + ": " +  acordo.getSiglaComprador() + ": " + acordo.getSiglaVendedor());
		else
			System.out.println("2:erro-acordo repetido");
	}

	public void consultarPaisPorSigla() {
		// System.out.print("Digite a sigla do pais:");
		String sigla = tec.nextLine();
		Pais p = federacao.consultarPaisPorSigla(sigla);
		if (p != null) {
			System.out.println("3: " + p.getSigla() + ": " + p.getNome());
		} else {
			System.out.println("3:erro-sigla inexistente");
		}

	}

	public void consultarAcordoPorCodigo() {
		// System.out.print("Digite a codigo do acordo:");
		int codigo = tec.nextInt();
		convencao.consultarAcordo(codigo);
		Acordo a = convencao.consultarAcordo(codigo);
		if (a != null) {
			System.out.println("4: " + a.getCodigo() + ": " + a.getProduto() + ": " + a.getTaxa() + ": " + a.getSiglaComprador() + ": " + a.getSiglaVendedor());
		} else {
			System.out.println("4: erro-codigo inexistente");
		}
	}

	public void consultarAcordoPelaSiglaDoComprador() {
		// System.out.print("Digite a sigla do comprador do acordo: ");
		String sigla = tec.nextLine().trim();
		convencao.consultarAcordo(sigla);
		Acordo a = convencao.consultarAcordoPelaSiglaDoComprador(sigla);
		if (a != null) {
			System.out.println("5: " + a.getCodigo() + ": " + a.getProduto() + ": " + a.getTaxa() + ": " + a.getSiglaComprador() + ": " + a.getSiglaVendedor());
		} else {
			System.out.println("5: erro-sigla inexistente");
		}
	}

	public void mudarNomeDePais() {
		String sigla = tec.nextLine().trim();
		Pais p = federacao.consultarPaisPorSigla(sigla);
		if (p == null) {
			System.out.println("6: erro-sigla inexistente");
		} else {
			String nomeNovo = tec.nextLine();
			federacao.mudarNomeDePais(nomeNovo, p);
			System.out.println("6: " + p.getSigla() + ": " + p.getNome());
		}
	}

	public void apagarAcordoPeloPaisComprador() {
		String sigla = tec.nextLine().trim();
		Acordo a = convencao.consultarAcordoPelaSiglaDoComprador(sigla);
		if (a != null) {
			convencao.removerAcordoPelaSiglaDoComprador(sigla);
			System.out.println("7: acordos removidos");
		} else {
			System.out.println("7: erro-nenhum acordo encontrado");
		}
	}

	public void listarTodosAcordos() {
		Collection<Acordo> acordo = convencao.getAcordos();

		if (acordo.isEmpty()) {
			System.out.println("8: erro-nenhum acordo cadastrado");
			return;
		}
		for (Acordo a : acordo) {
			System.out.println("8: " + a.getCodigo() + ";"
					+ a.getProduto() + ";"
					+ a.getTaxa() + ";"
					+ a.getSiglaComprador() + ";"
					+ a.getSiglaVendedor());
		}
	}


	public void listarPaisesComprador() {
		Collection<Acordo> acordos = convencao.getAcordos();

		if (acordos.isEmpty()) {
			System.out.println("9: erro-nenhum país encontrado.");
			return;
		}
		for (Acordo a : acordos) {
			Pais comprador = a.getPaisComprador();
			if (comprador != null) {
				System.out.println("9: " + comprador.getSigla() + ": " + comprador.getNome());
			}
		}
	}


	public void mostrarPaisComMaisAcordosVendedor() {
		Collection<Pais> paises = federacao.getPaises();
		Collection<Acordo> acordos = convencao.getAcordos();

		if (paises.isEmpty() || acordos.isEmpty()) {
			System.out.println("10:erro-nenhum pais encontrado.");
			return;
		}

		Pais paisMax = null;
		int max = 0;

		for (Pais p : paises) {
			int contador = 0;

			for (Acordo a : acordos) {
				Pais vendedor = a.getPaisVendedor();
				if (vendedor != null && vendedor.getSigla().equalsIgnoreCase(p.getSigla())) {
					contador++;
				}
			}

			if (contador > max) {
				max = contador;
				paisMax = p;
			}
		}

		if (paisMax != null) {
			System.out.println("10:" + paisMax.getSigla() + ";" + paisMax.getNome() + ";" + max);
		} else {
			System.out.println("10:erro-nenhum pais encontrado.");
		}
	}




	// entradas
	private void redirecionaEntrada() {
		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
			tec = new Scanner(streamEntrada);   // Usa como entrada um arquivo
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
		tec.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
	}

	// Redireciona Saida de dados para arquivos em vez da tela (terminal)
	// Chame este metodo para redirecionar a escrita de dados para arquivos
	private void redirecionaSaida() {
		try {
			PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
			System.setOut(streamSaida);             // Usa como saida um arquivo
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
	}








}
