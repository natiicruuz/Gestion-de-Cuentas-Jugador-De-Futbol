package gestioncuentas;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class MovimientosVisual extends JFrame {
	
	Main main = new Main(); 

	public MovimientosVisual() {

		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		JPanel jpPanel = new JPanel();
		container.add(jpPanel);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		jpPanel.setLayout(gridBagLayout);

		

		JList<String> list = new JList<String>();

		GridBagConstraints gbc_list = new GridBagConstraints();

		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		jpPanel.add(list, gbc_list);
		
		JButton btnTestList = new JButton("Mostrar datos");
		GridBagConstraints gbc_btnTestList = new GridBagConstraints();
		gbc_btnTestList.fill = GridBagConstraints.VERTICAL;
		jpPanel.add(btnTestList, gbc_btnTestList);
		btnTestList.setBounds(320, 217, 89, 23);
		
		btnTestList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String [] str = new String [Main.getMovimientos().size()];
				
				for(int i = 0;i<Main.getMovimientos().size();i++) {
					str[i] = Main.getMovimientos().get(i);
				}
				
				/*for(String k:str) {
					System.out.println(k);
				}*/

				list.setListData(str);

			}
		});
		
		
		
	}


	public static void main(String[] args) {
		MovimientosVisual jPnl = new MovimientosVisual();
		jPnl.setVisible(true);
	}
}