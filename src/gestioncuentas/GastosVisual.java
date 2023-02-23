package gestioncuentas;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GastosVisual extends JFrame {

	private JPanel contentPane;
	private JTextField nuevoGasto_txt;

	private String nuevoGasto; // Variable para guardar el nuevo importe String
	private double nuevoGastoDouble;
	private JButton okBtn;
	private boolean datoAcceptado = false;
	
	public GastosVisual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Gasto");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 11, 226, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Por favor introduzca el gasto: ");
		lblNewLabel_1.setBounds(10, 62, 194, 14);
		contentPane.add(lblNewLabel_1);
		
		nuevoGasto_txt = new JTextField();
		nuevoGasto_txt.setBounds(239, 59, 111, 20);
		contentPane.add(nuevoGasto_txt);
		nuevoGasto_txt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione el tipo de gasto:");
		lblNewLabel_2.setBounds(10, 101, 176, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Perdida por impuesto");
		rdbtnNewRadioButton.setBounds(10, 122, 155, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Perdida por inactividad");
		rdbtnNewRadioButton_1.setBounds(10, 148, 155, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Perdida por multas");
		rdbtnNewRadioButton_2.setBounds(239, 122, 155, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);


		
		JLabel lbl_year = new JLabel("Ingrese el a\u00F1o del importe: ");
		lbl_year.setBounds(10, 182, 165, 14);
		contentPane.add(lbl_year);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(239, 188, 44, 22);
		contentPane.add(comboBox_1);
	
		
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		comboBox_1.addItem("6");
		comboBox_1.addItem("7");
		comboBox_1.addItem("8");
		comboBox_1.addItem("9");
		comboBox_1.addItem("10");
		comboBox_1.addItem("11");
		comboBox_1.addItem("12");
		
		okBtn = new JButton("Ok");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nuevoGasto = nuevoGasto_txt.getText();
					nuevoGastoDouble = Double.parseDouble(nuevoGasto);
					datoAcceptado = true;
					JOptionPane.showMessageDialog(null, "Gasto ingresado correctamente.");
					dispose();

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El valor del gasto debe ser numerico.");
					datoAcceptado = false;
				}
				
			}
		});
		
		okBtn.setBounds(335, 227, 89, 23);
		contentPane.add(okBtn);

	}

}
