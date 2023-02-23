package gestioncuentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualInversion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private String nuevaInversion;
	private double nuevaInversionDouble;
	private JButton okBtn;
	private boolean datoAcceptado = false;
	

	public VisualInversion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nueva Inversion");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 11, 297, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el porcentaje de inversion");
		lblNewLabel_1.setBounds(63, 81, 240, 41);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(281, 91, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton okBtn = new JButton("Ok");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					nuevaInversion = textField.getText();
					nuevaInversionDouble = Double.parseDouble(nuevaInversion);
					datoAcceptado = true;
					JOptionPane.showMessageDialog(null, "Inversion ingresada correctamente.");
					dispose();

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El valor del ahorro debe ser numerico.");
					datoAcceptado = false;
					
				}
			}
		});
		okBtn.setBounds(335, 227, 89, 23);
		contentPane.add(okBtn);

	}

}
