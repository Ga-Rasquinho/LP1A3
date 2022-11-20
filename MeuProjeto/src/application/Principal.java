// Gabriel Fernandes Rasquinho - SP3084094
// Projeto para a disciplina LP1A3

package application;

import javax.swing.JOptionPane;

import entities.Aviao;
import entities.Passageiro;
import entities.Voo;

public class Principal {
	
	public static String menuPrincipal() {		
		String menuPrincipal = "Menu Principal\n"
				+ "1 - Parâmetros do Sistema\n"
				+ "2 - Reserva de Passagens\n"
				+ "3 - Sair";
		return menuPrincipal;
	}
	
	public static String menuParametroSistema() {
		String menuParametroSistema = "Parâmetros do Sistema\n"
				+ "1 - Cadastrar Aeronave\n"
				+ "2 - Cadastrar Voo\n"
				+ "3 - Voltar";
		return menuParametroSistema;
	} 
	
	public static String menuReservaPassagens() {
		String menuReservaPassagens = "Reserva de Passagens\n"
				+ "1 - Fazer reserva\n"
				+ "2 - Consultar lugares vazios\n"
				+ "3 - Consultar reservas realizadas\n"
				+ "4 - Voltar";
		return menuReservaPassagens;
	}
	
	public static String cadastroAeronave() {		
		String cadastroAeronave = JOptionPane.showInputDialog("Digite o nome da aeronave: ");
		return cadastroAeronave;
	}
	
	public static int cadastroFileiras() {
		String cadastroFileiras = "Digite a quantidade de fileiras: ";
		int fileira = verificarDigito(cadastroFileiras);
		return fileira;
	}
	
	public static int cadastroQtdCadeiras(){
		String cadastroQtdCadeiras = "";
		cadastroQtdCadeiras = "Digite a quantidade de cadeiras: ";
		int qtdCadeiras = verificarDigito(cadastroQtdCadeiras);
		return qtdCadeiras;
	}
	
	
	public static int cadastroVoo() {
		String cadastroVoo = "Quantos voos deseja cadastrar?";
		int qtdVoo = verificarDigito(cadastroVoo);
		return qtdVoo;
	}
	
	public static int mostrarVoo(Voo[] voo) {
		String vooDisponiveis = "Voos disponíveis: \n";
		for (int qtdVooDisponiveis = 0; qtdVooDisponiveis < voo.length; qtdVooDisponiveis++) {
			String voos = "\nNúmero do Voo: " + voo[qtdVooDisponiveis].getNro() + " Data: "
					+ voo[qtdVooDisponiveis].getData() + " Horário: " + voo[qtdVooDisponiveis].getHora();
			vooDisponiveis = vooDisponiveis.concat(voos);
		}
		String opcVoo = vooDisponiveis + "\n\nSelecione o número do voo: ";
		int selecVoo = verificarDigito(opcVoo);

		while (selecVoo > voo.length) {
			JOptionPane.showMessageDialog(null, "Número inválido");
			opcVoo = vooDisponiveis + "\n\nSelecione o número do voo: ";
			selecVoo = verificarDigito(opcVoo);
		}
		return selecVoo;
	}
	
	public static Aviao selecaoAviao(Voo[] voo, int selecVoo) {
		Aviao aviao = null;
		for (int selecAviao = 0; selecAviao < selecVoo; selecAviao++) {
			if (voo[selecAviao].getNro() == selecVoo) {
				aviao = voo[selecAviao].getAeronave();
			}
		}
		return aviao;
	}

	public static void realizarReservaPassagem(Voo[] voo) {

		int selecVoo = mostrarVoo(voo);

		Aviao aviao = selecaoAviao(voo, selecVoo);

		if (aviao.consultarLugaresDisponiveis() == null) {
			JOptionPane.showMessageDialog(null, "Não há lugares disponíveis");
			return;
		}
		boolean sucessoReserva = false;
		while (!sucessoReserva) {
			try {
				String opcFileira = aviao.consultarLugaresDisponiveis() + "\nDigite a fileira:";
				String opcAssento = aviao.consultarLugaresDisponiveis() + "\nDigite o assento:";
				int selecFileira = verificarDigito(opcFileira);
				int selecAssento = verificarDigito(opcAssento);

				aviao.setPassageiro(selecFileira, selecAssento, null);

				String nomePassageiro = JOptionPane.showInputDialog("Digite seu nome: ");
				String cpfPassageiro = JOptionPane.showInputDialog("Digite seu CPF: ");
				Passageiro passageiro = new Passageiro(nomePassageiro, cpfPassageiro);

				aviao.setPassageiro(selecFileira, selecAssento, passageiro);
				sucessoReserva = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Lugar inválido");
			}
		}
	}
	
	public static int verificarDigito(String texto) {
		int valorConvertido = 0;
		boolean sucesso = false;
		while (!sucesso) {
			try {
				String numero = JOptionPane.showInputDialog(texto);
				valorConvertido = Integer.parseInt(numero);
				sucesso = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite apenas números inteiros");
			} catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Digite um lugar válido");
			}
		}
		return valorConvertido;
	}

	public static void main(String[] args) {
		String modelo = null;
		int fileira = 0;
		int assento = 0;
		int qtdVoo = 1;
		Voo[] voo = new Voo[qtdVoo];

		boolean continuarExecutando = true;
		while (continuarExecutando) {
			int converterOpcMenuPrincipal = verificarDigito(menuPrincipal());
			switch (converterOpcMenuPrincipal) {
			case 1:
				int opcMenuParametro = verificarDigito(menuParametroSistema());
				switch (opcMenuParametro) {
				case 1:
					modelo = cadastroAeronave();
					fileira = cadastroFileiras();
					assento = cadastroQtdCadeiras();
					break;
				case 2:
					if (modelo != null) {
						qtdVoo = cadastroVoo();
						voo = new Voo[qtdVoo];
						for (int x = 0; x < qtdVoo; x++) {
							int nrmVoo = verificarDigito("Digite o número do voo");
							String data = JOptionPane.showInputDialog("Digite a data: ");
							String hora = JOptionPane.showInputDialog("Digita a hora: ");
							voo[x] = new Voo(new Aviao(modelo, fileira, assento), nrmVoo, data, hora);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"É necessário cadastrar uma aeronave antes de cadastrar um voo");
						break;
					}
				}
				break;
			case 2:
				if (voo[0] != null) {
					int converterOpcMenuPassagens = verificarDigito(menuReservaPassagens());
					switch (converterOpcMenuPassagens) {
					case 1:
						realizarReservaPassagem(voo);
						break;
					case 2:
						int selecVoo = mostrarVoo(voo);
						Aviao aviao = selecaoAviao(voo, selecVoo);
						if (aviao.existemLugaresDisponiveis()) {
							JOptionPane.showMessageDialog(null, aviao.consultarLugaresDisponiveis());
						} else {
							if (aviao.consultarLugaresDisponiveis() == null) {
								JOptionPane.showMessageDialog(null, "Não há lugares disponíveis");
								break;
							}
						}
						break;
					case 3:
						int selecVooOcupados = mostrarVoo(voo);
						aviao = selecaoAviao(voo, selecVooOcupados);
						JOptionPane.showMessageDialog(null, aviao.consultarLugaresOcupados());
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"É necessário cadastrar um voo antes de utilizar está funcionalidade");
					break;
				}
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso serviço!!!");
				continuarExecutando = false;
				break;
			}
		}

	}
}
