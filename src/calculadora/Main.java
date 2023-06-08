package unused.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private static JPanel painelGeral;
	protected static Component frame;
	private static JTextField tfNumeroInserido;
	private static JTextField tfNumeroSomando;
	private static JTextField tfOperador;
	private static JTextField tfNumeroResultado;
	private final JTextField tfRastreioTeclas = new JTextField();
	private static JTextField tfDicas;
	public static Functions calc = new Functions();
	public static String version = "v1.0.6";
	
	//Inicializa a aplicação (gerado automaticamente)
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
	
	//Funções da calculadora
	public static void realizarCalculo() {
		String valorConvertido1 = calc.converterValorVirgula(tfNumeroInserido.getText());
		String valorConvertido2 = calc.converterValorVirgula(tfNumeroSomando.getText());
		try {
			if(calc.estaSomando() == true) {
				tfNumeroResultado.setText(calc.realizarCalculo(1, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				calc.setNovoCalculo(true);
			} else if(calc.estaMultiplicando() == true) {
				tfNumeroResultado.setText(calc.realizarCalculo(2, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				calc.setNovoCalculo(true);
			} else if(calc.estaDividindo() == true) {
				tfNumeroResultado.setText(calc.realizarCalculo(3, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				calc.setNovoCalculo(true);
			} else if(calc.estaSubtraindo() == true) {
				tfNumeroResultado.setText(calc.realizarCalculo(4, valorConvertido1, valorConvertido2));
				tfDicas.setText(null);
				calc.setNovoCalculo(true);
			} else {
				tfDicas.setText("Verifique os campos e tente novamente.");
			}
		} catch(java.lang.NumberFormatException excecao) {
			tfDicas.setText("Verifique os campos e tente novamente.");
		}
	}
	
	//Função que limpa a tela
	public static void limparVisualizacao() {
		tfNumeroInserido.setText(null);
		tfNumeroSomando.setText(null);
		tfOperador.setText(null);
		tfNumeroResultado.setText(null);
		tfDicas.setText(null);
		calc.setHaValores(false);
		calc.setEstaDividindo(false);
		calc.setEstaMultiplicando(false);
		calc.setEstaSomando(false);
		calc.setEstaSubtraindo(false);
		calc.setNovoCalculo(false);
	}
	
	//Função que escreve os números na tela
	public static void escreverTecla(String teclaTipo, String teclaID) {
		if(teclaTipo.contains("#Num") && teclaTipo != "#Num_virgula") {
			if(tfNumeroInserido.getText().isBlank()) {
				tfNumeroInserido.setText(calc.inserirTecla(teclaID));
			} else {
				tfNumeroInserido.setText(tfNumeroInserido.getText() + calc.inserirTecla(teclaID)); 
			}
		} else if(teclaTipo.contains("virgula")){
			if(tfNumeroInserido.getText().isEmpty()) {
				tfDicas.setText("Virgula não pode ser usada no começo da operação.");
			} else if(tfNumeroInserido.getText().contains(",")) {
				tfDicas.setText("Virgula já está sendo usada nessa operação.");
			} else {
				tfNumeroInserido.setText(tfNumeroInserido.getText() + calc.inserirTecla(teclaID)); 
			}
		}
	}
	
	//Função que define o tipo de calculo com base no operador
	public static void definirTipoCalculo(String operador) {
		if(tfNumeroInserido.getText().isEmpty()) {
			tfDicas.setText("Não é possível realizar uma conta sem números!");
		} else {
			if(tfNumeroSomando.getText().isEmpty()) {
				tfOperador.setText(operador);
				tfNumeroSomando.setText(tfNumeroInserido.getText());
				tfDicas.setText(null);
				tfNumeroInserido.setText(null);
				calc.setHaValores(true);
			}
			if(calc.isNovoCalculo() == true) {
				tfOperador.setText(operador);
				tfNumeroSomando.setText(tfNumeroResultado.getText());
				tfDicas.setText(null);
				tfNumeroInserido.setText(null);
				tfNumeroResultado.setText(null);
				calc.setHaValores(true);
				calc.setEstaDividindo(false);
				calc.setEstaMultiplicando(false);
				calc.setEstaSomando(false);
				calc.setEstaSubtraindo(false);
				calc.setNovoCalculo(false);
			}
		}
	}
	
	//Cria o frame, composto por trechos gerado no design da tela
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
		
		JLabel lblVersao = new JLabel("Versão: " + version + " (04/06/2023)");
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
				escreverTecla("#Num", "0");
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
				escreverTecla("#Num", "1");
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
				escreverTecla("#Num", "2");
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
				escreverTecla("#Num", "3");
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
				escreverTecla("#Num", "4");
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
				escreverTecla("#Num", "5");
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
				escreverTecla("#Num", "6");
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
				escreverTecla("#Num", "7");
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
				escreverTecla("#Num", "8");
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
				escreverTecla("#Num", "9");
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
				calc.setEstaSomando(true);
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
				calc.setEstaMultiplicando(true);
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
				calc.setEstaDividindo(true);
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
				calc.setEstaSubtraindo(true);
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
				realizarCalculo();
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
		
		tfNumeroInserido = new JTextField();
		tfNumeroInserido.setFocusable(false);
		tfNumeroInserido.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		tfNumeroInserido.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumeroInserido.setEditable(false);
		tfNumeroInserido.setForeground(Color.WHITE);
		tfNumeroInserido.setColumns(10);
		tfNumeroInserido.setCaretColor(new Color(50, 50, 50));
		tfNumeroInserido.setBackground(new Color(50, 50, 50));
		tfNumeroInserido.setBounds(34, 101, 413, 88);
		painelGeral.add(tfNumeroInserido);
		
		tfNumeroSomando = new JTextField();
		tfNumeroSomando.setFocusable(false);
		tfNumeroSomando.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		tfNumeroSomando.setHorizontalAlignment(SwingConstants.TRAILING);
		tfNumeroSomando.setEditable(false);
		tfNumeroSomando.setForeground(Color.WHITE);
		tfNumeroSomando.setColumns(10);
		tfNumeroSomando.setCaretColor(new Color(50, 50, 50));
		tfNumeroSomando.setBackground(new Color(50, 50, 50));
		tfNumeroSomando.setBounds(34, 59, 236, 42);
		painelGeral.add(tfNumeroSomando);
		
		tfOperador = new JTextField();
		tfOperador.setFocusable(false);
		tfOperador.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		tfOperador.setHorizontalAlignment(SwingConstants.CENTER);
		tfOperador.setEditable(false);
		tfOperador.setForeground(Color.WHITE);
		tfOperador.setColumns(10);
		tfOperador.setCaretColor(new Color(50, 50, 50));
		tfOperador.setBackground(new Color(50, 50, 50));
		tfOperador.setBounds(269, 59, 45, 42);
		painelGeral.add(tfOperador);
		
		tfNumeroResultado = new JTextField();
		tfNumeroResultado.setFocusable(false);
		tfNumeroResultado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		tfNumeroResultado.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumeroResultado.setEditable(false);
		tfNumeroResultado.setForeground(Color.WHITE);
		tfNumeroResultado.setColumns(10);
		tfNumeroResultado.setCaretColor(new Color(50, 50, 50));
		tfNumeroResultado.setBackground(new Color(50, 50, 50));
		tfNumeroResultado.setBounds(34, 189, 413, 42);
		painelGeral.add(tfNumeroResultado);
		
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
		tfRastreioTeclas.setEditable(false);
		tfRastreioTeclas.setBackground(new Color(0, 0, 0));
		tfRastreioTeclas.setBounds(0, -29, 484, 640);
		painelGeral.add(tfRastreioTeclas);
		tfRastreioTeclas.setColumns(10);
		tfRastreioTeclas.setOpaque(false);
		
		tfRastreioTeclas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                   if (evt.getKeyCode() == 96) {
                	   escreverTecla("#Num_NUMPAD_0", "0");
                   } else if (evt.getKeyCode() == 97) {
                	   escreverTecla("#Num_NUMPAD_1", "1");
                   } else if (evt.getKeyCode() == 98) {
                	   escreverTecla("#Num_NUMPAD_2", "2");
                   } else if (evt.getKeyCode() == 99) {
                	   escreverTecla("#Nume_NUMPAD_3", "3");
                   } else if (evt.getKeyCode() == 100) {
                	   escreverTecla("#Num_NUMPAD_4", "4");
                   } else if (evt.getKeyCode() == 101) {
                	   escreverTecla("#Num_NUMPAD_5", "5");
                   } else if (evt.getKeyCode() == 102) {
                	   escreverTecla("#Num_NUMPAD_6", "6");
                   } else if (evt.getKeyCode() == 103) {
                	   escreverTecla("#Num_NUMPAD_7", "7");
                   } else if (evt.getKeyCode() == 104) {
                	   escreverTecla("#Num_NUMPAD_8", "8");
                   } else if (evt.getKeyCode() == 105) {
                	   escreverTecla("#Num_NUMPAD_9", "9");
                   } else if(evt.getKeyCode() == 110) {
                	   escreverTecla("#Num_virgula", ",");
                   } else if (evt.getKeyCode() == 106) {
                	   escreverTecla("#Op_NUMPAD_multiplicacao", "X");
                	   definirTipoCalculo("*");
                	   calc.setEstaMultiplicando(true);
                   } else if(evt.getKeyCode() == 107) {
                	   escreverTecla("#Op_NUMPAD_adicao", "+");
                	   definirTipoCalculo("+");
                	   calc.setEstaSomando(true);
                   } else if(evt.getKeyCode() == 109) {
                	   escreverTecla("#Op_NUMPAD_subtracao", "-");
                	   definirTipoCalculo("-");
                	   calc.setEstaSubtraindo(true);
                   } else if(evt.getKeyCode() == 111) {
                	   escreverTecla("#Op_NUMPAD_divisao", "/");
                	   definirTipoCalculo("/");
                	   calc.setEstaDividindo(true);
                   } else if(evt.getKeyCode() == 127) {
                	   escreverTecla("#Op_KEY_delete", "Delete");
                	   limparVisualizacao();
                   } else if(evt.getKeyCode() == 8) {
                	   escreverTecla("#Op_KEY_backspace", "Backspace");
                	   limparVisualizacao();
                   } else if(evt.getKeyCode() == 10) {
                	   escreverTecla("#Op_KEY_genericEnter", "Enter");
                	   realizarCalculo();
                   }
            }
        });
	}
}
