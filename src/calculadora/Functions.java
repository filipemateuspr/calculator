package unused.view;

public class Functions {
	
	private boolean haValores = false, estaSomando = false, estaSubtraindo = false, 
			        estaMultiplicando = false, estaDividindo = false, novoCalculo = false;
	
	//Construtores
	public Functions() {}
	public Functions(boolean haValores, boolean estaSomando, boolean estaSubtraindo, boolean estaMultiplicando, boolean estaDividindo, boolean novoCalculo) {
		this.haValores = haValores;
		this.estaSomando = estaSomando;
		this.estaSubtraindo = estaSubtraindo;
		this.estaMultiplicando = estaMultiplicando;
		this.estaDividindo = estaDividindo;
		this.novoCalculo = novoCalculo;
	}
	
	//Getters e setters
	public boolean haValores() {
		return haValores;
	}
	public void setHaValores(boolean haValores) {
		this.haValores = haValores;
	}
	public boolean estaSomando() {
		return estaSomando;
	}
	public void setEstaSomando(boolean estaSomando) {
		this.estaSomando = estaSomando;
	}
	public boolean estaSubtraindo() {
		return estaSubtraindo;
	}
	public void setEstaSubtraindo(boolean estaSubtraindo) {
		this.estaSubtraindo = estaSubtraindo;
	}
	public boolean estaMultiplicando() {
		return estaMultiplicando;
	}
	public void setEstaMultiplicando(boolean estaMultiplicando) {
		this.estaMultiplicando = estaMultiplicando;
	}
	public boolean estaDividindo() {
		return estaDividindo;
	}
	public void setEstaDividindo(boolean estaDividindo) {
		this.estaDividindo = estaDividindo;
	}
	public boolean isNovoCalculo() {
		return novoCalculo;
	}
	public void setNovoCalculo(boolean novoCalculo) {
		this.novoCalculo = novoCalculo;
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
		case 1:
			valorCampo01 = Double.parseDouble(valor1);
			valorCampo02 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 + valorCampo02);
			break;
		case 2:
			valorCampo01 = Double.parseDouble(valor1);
			valorCampo02 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 * valorCampo02);
			break;
		case 3:
			valorCampo02 = Double.parseDouble(valor1);
			valorCampo01 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 / valorCampo02);
			break;
		case 4:
			valorCampo02 = Double.parseDouble(valor1);
			valorCampo01 = Double.parseDouble(valor2);
			resultado = String.valueOf(valorCampo01 - valorCampo02);
			break;
		}
		if(resultado == "Infinity") {resultado = "Valor infinito";}
		return converterValorPonto(resultado);
	}
}
