package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Aviao;
import entities.Voo;

public class Principal {
	
	public static String menuPrincipal() {		
		String menuPrincipal = "";
		menuPrincipal = JOptionPane.showInputDialog("Menu Principal\n"
				+ "1 - Par�metros do Sistema\n"
				+ "2 - Reserva de Passagens\n"
				+ "3 - Sair");
		return menuPrincipal;
	}
	
	public static String menuParametroSistema() {
		String menuParametroSistema = "";
		menuParametroSistema = JOptionPane.showInputDialog("Par�metros do Sistema\n"
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

	public static void main(String[] args) throws IOException {
// Inicializando vetores
		int qtdAviao = 1;
		int qtdVoo = 1;
		Aviao[] aviao = new Aviao[qtdAviao];
		Voo[] voo = new Voo[qtdVoo];

		boolean continuarExecutando = true;
		while (continuarExecutando) {
			int converterOpcMenuPrincipal = Integer.parseInt(menuPrincipal());
			switch (converterOpcMenuPrincipal) {
			case 1:
				int opcMenuParametro = Integer.parseInt(menuParametroSistema());
				switch (opcMenuParametro) {
				case 1:
					String cadastroQtdAviao = "";
					cadastroQtdAviao = JOptionPane.showInputDialog("Quantos avi�es deseja cadastrar?");
					qtdAviao = Integer.parseInt(cadastroQtdAviao);
					aviao = new Aviao[qtdAviao];
					for (int i = 0; i < qtdAviao; i++) {
						String modelo = cadastroAeronave();
						int fileira = cadastroFileiras();
						int qtdCadeira = cadastroQtdCadeiras();
						aviao[i] = new Aviao(modelo, fileira, qtdCadeira);
					}
					break;
				case 2:
					qtdVoo = cadastroVoo();
					voo = new Voo[qtdVoo];
					for (int x = 0; x < qtdVoo; x++) {
						String numero = JOptionPane.showInputDialog("Digite o numero do voo: ");
						int nrmVoo = Integer.parseInt(numero);
						String data = JOptionPane.showInputDialog("Digite a data: ");
						String hora = JOptionPane.showInputDialog("Digita a hora: ");
						voo[x] = new Voo(aviao[x], nrmVoo, data, hora);
					}
				}
				break;
			case 2:
				int converterOpcMenuPassagens = Integer.parseInt(menuReservaPassagens());
				break;
			case 3:
				System.out.println("Saindo");
				continuarExecutando = false;
				break;
			}
		}
	}
}
