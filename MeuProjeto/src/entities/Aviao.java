package entities;

public class Aviao extends Aeronave{
	public Passageiro[][] lugares;
	
	public Aviao() {
		
	}
	
	public Aviao(String aeronave, int fileira, int assentos) {
		super(aeronave);
		lugares = new Passageiro[fileira][assentos];
	}

	public Passageiro getPassageiro(int fileira, int assento) {
		return lugares[fileira][assento];
	}

	public void setPassageiro(int fileira, int assento, final Passageiro passageiro) {
		lugares[fileira][assento] = passageiro;
	}
	
	public boolean verificarLugarOcupado(int fileira, int assento ) {
		 if(lugares[fileira][assento] == null) {
			 return true;
		 } else {
			 return false;
		 }
	}
}
