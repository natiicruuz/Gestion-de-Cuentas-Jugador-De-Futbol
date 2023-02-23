package gestioncuentas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class IngresosVisual extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField nuevoImportetxt;
	private String nuevoImporte; // Variable para guardar el nuevo importe String
	private double nuevoImporteDouble;
	private JButton okBtn;
	private boolean datoAcceptado = false;
	private String descripcionNuevoIngreso = "";
	private int fechaNuevoIngresoInt;
	private JLabel lbl_tipoIngreso;
	private JLabel lbl_tipoContrato;
	private JRadioButton contrato_anual;
	private JRadioButton contrato_Multianual;
	private Cuenta miCuenta = new Cuenta(nuevoImporteDouble);

	public IngresosVisual() {

		VisualMain main = new VisualMain();
		main.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Introducir nuevo Ingreso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setBounds(44, 11, 352, 43);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Por favor introduzca el ingreso:");
		lblNewLabel_1.setBounds(10, 52, 205, 14);
		contentPane.add(lblNewLabel_1);

		nuevoImportetxt = new JTextField();
		nuevoImportetxt.setBounds(229, 49, 111, 20);
		contentPane.add(nuevoImportetxt);
		nuevoImportetxt.setColumns(10);

		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					nuevoImporte = nuevoImportetxt.getText();
					nuevoImporteDouble = Double.parseDouble(nuevoImporte);
					datoAcceptado = true;
					JOptionPane.showMessageDialog(null, "Importe ingresado correctamente.");
					dispose();
					

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El valor del ingreso debe ser numerico.");
					datoAcceptado = false;
				}

			}
		});

		okBtn.setBounds(350, 227, 74, 23);
		contentPane.add(okBtn);

		lbl_tipoIngreso = new JLabel("Seleccione el tipo de ingreso:");
		lbl_tipoIngreso.setBounds(10, 92, 175, 14);
		contentPane.add(lbl_tipoIngreso);

		JRadioButton ingresoContrato = new JRadioButton("Ingreso por contrato");
		ingresoContrato.setHorizontalAlignment(SwingConstants.LEFT);
		ingresoContrato.setBounds(10, 113, 175, 23);
		contentPane.add(ingresoContrato);


		JRadioButton ingresoPublicidad = new JRadioButton("Ingreso por publicidad");
		ingresoPublicidad.setHorizontalAlignment(SwingConstants.LEFT);
		ingresoPublicidad.setBounds(201, 113, 195, 23);
		contentPane.add(ingresoPublicidad);

		ButtonGroup group = new ButtonGroup();
		group.add(ingresoContrato);
		group.add(ingresoPublicidad);

		lbl_tipoContrato = new JLabel("Ingrese el tipo de contrato anual(a) o multianual(m): ");
		lbl_tipoContrato.setVisible(true);

		lbl_tipoContrato.setBounds(10, 155, 298, 14);
		contentPane.add(lbl_tipoContrato);
		
		
		contrato_anual = new JRadioButton("Anual");
		contrato_anual.setBounds(10, 176, 109, 23);
		contentPane.add(contrato_anual);
		
		contrato_Multianual = new JRadioButton("Multianual");
		contrato_Multianual.setBounds(199, 176, 109, 23);
		contentPane.add(contrato_Multianual);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(contrato_anual);
		group1.add(contrato_Multianual);
		

		JLabel lblNewLabel_2 = new JLabel("Ingrese el a\u00F1o del importe: ");
		lblNewLabel_2.setBounds(10, 211, 165, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		comboBox.addItem(6);
		comboBox.addItem(7);
		comboBox.addItem(8);
		comboBox.addItem(9);
		comboBox.addItem(10);
		comboBox.addItem(11);
		comboBox.addItem(12);

		comboBox.setBounds(185, 207, 38, 22);
		contentPane.add(comboBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
} 