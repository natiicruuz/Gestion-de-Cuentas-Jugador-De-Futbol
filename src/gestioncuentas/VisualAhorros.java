package gestioncuentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualAhorros extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private String nuevoAhorro;
	private double nuevoAhorroDouble;
	private JButton okBtn;
	private boolean datoAcceptado = false;
	
	public VisualAhorros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Ahorro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setBounds(93, 11, 242, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el porcentaje de ahorro:");
		lblNewLabel_1.setBounds(38, 82, 325, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(276, 89, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		okBtn = new JButton("Ok");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					nuevoAhorro = textField.getText();
					nuevoAhorroDouble = Double.parseDouble(nuevoAhorro);
					datoAcceptado = true;
					JOptionPane.showMessageDialog(null, "Ahorro ingresado correctamente.");
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
