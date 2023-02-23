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

public class VisualBono extends JFrame {

	private JPanel contentPane;

	public VisualBono() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Bono");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setBounds(104, 11, 216, 45);
		contentPane.add(lblNewLabel);
		
		JRadioButton campeonGoleador = new JRadioButton("Campeon Goleador");
		campeonGoleador.setHorizontalAlignment(SwingConstants.LEFT);
		campeonGoleador.setBounds(42, 87, 191, 23);
		contentPane.add(campeonGoleador);
		
		JRadioButton campeonPais = new JRadioButton("Campeon con el pais");
		campeonPais.setHorizontalAlignment(SwingConstants.LEFT);
		campeonPais.setBounds(42, 143, 191, 23);
		contentPane.add(campeonPais);
		
		JRadioButton campeonEquipo = new JRadioButton("Campeon con el equipo");
		campeonEquipo.setHorizontalAlignment(SwingConstants.RIGHT);
		campeonEquipo.setBounds(193, 87, 191, 23);
		contentPane.add(campeonEquipo);
		
		JRadioButton bolaDePlata = new JRadioButton(" Bola de plata");
		bolaDePlata.setHorizontalAlignment(SwingConstants.RIGHT);
		bolaDePlata.setBounds(193, 143, 191, 23);
		contentPane.add(bolaDePlata);
		
		JButton okBtn1 = new JButton("Ok");
		okBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campeonGoleador.isSelected()) {
					Bonos nuevoBono = new Bonos("Campeon Goleador", "5.0% ");

				}
				else if(campeonPais.isSelected()) {
					Bonos nuevoBono = new Bonos("Campeon con el equipo", "10.0%");

				}
				else if(campeonEquipo.isSelected()) {
					Bonos nuevoBono = new Bonos("Campeon con el pais", "40000");

				}
				else if(bolaDePlata.isSelected()) {
					Bonos nuevoBono = new Bonos("Bola de plata", "20000");

				}
				
				JOptionPane.showMessageDialog(null, "Bono ingresado correctamente.");
				dispose();
				
			}
		});
		
		okBtn1.setBounds(169, 201, 89, 23);
		contentPane.add(okBtn1);
		
		ButtonGroup group1 = new ButtonGroup();

		group1.add(campeonGoleador);
		group1.add(campeonPais);
		group1.add(campeonEquipo);
		group1.add(bolaDePlata);


	}
	
}
