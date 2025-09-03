import java.util.ArrayList;
import java.util.Collection;

public class Federacao {

	private Collection<Pais> pais;

	public Federacao() {
		this.pais = new ArrayList<>();
	}

	public boolean adicionarPais(Pais p) {
		String sigla = p.getSigla();
		Pais aux = consultarPaisPorSigla(sigla);

		if (aux == null) { // pais nao cadastrada
			pais.add(p);
			return true;
		} else
			return false;
	}

	public Pais consultarPaisPorSigla(String sigla) {
		for(Pais p : pais) {
			if(p.getSigla().equalsIgnoreCase(sigla))
				return p;
		}
		return null;
	}

	public Collection<Pais> getPaises() {
		return pais;
	}


	public boolean mudarNomeDePais (String nome, Pais p) {
		p.setNome(nome);
		return true;
	}


}