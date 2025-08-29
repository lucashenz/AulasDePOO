import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.Scanner;

public class ACMETrade {

	private Convencao convencao;
	private ArrayList<Pais> paisArray;
	private Federacao federacao;
	private ArrayList<Acordo> acordosArray;
	private Scanner tec;

	public ACMETrade() {
		 this.convencao = new Convencao();
		 this.paisArray = new ArrayList<>();
		 this.federacao = new Federacao();
		 this.acordosArray = new ArrayList<>();
		 this.tec = new Scanner(System.in);
	}

	public void executar() {
		int opcao = -1;
		while (opcao != 0) {
			System.out.println("========================");
			TelaIncial();
			System.out.print("Digite a opcao desejada: ");
			opcao = tec.nextInt();
			tec	.nextLine();
			System.out.println("========================");
			switch (opcao) {
				case 0:
					break;
				case 1:
					CadastrarPais();
					break;
				case 2:
					CadastrarAcordo();
					break;
				case 3:
					ConsultarPaisPorSigla();
					break;
				case 4:
					ConsultarAcordoPorCodigo();
					break;
			}
		}
	}

	public void TelaIncial() {
		System.out.print("ACMETRADE\n (Digite 0 para sair) \n [1] Cadastrar um novo pais \n [2] Cadastrar acordo \n [3] Consultar um país pela sigla ");
	}

	public void CadastrarPais() {

		System.out.print("Qual o nome do pais:");
		String nome = tec.nextLine();
		System.out.print("Qual a SIGLA do pais:");
		String sigla = tec.nextLine();

		for (Pais pais : paisArray) {
			if (pais.getSigla().equals(sigla)) {
				System.out.println(" Sigla repetida: " + pais.getSigla());
			} else {
				Pais newPais = new Pais(nome, sigla);
				paisArray.add(newPais);
				System.out.println(" Pais adicionado: " + newPais.getSigla() + newPais.getNome());
			}
		}
	}

	public void CadastrarAcordo() {

		System.out.print("Qual o código do acordo? ");
		int codigoAcordo = tec.nextInt();
		tec.nextLine();

		for (Acordo acordo : acordosArray) { // verifica o codigo
			if (acordo.getCodigo() == codigoAcordo) {
				System.out.println("erro - código repetido");
				return;
			}
		}

		System.out.print("Qual o país comprador do acordo? ");
		String nomePaisComprador = tec.nextLine();
		Pais paisComprador = null;
		for (Pais p : paisArray) {
			if (p.getNome().equalsIgnoreCase(nomePaisComprador)) {
				paisComprador = p;
				break;
			}
		}
		if (paisComprador == null) {
			System.out.println("erro - país comprador não encontrado");
			return;
		}
		for (Acordo acordo : acordosArray) {
			if (acordo.getPaisComprador().equals(paisComprador)) {
				System.out.println("erro - país comprador repetido");
				return;
			}
		}

		System.out.print("Qual o país vendedor do acordo? ");
		String nomePaisVendedor = tec.nextLine();
		Pais paisVendedor = null;
		for (Pais p : paisArray) {
			if (p.getNome().equalsIgnoreCase(nomePaisVendedor)) {
				paisVendedor = p;
				break;
			}
		}
		if (paisVendedor == null) {
			System.out.println("erro - país vendedor não encontrado");
			return;
		}

		for (Acordo acordo : acordosArray) {
			if (acordo.getPaisVendedor().equals(paisVendedor)) {
				System.out.println("erro - país vendedor repetido");
				return;
			}
		}

		System.out.print("Qual o produto do acordo? ");
		String produtoAcordo = tec.nextLine();

		System.out.print("Qual a taxa do acordo? ");
		double taxaAcordo = tec.nextDouble();

		Acordo acordoNovo = new Acordo(codigoAcordo, produtoAcordo, taxaAcordo, paisComprador, paisVendedor);
		acordosArray.add(acordoNovo);

		System.out.println("Acordo cadastrado com sucesso!");
	}

	public void ConsultarPaisPorSigla() {

		System.out.println(" Qual a sigla do pais? ");
		String s = tec.nextLine();

		for (Pais pais : paisArray) {
			if (pais.getSigla().equals(s)) {
				System.out.println(" Pais: " + pais.getSigla() + ", " + pais.getNome());
			} else {
				System.out.println("erro-sigla inexistente");
			}
		}
	}

	public void ConsultarAcordoPorCodigo() {

		System.out.println(" Qual o codigo do acordo? ");
		int codigoAcordo = tec.nextInt();
		for (Acordo acordo : acordosArray) {
			if (acordo.getCodigo() == codigoAcordo) {
				System.out.print(acordo.toString());
			} else {
				System.out.println("erro-codigo inexistente");
			}
		}
	}

	public void ConsultarAcordoPelaSiglaDoComprador() {
		System.out.println(" Qual a sigla do comprador? ");
	}





}
