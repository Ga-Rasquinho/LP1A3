package entities;

public class Aviao extends Aeronave{
	public Passageiro[][] lugares;
	
	public Aviao(String Aeronave, int fileira, int assentos) {
		super(Aeronave); 
	}

	public Passageiro[][] getLugares() {
		return lugares;
	}

	public void setLugares(Passageiro[][] lugares) {
		this.lugares = lugares;
	}
	
	public boolean verificarLugarOcupado(int fileira, int assentos ) {
		
		return true;
	}
}
