package entities;

public class Aviao extends Aeronave {
	public int fileira;
	public int assentos;
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

	public void setPassageiro(int fileira, int assentos, final Passageiro passageiro) {
		lugares[fileira][assentos] = passageiro;
	}

	public boolean verificarLugarOcupado(int fileira, int assentos) {
		if (lugares[fileira][assentos] == null) {
			return true;
		} else {
			return false;
		}
	}

	public String consultarLugaresDisponiveis() {
		String lugaresDisponiveis = "Lugares Disponíveis";
		for (int i = 0; i < fileira; i++) {
			for (int x = 0; x < assentos; x++) {
				if (verificarLugarOcupado(i, x) == true) {
					String consultaLugares = "\nFileira: [" + i + "]" + " Assento: [" + x + "]";
					lugaresDisponiveis = lugaresDisponiveis.concat(consultaLugares);
				} else {
					lugaresDisponiveis = null;
				}
			}
		}
		return lugaresDisponiveis;
	}

	public String consultarLugaresOcupados() {
		String lugaresOcupados = "Lugares Reservados";
		for (int i = 0; i < fileira; i++) {
			for (int x = 0; x < assentos; x++) {
				if (verificarLugarOcupado(i, x) == false) {
					String consultaLugares = "\nFileira: [" + i + "]" + " Assento: [" + x + "]";
					lugaresOcupados = lugaresOcupados.concat(consultaLugares);
				}
			}
		}
		return lugaresOcupados;
	}
}
