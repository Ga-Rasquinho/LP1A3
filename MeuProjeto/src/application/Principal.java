package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Aviao;
import entities.Passageiro;
import entities.Voo;

public class Principal {
	
	public static String menuPrincipal() {		
		String menuPrincipal = "";
		menuPrincipal = JOptionPane.showInputDialog("Menu Principal\n"
				+ "1 - Parâmetros do Sistema\n"
				+ "2 - Reserva de Passagens\n"
				+ "3 - Sair");
		return menuPrincipal;
	}
	
	public static String menuParametroSistema() {
		String menuParametroSistema = "";
		menuParametroSistema = JOptionPane.showInputDialog("Parâmetros do Sistema\n"
				+ "1 - Cadastrar Aeronave\n"
				+ "2 - Cadastrar Voo\n"
				+ "3 - Voltar");
		return menuParametroSistema;
	} 
	
	public static String menuReservaPassagens() {
		String menuReservaPassagens = "";
		menuReservaPassagens = JOptionPane.showInputDialog("Reserva de Passagens\n"
				+ "1 - Fazer reserva\n"
				+ "2 - Consultar lugares vazios\n"
				+ "3 - Consultar reservas realizadas\n"
				+ "4 - Voltar");
		return menuReservaPassagens;
	}
	
	public static String cadastroAeronave() {		
		String cadastroAeronave = "";
		cadastroAeronave = JOptionPane.showInputDialog("Digite o nome da aeronave: ");
		return cadastroAeronave;
	}
	
	public static int cadastroFileiras() {
		String cadastroFileiras = "";
		cadastroFileiras = JOptionPane.showInputDialog("Digite a quantidade de fileiras: ");
		int fileira = Integer.parseInt(cadastroFileiras);
		return fileira;
	}
	
	public static int cadastroQtdCadeiras(){
		String cadastroQtdCadeiras = "";
		cadastroQtdCadeiras = JOptionPane.showInputDialog("Digite a quantidade de cadeiras: ");
		int qtdCadeiras = Integer.parseInt(cadastroQtdCadeiras);
		return qtdCadeiras;
	}
	
	
	public static int cadastroVoo() {
		String cadastroVoo = "";
		cadastroVoo = JOptionPane.showInputDialog("Quantos voos deseja cadastrar?");
		int qtdVoo = Integer.parseInt(cadastroVoo);
		return qtdVoo;
	}
	
	public static void alterarPassageiro() {
		
	}

	public static void main(String[] args) throws IOException {
// Inicializando vetores
		String modelo = "";
		int fileira = 0;
		int assento = 0;
		int qtdVoo = 1;
		Aviao aviao = null;
//		Aviao aviao = new Aviao();
		Voo[] voo = new Voo[qtdVoo];

		boolean continuarExecutando = true;
		while (continuarExecutando) {
			int converterOpcMenuPrincipal = Integer.parseInt(menuPrincipal());
			switch (converterOpcMenuPrincipal) {
			case 1:
				int opcMenuParametro = Integer.parseInt(menuParametroSistema());
				switch (opcMenuParametro) {
				case 1:
					modelo = cadastroAeronave();
					fileira = cadastroFileiras();
					assento = cadastroQtdCadeiras();
					break;
				case 2:
					qtdVoo = cadastroVoo();
					voo = new Voo[qtdVoo];
					for (int x = 0; x < qtdVoo; x++) {
						String numero = JOptionPane.showInputDialog("Digite o numero do voo: ");
						int nrmVoo = Integer.parseInt(numero);
						String data = JOptionPane.showInputDialog("Digite a data: ");
						String hora = JOptionPane.showInputDialog("Digita a hora: ");
						voo[x] = new Voo(new Aviao(modelo, fileira, assento), nrmVoo, data, hora);
					}
				}
				break;
			case 2:
				int converterOpcMenuPassagens = Integer.parseInt(menuReservaPassagens());
				switch (converterOpcMenuPassagens) {
				case 1:
					String vooDisponiveis = "Voos disponíveis: \n";
					for (int qtdVooDisponiveis = 0; qtdVooDisponiveis < voo.length; qtdVooDisponiveis++) {
						String voos = "\nNúmero do Voo: " + voo[qtdVooDisponiveis].getNro() + " Data: "
								+ voo[qtdVooDisponiveis].getData() + " Horário: " + voo[qtdVooDisponiveis].getHora();
						vooDisponiveis = vooDisponiveis.concat(voos);
					}

					 String opcVoo = JOptionPane.showInputDialog(vooDisponiveis + "\n\nSelecione o número do voo: ");
					 int selecVoo = Integer.parseInt(opcVoo);
					 

					 for(int selecAviao = 0; selecAviao < selecVoo; selecAviao++) {
						 	if(voo[selecAviao].getNro() == selecVoo) {
						 		aviao = voo[selecAviao].getAeronave();
						 	}
					 }

					if (aviao.consultarLugaresDisponiveis() == null) {
						JOptionPane.showMessageDialog(null, "Não há lugares disponíveis");
						break;
					}

					String opcFileira = JOptionPane
							.showInputDialog(aviao.consultarLugaresDisponiveis() + "\nDigite a fileira:");
					String opcAssento = JOptionPane
							.showInputDialog(aviao.consultarLugaresDisponiveis() + "\nDigite o assento:");
					int selecFileira = Integer.parseInt(opcFileira);
					int selecAssento = Integer.parseInt(opcAssento);

					String nomePassageiro = JOptionPane.showInputDialog("Digite seu nome: ");
					String cpfPassageiro = JOptionPane.showInputDialog("Digite seu CPF: ");
					Passageiro passageiro = new Passageiro(nomePassageiro, cpfPassageiro);					
					

					aviao.setPassageiro(selecFileira, selecAssento, passageiro);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, aviao.consultarLugaresDisponiveis());
					break;
				case 3:
					JOptionPane.showMessageDialog(null, aviao.consultarLugaresOcupados());
					break;
				}
				break;
			case 3:
				System.out.println("Saindo");
				continuarExecutando = false;
				break;
			}
		}
	}
}
