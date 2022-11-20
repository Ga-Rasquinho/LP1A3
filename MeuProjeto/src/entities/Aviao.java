package entities;

public class Aviao extends Aeronave {
	private int fileira;
	private int assentos;
	public Passageiro[][] lugares;

	public Aviao() {

	}

	public Aviao(String aeronave, int fileira, int assentos) {
		super(aeronave);
		this.fileira = fileira;
		this.assentos = assentos;
		lugares = new Passageiro[fileira][assentos];
	}

	public Passageiro getPassageiro(int fileira, int assentos) {
		return lugares[fileira][assentos];
	}

	public void setPassageiro(int fileira, int assentos, Passageiro passageiro) {
		lugares[fileira][assentos] = passageiro;
	}	

	public boolean verificarLugarOcupado(int fileira, int assentos) {
		if (lugares[fileira][assentos] == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existemLugaresDisponiveis() {
		boolean lugaresDisponiveis = false;
		for (int i = 0; i < fileira; i++) {
			for (int x = 0; x < assentos; x++) {
				if (verificarLugarOcupado(i, x) == true) {
					lugaresDisponiveis = true;
					break;
				}
			}
		}
		return lugaresDisponiveis;
	}
	
	public String consultarLugaresDisponiveis() {
		String lugaresDisponiveis = "Lugares disponíveis nesse voo: ";
		int contLugaresDisponiveis = 0;
		for (int i = 0; i < fileira; i++) {
			for (int x = 0; x < assentos; x++) {
				if (verificarLugarOcupado(i, x) == true) {
					String consultaLugares = "\nFileira: [" + i + "]" + " Assento: [" + x + "]";
					lugaresDisponiveis = lugaresDisponiveis.concat(consultaLugares);
					contLugaresDisponiveis++;
				}
			}
		}
		if (contLugaresDisponiveis == 0) {
			lugaresDisponiveis = null;
			return lugaresDisponiveis;
		} else {
			return lugaresDisponiveis;
		}
	}

	public String consultarLugaresOcupados() {
		String lugaresOcupados = "Lugares reservados nesse voo: ";
		int contarLugaresOcupados = 0;
		for (int i = 0; i < fileira; i++) {
			for (int x = 0; x < assentos; x++) {
				if (verificarLugarOcupado(i, x) == false) {
					String consultaLugares = "\nFileira: [" + i + "]" + " Assento: [" + x + "]";
					lugaresOcupados = lugaresOcupados.concat(consultaLugares);
					contarLugaresOcupados++;
				}
			}
		}
		if (contarLugaresOcupados == 0) {
			return lugaresOcupados = "Ainda não reservaram lugares nesse voo";
		} else {
			return lugaresOcupados;
		}
		
	}
}
