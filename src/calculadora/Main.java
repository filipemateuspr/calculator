package calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private static JPanel painelGeral;
	protected static Component frame;
	private static JTextField tfCalculoNumeroInsercao;
	private static JTextField tfCalculoNumeroOperacao;
	private static JTextField tfCalculoExibeOperador;
	private static JTextField tfCalculoNumeroResultado;
	private final JTextField tfRastreadorTeclas = new JTextField();
	private static JTextField tfDicas;
	public static Functions cFunc = new Functions();
	public static String version = "v1.1.0";
	
	/* =================================================
	 * Inicializa a calculadora (gerado automaticamente)
	 * =================================================
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/* =================================
	 * Funções principais da calculadora
	 * =================================
	 */
	public static void realizarCalculo(int tipoCalc) {
		String valorConvertido1 = cFunc.converterValorVirgula(tfCalculoNumeroInsercao.getText());
		String valorConvertido2 = cFunc.converterValorVirgula(tfCalculoNumeroOperacao.getText());
		try {
			switch(tipoCalc) {
			case 107:
				tfCalculoNumeroResultado.setText(cFunc.realizarCalculo(tipoCalc, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				cFunc.setNovoCalculo(true);
				break;
			case 106:
				tfCalculoNumeroResultado.setText(cFunc.realizarCalculo(tipoCalc, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				cFunc.setNovoCalculo(true);
				break;
			case 111:
				tfCalculoNumeroResultado.setText(cFunc.realizarCalculo(tipoCalc, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				cFunc.setNovoCalculo(true);
				break;
			case 109:
				tfCalculoNumeroResultado.setText(cFunc.realizarCalculo(tipoCalc, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				cFunc.setNovoCalculo(true);
				break;
			default:
				tfDicas.setText("Verifique os campos e tente novamente.");
				break;
			}
			cFunc.setEstaCalculando(false);
		} catch(java.lang.NumberFormatException excecao) {
			tfDicas.setText("Verifique os campos e tente novamente.");
		}
	}
	
	//Função que limpa a tela
	public static void limparVisualizacao() {
		tfCalculoNumeroInsercao.setText(null);
		tfCalculoNumeroOperacao.setText(null);
		tfCalculoExibeOperador.setText(null);
		tfCalculoNumeroResultado.setText(null);
		tfDicas.setText(null);
		cFunc.setHaValores(false);
		cFunc.setNovoCalculo(false);
		cFunc.setEstaCalculando(false);
	}
	
	//Função que escreve os números na tela
	public static void escreverTecla(String teclaTipo, String teclaID) {
		if(teclaTipo.contains("#Key_numero") && teclaTipo != "#Key_virgula") {
			if(tfCalculoNumeroInsercao.getText().isBlank()) {
				tfCalculoNumeroInsercao.setText(cFunc.inserirTecla(teclaID));
			} else {
				tfCalculoNumeroInsercao.setText(tfCalculoNumeroInsercao.getText() + cFunc.inserirTecla(teclaID)); 
			}
		} else if(teclaTipo.contains("virgula")){
			if(tfCalculoNumeroInsercao.getText().isEmpty()) {
				tfDicas.setText("Virgula não pode ser usada no começo da operação.");
			} else if(tfCalculoNumeroInsercao.getText().contains(",")) {
				tfDicas.setText("Virgula já está sendo usada nessa operação.");
			} else {
				tfCalculoNumeroInsercao.setText(tfCalculoNumeroInsercao.getText() + cFunc.inserirTecla(teclaID)); 
			}
		}
	}
	
	//Função que define o tipo de calculo com base no operador
	public static void definirTipoCalculo(String operador) {
		if(tfCalculoNumeroInsercao.getText().isEmpty()) {
			tfDicas.setText("Não é possível realizar uma conta sem números!");
		} else {
			if(tfCalculoNumeroOperacao.getText().isEmpty()) {
				tfCalculoExibeOperador.setText(operador);
				tfCalculoNumeroOperacao.setText(tfCalculoNumeroInsercao.getText());
				tfDicas.setText(null);
				tfCalculoNumeroInsercao.setText(null);
				cFunc.setHaValores(true);
			}
			if(cFunc.isNovoCalculo() == true) {
				tfCalculoExibeOperador.setText(operador);
				tfCalculoNumeroOperacao.setText(tfCalculoNumeroResultado.getText());
				tfDicas.setText(null);
				tfCalculoNumeroInsercao.setText(null);
				tfCalculoNumeroResultado.setText(null);
				cFunc.setHaValores(true);
				cFunc.setNovoCalculo(false);
			}
		}
	}
	
	/* ===============================================================
	 * Construi a janela - Composto por trechos gerado automáticamente
	 * na criação dos componentes.
	 * ===============================================================
	 */
	public Main() {
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Calculadora " + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		painelGeral = new JPanel();
		painelGeral.setBackground(new Color(0, 0, 0));
		painelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(painelGeral);
		painelGeral.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULADORA");
		lblTitulo.setFocusable(false);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitulo.setBounds(0, 0, 484, 55);
		painelGeral.add(lblTitulo);
		
		JLabel lblVersao = new JLabel("Versão: " + version + " (06/06/2023)");
		lblVersao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVersao.setForeground(Color.WHITE);
		lblVersao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		lblVersao.setBounds(246, 589, 228, 22);
		painelGeral.add(lblVersao);
		
		JLabel lblCredito = new JLabel("Desenvolvido por: Filipe Mateus");
		lblCredito.setHorizontalAlignment(SwingConstants.LEFT);
		lblCredito.setForeground(Color.WHITE);
		lblCredito.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		lblCredito.setBounds(10, 589, 236, 22);
		painelGeral.add(lblCredito);
		
		JRadioButton rdbtnUsarTemaClaro = new JRadioButton("Usar Tema Claro");
		rdbtnUsarTemaClaro.setToolTipText("Marque esta opção para usar o tema claro (não recomendado).");
		rdbtnUsarTemaClaro.setFocusable(false);
		rdbtnUsarTemaClaro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rdbtnUsarTemaClaro.setBackground(new Color(0, 0, 0));
		rdbtnUsarTemaClaro.setForeground(new Color(255, 255, 255));
		rdbtnUsarTemaClaro.setBounds(314, 62, 132, 38);
		painelGeral.add(rdbtnUsarTemaClaro);
		rdbtnUsarTemaClaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnUsarTemaClaro.isSelected()) {
					painelGeral.setBackground(new Color(255, 255, 255));
					lblTitulo.setForeground(new Color(0, 0, 0));
					lblVersao.setForeground(new Color(0, 0, 0));
					lblCredito.setForeground(new Color(0, 0, 0));
					rdbtnUsarTemaClaro.setBackground(new Color(255, 255, 255));
					rdbtnUsarTemaClaro.setForeground(new Color(0, 0, 0));
					tfDicas.setForeground(new Color(0, 0, 0));
				} else {
					painelGeral.setBackground(new Color(0, 0, 0));
					lblTitulo.setForeground(new Color(255, 255, 255));
					lblVersao.setForeground(Color.WHITE);
					lblCredito.setForeground(Color.WHITE);
					rdbtnUsarTemaClaro.setBackground(new Color(0, 0, 0));
					rdbtnUsarTemaClaro.setForeground(new Color(255, 255, 255));
					tfDicas.setForeground(new Color(255, 255, 255));
				}
			}
		});
		
		//Botões de números
		JButton btnBotaoTecla0 = new JButton("0");
		btnBotaoTecla0.setFocusable(false);
		btnBotaoTecla0.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla0.setForeground(Color.WHITE);
		btnBotaoTecla0.setBackground(new Color(40, 40, 40));
		btnBotaoTecla0.setBounds(34, 525, 203, 62);
		painelGeral.add(btnBotaoTecla0);
		btnBotaoTecla0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "0");
			}
		});
		
		JButton btnBotaoTecla01 = new JButton("1");
		btnBotaoTecla01.setFocusable(false);
		btnBotaoTecla01.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla01.setForeground(new Color(255, 255, 255));
		btnBotaoTecla01.setBackground(new Color(40, 40, 40));
		btnBotaoTecla01.setBounds(34, 457, 100, 64);
		painelGeral.add(btnBotaoTecla01);
		btnBotaoTecla01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "1");
			}
		});
		
		JButton btnBotaoTecla02 = new JButton("2");
		btnBotaoTecla02.setFocusable(false);
		btnBotaoTecla02.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla02.setForeground(new Color(255, 255, 255));
		btnBotaoTecla02.setBackground(new Color(40, 40, 40));
		btnBotaoTecla02.setBounds(137, 457, 100, 64);
		painelGeral.add(btnBotaoTecla02);
		btnBotaoTecla02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "2");
			}
		});
		
		JButton btnBotaoTecla03 = new JButton("3");
		btnBotaoTecla03.setFocusable(false);
		btnBotaoTecla03.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla03.setForeground(new Color(255, 255, 255));
		btnBotaoTecla03.setBackground(new Color(40, 40, 40));
		btnBotaoTecla03.setBounds(240, 457, 76, 64);
		painelGeral.add(btnBotaoTecla03);
		btnBotaoTecla03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "3");
			}
		});
		
		JButton btnBotaoTecla04 = new JButton("4");
		btnBotaoTecla04.setFocusable(false);
		btnBotaoTecla04.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla04.setForeground(new Color(255, 255, 255));
		btnBotaoTecla04.setBackground(new Color(40, 40, 40));
		btnBotaoTecla04.setBounds(34, 389, 100, 64);
		painelGeral.add(btnBotaoTecla04);
		btnBotaoTecla04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "4");
			}
		});
		
		JButton btnBotaoTecla05 = new JButton("5");
		btnBotaoTecla05.setFocusable(false);
		btnBotaoTecla05.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla05.setForeground(new Color(255, 255, 255));
		btnBotaoTecla05.setBackground(new Color(40, 40, 40));
		btnBotaoTecla05.setBounds(137, 389, 100, 64);
		painelGeral.add(btnBotaoTecla05);
		btnBotaoTecla05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "5");
			}
		});
		
		JButton btnBotaoTecla06 = new JButton("6");
		btnBotaoTecla06.setFocusable(false);
		btnBotaoTecla06.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla06.setForeground(new Color(255, 255, 255));
		btnBotaoTecla06.setBackground(new Color(40, 40, 40));
		btnBotaoTecla06.setBounds(240, 389, 76, 64);
		painelGeral.add(btnBotaoTecla06);
		btnBotaoTecla06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "6");
			}
		});
		
		JButton btnBotaoTecla07 = new JButton("7");
		btnBotaoTecla07.setFocusable(false);
		btnBotaoTecla07.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla07.setForeground(new Color(255, 255, 255));
		btnBotaoTecla07.setBackground(new Color(40, 40, 40));
		btnBotaoTecla07.setBounds(34, 320, 100, 65);
		painelGeral.add(btnBotaoTecla07);
		btnBotaoTecla07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "7");
			}
		});
		
		JButton btnBotaoTecla08 = new JButton("8");
		btnBotaoTecla08.setFocusable(false);
		btnBotaoTecla08.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla08.setForeground(new Color(255, 255, 255));
		btnBotaoTecla08.setBackground(new Color(40, 40, 40));
		btnBotaoTecla08.setBounds(137, 320, 100, 65);
		painelGeral.add(btnBotaoTecla08);
		btnBotaoTecla08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "8");
			}
		});
		
		JButton btnBotaoTecla09 = new JButton("9");
		btnBotaoTecla09.setFocusable(false);
		btnBotaoTecla09.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTecla09.setForeground(new Color(255, 255, 255));
		btnBotaoTecla09.setBackground(new Color(40, 40, 40));
		btnBotaoTecla09.setBounds(240, 320, 76, 65);
		painelGeral.add(btnBotaoTecla09);
		btnBotaoTecla09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Key_numero", "9");
			}
		});
		
		JButton btnBotaoTeclaPonto = new JButton(",");
		btnBotaoTeclaPonto.setFocusable(false);
		btnBotaoTeclaPonto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaPonto.setForeground(Color.WHITE);
		btnBotaoTeclaPonto.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaPonto.setBounds(240, 525, 76, 62);
		painelGeral.add(btnBotaoTeclaPonto);
		btnBotaoTeclaPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverTecla("#Num_virgula", ",");
			}
		});
		
		//Botões de operações
		JButton btnBotaoTeclaLimpa = new JButton("C");
		btnBotaoTeclaLimpa.setToolTipText("Limpa todos os campos da calculadora.");
		btnBotaoTeclaLimpa.setFocusable(false);
		btnBotaoTeclaLimpa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaLimpa.setForeground(new Color(255, 255, 255));
		btnBotaoTeclaLimpa.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaLimpa.setBounds(240, 252, 76, 65);
		painelGeral.add(btnBotaoTeclaLimpa);
		btnBotaoTeclaLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparVisualizacao();
			}
		});
		
		JButton btnBotaoTeclaMais = new JButton("+");
		btnBotaoTeclaMais.setFocusable(false);
		btnBotaoTeclaMais.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaMais.setForeground(new Color(255, 255, 255));
		btnBotaoTeclaMais.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaMais.setBounds(319, 457, 128, 64);
		painelGeral.add(btnBotaoTeclaMais);
		btnBotaoTeclaMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirTipoCalculo("+");
				cFunc.setTipoCalculo(107);
			}
		});
		
		JButton btnBotaoTeclaVezes = new JButton("*");
		btnBotaoTeclaVezes.setFocusable(false);
		btnBotaoTeclaVezes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaVezes.setForeground(new Color(255, 255, 255));
		btnBotaoTeclaVezes.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaVezes.setBounds(319, 320, 128, 65);
		painelGeral.add(btnBotaoTeclaVezes);
		btnBotaoTeclaVezes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirTipoCalculo("X");
				cFunc.setTipoCalculo(106);
			}
		});
		
		JButton btnBotaoTeclaDivisao = new JButton("/");
		btnBotaoTeclaDivisao.setFocusable(false);
		btnBotaoTeclaDivisao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaDivisao.setForeground(Color.WHITE);
		btnBotaoTeclaDivisao.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaDivisao.setBounds(319, 252, 128, 65);
		painelGeral.add(btnBotaoTeclaDivisao);
		btnBotaoTeclaDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirTipoCalculo("/");
				cFunc.setTipoCalculo(111);
			}
		});
		
		JButton btnBotaoTeclaMenos = new JButton("-");
		btnBotaoTeclaMenos.setFocusable(false);
		btnBotaoTeclaMenos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaMenos.setForeground(Color.WHITE);
		btnBotaoTeclaMenos.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaMenos.setBounds(319, 389, 128, 64);
		painelGeral.add(btnBotaoTeclaMenos);
		btnBotaoTeclaMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirTipoCalculo("-");
				cFunc.setTipoCalculo(109);
			}
		});
		
		JButton btnBotaoTeclaCalcular = new JButton("Calcular");
		btnBotaoTeclaCalcular.setFocusable(false);
		btnBotaoTeclaCalcular.setToolTipText("Realiza o calculo dos números dos campos acima.");
		btnBotaoTeclaCalcular.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaCalcular.setForeground(Color.WHITE);
		btnBotaoTeclaCalcular.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaCalcular.setBounds(34, 252, 203, 65);
		painelGeral.add(btnBotaoTeclaCalcular);
		btnBotaoTeclaCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarCalculo(cFunc.getTipoCalculo());
			}
		});
		
		JButton btnBotaoTeclaDel = new JButton("Delete");
		btnBotaoTeclaDel.setToolTipText("Limpa todos os campos da calculadora.");
		btnBotaoTeclaDel.setFocusable(false);
		btnBotaoTeclaDel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnBotaoTeclaDel.setForeground(Color.WHITE);
		btnBotaoTeclaDel.setBackground(new Color(40, 40, 40));
		btnBotaoTeclaDel.setBounds(319, 525, 128, 62);
		painelGeral.add(btnBotaoTeclaDel);
		btnBotaoTeclaDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparVisualizacao();
			}
		});
		
		tfCalculoNumeroInsercao = new JTextField();
		tfCalculoNumeroInsercao.setFocusable(false);
		tfCalculoNumeroInsercao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		tfCalculoNumeroInsercao.setHorizontalAlignment(SwingConstants.CENTER);
		tfCalculoNumeroInsercao.setEditable(false);
		tfCalculoNumeroInsercao.setForeground(Color.WHITE);
		tfCalculoNumeroInsercao.setColumns(10);
		tfCalculoNumeroInsercao.setCaretColor(new Color(50, 50, 50));
		tfCalculoNumeroInsercao.setBackground(new Color(50, 50, 50));
		tfCalculoNumeroInsercao.setBounds(34, 101, 413, 88);
		painelGeral.add(tfCalculoNumeroInsercao);
		
		tfCalculoNumeroOperacao = new JTextField();
		tfCalculoNumeroOperacao.setFocusable(false);
		tfCalculoNumeroOperacao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		tfCalculoNumeroOperacao.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCalculoNumeroOperacao.setEditable(false);
		tfCalculoNumeroOperacao.setForeground(Color.WHITE);
		tfCalculoNumeroOperacao.setColumns(10);
		tfCalculoNumeroOperacao.setCaretColor(new Color(50, 50, 50));
		tfCalculoNumeroOperacao.setBackground(new Color(50, 50, 50));
		tfCalculoNumeroOperacao.setBounds(34, 59, 236, 42);
		painelGeral.add(tfCalculoNumeroOperacao);
		
		tfCalculoExibeOperador = new JTextField();
		tfCalculoExibeOperador.setFocusable(false);
		tfCalculoExibeOperador.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		tfCalculoExibeOperador.setHorizontalAlignment(SwingConstants.CENTER);
		tfCalculoExibeOperador.setEditable(false);
		tfCalculoExibeOperador.setForeground(Color.WHITE);
		tfCalculoExibeOperador.setColumns(10);
		tfCalculoExibeOperador.setCaretColor(new Color(50, 50, 50));
		tfCalculoExibeOperador.setBackground(new Color(50, 50, 50));
		tfCalculoExibeOperador.setBounds(269, 59, 45, 42);
		painelGeral.add(tfCalculoExibeOperador);
		
		tfCalculoNumeroResultado = new JTextField();
		tfCalculoNumeroResultado.setFocusable(false);
		tfCalculoNumeroResultado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		tfCalculoNumeroResultado.setHorizontalAlignment(SwingConstants.CENTER);
		tfCalculoNumeroResultado.setEditable(false);
		tfCalculoNumeroResultado.setForeground(Color.WHITE);
		tfCalculoNumeroResultado.setColumns(10);
		tfCalculoNumeroResultado.setCaretColor(new Color(50, 50, 50));
		tfCalculoNumeroResultado.setBackground(new Color(50, 50, 50));
		tfCalculoNumeroResultado.setBounds(34, 189, 413, 42);
		painelGeral.add(tfCalculoNumeroResultado);
		
		tfDicas = new JTextField();
		tfDicas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		tfDicas.setBorder(null);
		tfDicas.setHorizontalAlignment(SwingConstants.CENTER);
		tfDicas.setRequestFocusEnabled(false);
		tfDicas.setSelectionColor(new Color(0, 255, 64));
		tfDicas.setSelectedTextColor(new Color(0, 255, 64));
		tfDicas.setBackground(new Color(0, 0, 0));
		tfDicas.setDisabledTextColor(new Color(128, 255, 0));
		tfDicas.setOpaque(false);
		tfDicas.setForeground(new Color(255, 255, 255));
		tfDicas.setEditable(false);
		tfDicas.setBounds(34, 227, 412, 30);
		painelGeral.add(tfDicas);
		tfDicas.setColumns(10);
		
		//Frame usado para rastrear as teclas digitadas pelo usuário
		tfRastreadorTeclas.setEditable(false);
		tfRastreadorTeclas.setBackground(new Color(0, 0, 0));
		tfRastreadorTeclas.setBounds(0, -29, 484, 640);
		painelGeral.add(tfRastreadorTeclas);
		tfRastreadorTeclas.setColumns(10);
		tfRastreadorTeclas.setOpaque(false);
		tfRastreadorTeclas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	if(evt.getKeyCode() == 106 || evt.getKeyCode() == 107 || evt.getKeyCode() == 109 || evt.getKeyCode() == 111) {
            		if(cFunc.estaCalculando() == false) {
                		cFunc.setTipoCalculo(evt.getKeyCode());
                		definirTipoCalculo(cFunc.buscarCodigoTecla(evt.getKeyCode()));
                		cFunc.setEstaCalculando(true);
            		} else {
            			tfDicas.setText("Uma operação já está sendo realizada!");
            		}
            	} else if(evt.getKeyCode() == 110) {
            		escreverTecla("#Key_virgula", ",");
            	} else if(evt.getKeyCode() == 127 || evt.getKeyCode() == 8) {
            		limparVisualizacao();
            	} else if(evt.getKeyCode() == 10) {
            		realizarCalculo(cFunc.getTipoCalculo());
            	} else {
            		escreverTecla("#Key_numero", cFunc.buscarCodigoTecla(evt.getKeyCode()));
            	}
            }
        });
	}
}
