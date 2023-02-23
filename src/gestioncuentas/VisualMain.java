package gestioncuentas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VisualMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField opcionElegida;
	JButton nextBtn1 = new JButton("Siguiente");
	String opcionStr;// Convertir la opcion que el cliente ingreso a String para
	Byte opcion;// Luego pasarla a BYTE

	JFrame frame = new JFrame();

	public VisualMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Gestion de cuentas personal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 414, 58);
		contentPane.add(lblNewLabel);

		JLabel lbl_ingreso = new JLabel("1.Introducir nuevo ingreso");
		lbl_ingreso.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ingreso.setBounds(10, 67, 204, 14);
		contentPane.add(lbl_ingreso);

		JLabel lbl_bono = new JLabel("2.Introducir Bono");
		lbl_bono.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_bono.setBounds(10, 91, 214, 14);
		contentPane.add(lbl_bono);

		JLabel lbl_gasto = new JLabel("3.Introducir nuevo gasto");
		lbl_gasto.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_gasto.setBounds(10, 116, 238, 14);
		contentPane.add(lbl_gasto);

		JLabel lbl_ahorro = new JLabel("4.Introducir nuevo ahorro");
		lbl_ahorro.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ahorro.setBounds(10, 144, 238, 14);
		contentPane.add(lbl_ahorro);

		JLabel lbl_inversion = new JLabel("5.Introducir nueva inversion");
		lbl_inversion.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_inversion.setBounds(224, 67, 200, 14);
		contentPane.add(lbl_inversion);

		JLabel lbl_filantropia = new JLabel("6.Introducir aporte de Filantropia");
		lbl_filantropia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_filantropia.setBounds(234, 91, 190, 14);
		contentPane.add(lbl_filantropia);

		JLabel lbl_balance = new JLabel("7.Mostrar balance completo");
		lbl_balance.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_balance.setBounds(234, 116, 190, 14);
		contentPane.add(lbl_balance);

		JLabel lbl_saldo = new JLabel("8.Mostrar saldo");
		lbl_saldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_saldo.setBounds(292, 144, 132, 14);
		contentPane.add(lbl_saldo);

		JLabel lbl_salir = new JLabel("9.Salir");
		lbl_salir.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_salir.setBounds(148, 169, 132, 14);
		contentPane.add(lbl_salir);

		opcionElegida = new JTextField();
		opcionElegida.setBounds(224, 218, 86, 20);
		contentPane.add(opcionElegida);
		opcionElegida.setColumns(10);

		JLabel lbl_opcion = new JLabel("Seleccione una opcion: ");
		lbl_opcion.setBounds(71, 221, 164, 14);
		contentPane.add(lbl_opcion);
		nextBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					opcionStr = opcionElegida.getText();
					opcion = Byte.parseByte(opcionStr);
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un numero valido!");
				}

				switch (opcion) {

				case 1: // Introducir nuevo ingreso

					//JOptionPane.showMessageDialog(null, "Ingreso");
					IngresosVisual ingresoVisual = new IngresosVisual();
					ingresoVisual.setVisible(true);
					break;

				case 2:
					VisualBono bono = new VisualBono();
					bono.setVisible(true);
					break;

				case 3:// Introducir nuevo gasto
					GastosVisual gastos = new GastosVisual();
					gastos.setVisible(true);
					break;

				case 4: // Introducir nuevo ahorro
					VisualAhorros ahorros = new VisualAhorros();
					ahorros.setVisible(true);
					break;

				case 5: // Introducir nueva inversion
					VisualInversion inversion = new VisualInversion();
					inversion.setVisible(true);
					break;
					

				case 6:
					VisualFilantropia filantropia = new VisualFilantropia();
					filantropia.setVisible(true);
					break;

				case 7: // Mostrar movimientos(INGRESOS, EGRESOS, **AHORROS**)
					MovimientosVisual movimientos = new MovimientosVisual();
					movimientos.setVisible(true);

					break;

				case 8: // // Mostrar registro general ACA MUESTRO TOTAL DEL SALDO " TIENES XX EN LA
					// TARJETA"
					Main.mostrarSaldo();
					break;
					
				case 9:
					JOptionPane.showMessageDialog(null, "Programa finalizado. Gracias por utilizar la aplicacion.");
					System.exit(0);
					break;

				default: // Con cualquier otro numero, muestra un mensaje
					JOptionPane.showMessageDialog(null, "Introduce el valor correcto");
					break;
				}

			}
		});

		nextBtn1.setBounds(320, 217, 89, 23);
		contentPane.add(nextBtn1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
