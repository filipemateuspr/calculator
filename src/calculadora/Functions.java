package calculadora;

public class Functions{
	
	private boolean haValores = false, novoCalculo = false, estaCalculando = false;
	private int tipoCalculo = 0;
	
	//Construtores
	public Functions() {}
	public Functions(boolean haValores, boolean novoCalculo, boolean estaCalculando, int tipoCalculo) {
		this.haValores = haValores;
		this.novoCalculo = novoCalculo;
		this.estaCalculando = estaCalculando;
		this.tipoCalculo = tipoCalculo;
	}
	
	//Getters e setters
	public boolean haValores() {
		return haValores;
	}
	public void setHaValores(boolean haValores) {
		this.haValores = haValores;
	}
	public boolean isNovoCalculo() {
		return novoCalculo;
	}
	public void setNovoCalculo(boolean novoCalculo) {
		this.novoCalculo = novoCalculo;
	}
	public boolean estaCalculando() {
		return estaCalculando;
	}
	public void setEstaCalculando(boolean estaCalculando) {
		this.estaCalculando = estaCalculando;
	}
	public int getTipoCalculo() {
		return tipoCalculo;
	}
	public void setTipoCalculo(int tipoCalculo) {
		this.tipoCalculo = tipoCalculo;
	}
	
	//Métodos (funções)
	public String converterValorVirgula(String valor) {
		valor = valor.replace(",", ".");
		return valor;
	}
	
	public String converterValorPonto(String valor) {
		valor = valor.replace(".", ",");
		return valor;
	}
	
	public String inserirTecla(String tecla) {
		return tecla;
	}
	
	public String realizarCalculo(int tipo, String valor1, String valor2) {
		double valorCampo01, valorCampo02;
		String resultado = null;
		switch(tipo) {
		case 107:
			valorCampo01 = Double.parseDouble(valor1);
			valorCampo02 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 + valorCampo02);
			break;
		case 106:
			valorCampo01 = Double.parseDouble(valor1);
			valorCampo02 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 * valorCampo02);
			break;
		case 111:
			valorCampo02 = Double.parseDouble(valor1);
			valorCampo01 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 / valorCampo02);
			break;
		case 109:
			valorCampo02 = Double.parseDouble(valor1);
			valorCampo01 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 - valorCampo02);
			break;
		}
		if(resultado == "Infinity" || resultado == "NaN") {resultado = "Cálculo inválido";}
		return converterValorPonto(resultado);
	}
	
	public String buscarCodigoTecla(int keyID) {
		String keyCode[] = new String[500];
		keyCode[48] = "0"; keyCode[96] = "0";
		keyCode[49] = "1"; keyCode[97] = "1";
		keyCode[50] = "2"; keyCode[98] = "2";
		keyCode[51] = "3"; keyCode[99] = "3";
		keyCode[52] = "4"; keyCode[100] = "4";
		keyCode[53] = "5"; keyCode[101] = "5";
		keyCode[54] = "6"; keyCode[102] = "6";
		keyCode[55] = "7"; keyCode[103] = "7";
		keyCode[56] = "8"; keyCode[104] = "8";
		keyCode[57] = "9"; keyCode[105] = "9";
		keyCode[106] = "X"; keyCode[107] = "+";
		keyCode[109] = "-"; keyCode[111] = "/";
		keyCode[110] = ","; keyCode[127] = "Delete";
		keyCode[8] = "Backspace"; keyCode[10] = "Enter";
		return keyCode[keyID];
	}
}
