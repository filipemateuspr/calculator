package calculadora;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField tfCampoResulta;
	private JTextField tfCampo01;
	private JTextField tfCampo02;
	private JCheckBox cbxContaMais;
	protected Component frame;
	private JLabel lblResultado;
	private JCheckBox cbxContaMenos;
	private JLabel lblSinal;
	private JCheckBox cbxContaDivisao;
	private JCheckBox cbxContaMultiplicacao;
	public static double primeiroValor = 0, segundoValor = 0;
	public static String version = "v0.0.1";
	
	/**
	 * Launch the application.
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

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("Calculadora " + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteAlgumaCoisa = new JLabel("Primeiro número:");
		lblDigiteAlgumaCoisa.setForeground(new Color(255, 255, 255));
		lblDigiteAlgumaCoisa.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDigiteAlgumaCoisa.setBounds(12, 0, 175, 44);
		contentPane.add(lblDigiteAlgumaCoisa);
		
		JLabel lblDigiteOutraCoisa = new JLabel("Segundo número:");
		lblDigiteOutraCoisa.setForeground(new Color(255, 255, 255));
		lblDigiteOutraCoisa.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDigiteOutraCoisa.setBounds(12, 36, 191, 44);
		contentPane.add(lblDigiteOutraCoisa);
		
		tfCampoResulta = new JTextField();
		tfCampoResulta.setForeground(new Color(255, 255, 255));
		tfCampoResulta.setCaretColor(new Color(51, 51, 51));
		tfCampoResulta.setBackground(new Color(85, 87, 83));
		tfCampoResulta.setEditable(false);
		tfCampoResulta.setBounds(180, 117, 100, 38);
		contentPane.add(tfCampoResulta);
		tfCampoResulta.setColumns(10);
		
		JButton btnNewButton = new JButton("REALIZAR CALCULO");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setEnabled(true);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(46, 52, 54));
		btnNewButton.setToolTipText("Ao pressionar, a conta será realizada!");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(cbxContaMais.isSelected() == true) {
						lblSinal.setText("+");
						primeiroValor = Integer.parseInt(tfCampo01.getText());
						segundoValor = Integer.parseInt(tfCampo02.getText());
						tfCampo01.setText(null);
						tfCampo02.setText(null);
						double resulta = primeiroValor + segundoValor;
						tfCampoResulta.setText(String.valueOf(resulta));
					} else if(cbxContaMenos.isSelected() == true){
						lblSinal.setText("-");
						primeiroValor = Integer.parseInt(tfCampo01.getText());
						segundoValor = Integer.parseInt(tfCampo02.getText());
						tfCampo01.setText(null);
						tfCampo02.setText(null);
						double resulta = primeiroValor - segundoValor;
						tfCampoResulta.setText(String.valueOf(resulta));
					} else if(cbxContaDivisao.isSelected() == true){
						lblSinal.setText("/");
						primeiroValor = Integer.parseInt(tfCampo01.getText());
						segundoValor = Integer.parseInt(tfCampo02.getText());
						tfCampo01.setText(null);
						tfCampo02.setText(null);
						double resulta = primeiroValor / segundoValor;
						tfCampoResulta.setText(String.valueOf(resulta));
					} else if(cbxContaMultiplicacao.isSelected() == true){
						lblSinal.setText("X");
						primeiroValor = Integer.parseInt(tfCampo01.getText());
						segundoValor = Integer.parseInt(tfCampo02.getText());
						tfCampo01.setText(null);
						tfCampo02.setText(null);
						double resulta = primeiroValor * segundoValor;
						tfCampoResulta.setText(String.valueOf(resulta));
					} else {
						JOptionPane.showMessageDialog(frame, "É necessário selecionar um tipo de cálculo!");
					}
				} catch (NumberFormatException ex) {
					System.err.print("Ocorreu uma exceção ("+ex+"):\n-> O idiota digitou uma letra! Não é número!\n");
				}
			}
		});
		btnNewButton.setBounds(12, 167, 412, 83);
		contentPane.add(btnNewButton);
		
		tfCampo01 = new JTextField();
		tfCampo01.setForeground(new Color(255, 255, 255));
		tfCampo01.setCaretColor(new Color(255, 255, 255));
		tfCampo01.setSelectedTextColor(new Color(255, 255, 255));
		tfCampo01.setBackground(new Color(85, 87, 83));
		tfCampo01.setBounds(180, 4, 100, 38);
		contentPane.add(tfCampo01);
		tfCampo01.setColumns(10);
		
		tfCampo02 = new JTextField();
		tfCampo02.setForeground(new Color(255, 255, 255));
		tfCampo02.setCaretColor(new Color(51, 51, 51));
		tfCampo02.setBackground(new Color(85, 87, 83));
		tfCampo02.setColumns(10);
		tfCampo02.setBounds(180, 42, 100, 38);
		contentPane.add(tfCampo02);
		
		cbxContaMais = new JCheckBox("Adição");
		cbxContaMais.setForeground(new Color(255, 255, 255));
		cbxContaMais.setBackground(new Color(0, 0, 0));
		cbxContaMais.setBounds(286, 6, 128, 12);
		contentPane.add(cbxContaMais);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Dialog", Font.BOLD, 20));
		lblResultado.setBounds(72, 118, 115, 38);
		contentPane.add(lblResultado);
		
		cbxContaMenos = new JCheckBox("Subtração");
		cbxContaMenos.setForeground(Color.WHITE);
		cbxContaMenos.setBackground(Color.BLACK);
		cbxContaMenos.setBounds(286, 19, 134, 12);
		contentPane.add(cbxContaMenos);
		
		lblSinal = new JLabel("==");
		lblSinal.setForeground(Color.WHITE);
		lblSinal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSinal.setBounds(199, 39, 30, 38);
		contentPane.add(lblSinal);
		
		cbxContaDivisao = new JCheckBox("Divisão");
		cbxContaDivisao.setForeground(Color.WHITE);
		cbxContaDivisao.setBackground(Color.BLACK);
		cbxContaDivisao.setBounds(286, 54, 131, 12);
		contentPane.add(cbxContaDivisao);
		
		cbxContaMultiplicacao = new JCheckBox("Multiplicação");
		cbxContaMultiplicacao.setForeground(Color.WHITE);
		cbxContaMultiplicacao.setBackground(Color.BLACK);
		cbxContaMultiplicacao.setBounds(286, 41, 152, 12);
		contentPane.add(cbxContaMultiplicacao);
	}
}
