package application;

import javax.swing.JOptionPane;

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
	
	public static void main(String[] args) {
		
		boolean continuarExecutando = true;
		while (continuarExecutando) {
			int converterOpcMenuPrincipal = Integer.parseInt(menuPrincipal());
			switch (converterOpcMenuPrincipal) {
			case 1:
				int converteOpcMenuParametro = Integer.parseInt(menuParametroSistema());
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
