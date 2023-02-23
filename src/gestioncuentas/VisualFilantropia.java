package gestioncuentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualFilantropia extends JFrame {

	private JPanel contentPane;

	public VisualFilantropia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Aporte de Filantropia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setBounds(42, 11, 346, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_tipoAporte = new JLabel("Ingrese el tipo de aporte filantropico: ");
		lbl_tipoAporte.setBounds(20, 62, 283, 28);
		contentPane.add(lbl_tipoAporte);
		
		JRadioButton rdbtn_DonacionAnual = new JRadioButton("Donacion Anual");
		rdbtn_DonacionAnual.setBounds(20, 97, 209, 23);
		contentPane.add(rdbtn_DonacionAnual);
		
		JRadioButton rdbtn_EventoEspecial = new JRadioButton("Evento especial");
		rdbtn_EventoEspecial.setBounds(279, 97, 145, 23);
		contentPane.add(rdbtn_EventoEspecial);
		
		JButton okBtn = new JButton("Ok");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn_DonacionAnual.isSelected() || rdbtn_EventoEspecial.isSelected()) {
					JOptionPane.showMessageDialog(null, "Aporte Filantropico ingresado correctamente.");
					dispose();
				}

			}
		});
		okBtn.setBounds(335, 227, 89, 23);
		contentPane.add(okBtn);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtn_DonacionAnual);
		group1.add(rdbtn_EventoEspecial);
		
	}

}
