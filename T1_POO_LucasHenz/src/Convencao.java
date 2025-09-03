import java.util.ArrayList;
import java.util.Collection;

public class Convencao {

	private Collection<Acordo> acordo;

	public Convencao() {
		this.acordo = new ArrayList<Acordo>();
	}

	public Acordo consultarAcordo(int codigo) {
		for (Acordo a : acordo) {
			if(a.getCodigo() == codigo) {
				return a;
			}
		}
		return null;
	}

	public Acordo consultarAcordo(String sigla) {
		for (Acordo a : acordo) {
			if(a.getSiglaComprador() == sigla) {
				return a;
			}
		}
		return null;
	}

	public Acordo consultarAcordoPelaSiglaDoComprador(String a) {
		for (Acordo a1 : acordo) {
			if(a1.getSiglaComprador().equalsIgnoreCase(a)) {
				return a1;
			}
		}
		return null;
	}

	public boolean removerAcordoPelaSiglaDoComprador(String sigla) {
		for (Acordo a : acordo) {
			if(a.getSiglaComprador().equalsIgnoreCase(sigla)) {
				acordo.remove(a);
				return true;
			}
		}
		return false;
	}

	/*public String listarSiglaComprador() {
		for (Acordo a : acordo) {
			return a.getSiglaComprador();
		}
		return null;
	}

	public String listarAcordos() {
		for (Acordo a : acordo) {
			return a.getCodigo() + ": " + a.getProduto() + ": " + a.getTaxa() + ": " + a.getSiglaComprador() + ": " + a.getSiglaVendedor() + " ";
		}
		return null;
	}
	*/
	public Collection<Acordo> getAcordos() {
		return acordo;
	}

	public boolean adicionarAcordo(Acordo a) {
		int codigo = a.getCodigo();
		Acordo aux = consultarAcordo(codigo);
		if (aux == null) {
			acordo.add(a);
			return true;
		} else {
			return false;
		}
	}

}
