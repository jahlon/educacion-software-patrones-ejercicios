package calculadora.vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import calculadora.controlador.ControladorCalculadora;

public class CalculadoraUI extends JFrame implements IVistaCalculadora {
	
	private static final long serialVersionUID = -9030073748820540600L;
	
	private JPanel contentPane;
	private JTextField tfResultado;
	private JTextField textOperando;
	private JButton btnDeshacer;
	private JButton btnRehacer;
	private JButton bSuma;
	private JButton bResta;
	private JButton bMultiplicacion;
	private JButton bDivision;

	/**
	 * Create the frame.
	 */
	public CalculadoraUI() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tfResultado = new JTextField();
		tfResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		tfResultado.setText("0");
		tfResultado.setEditable(false);
		contentPane.add(tfResultado, BorderLayout.NORTH);
		tfResultado.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		textOperando = new JTextField();
		panel.add(textOperando);
		textOperando.setColumns(10);
		
		bSuma = new JButton("+");
		bSuma.setActionCommand(SUMA);
		panel.add(bSuma);
		
		bResta = new JButton("-");
		bResta.setActionCommand(RESTA);
		panel.add(bResta);
		
		bMultiplicacion = new JButton("*");
		bMultiplicacion.setActionCommand(MULTIPLICACION);
		panel.add(bMultiplicacion);
		
		bDivision = new JButton("/");
		bDivision.setActionCommand(DIVISION);
		panel.add(bDivision);
		
		btnDeshacer = new JButton("Deshacer");
		btnDeshacer.setActionCommand(DESHACER);
		panel.add(btnDeshacer);		
		
		btnRehacer = new JButton("Rehacer");
		btnRehacer.setActionCommand(REHACER);
		panel.add(btnRehacer);
	}
	
	@Override
	public void actualizarResultado(double resultado) {
		tfResultado.setText(Double.toString(resultado));
	}
	
	@Override
	public double getOperando() {
		return Double.parseDouble(textOperando.getText());
	}

	@Override
	public void inicializar() {
		this.setVisible(true);
	}

	@Override
	public void setControlador(ControladorCalculadora controlador) {
		bSuma.addActionListener(controlador);
		bResta.addActionListener(controlador);
		bMultiplicacion.addActionListener(controlador);
		bDivision.addActionListener(controlador);
		btnDeshacer.addActionListener(controlador);
		btnRehacer.addActionListener(controlador);
	}

	@Override
	public void enfocarOperando() {
		textOperando.requestFocusInWindow();
		textOperando.selectAll();
	}
}
