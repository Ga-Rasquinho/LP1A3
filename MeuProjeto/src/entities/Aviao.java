package entities;

public class Aviao extends Aeronave{
	public Passageiro[][] lugares;
	
	public Aviao(String Aeronave, int fileira, int assentos) {
		super(Aeronave);
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
