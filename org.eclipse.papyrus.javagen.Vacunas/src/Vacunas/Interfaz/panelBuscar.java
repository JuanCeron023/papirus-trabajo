package Vacunas.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * clase del panel de buscar
 */
public class panelBuscar extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private Interfaz frame;

	/**
	 * Create the frame.
	 */
	public panelBuscar(Interfaz framew) {
		frame = framew;
		this.setLayout(null);

		textField = new JTextField();
		textField.setBounds(116, 27, 164, 20);
		textField.setColumns(10);
		this.add(textField);

		JLabel lblNewLabel = new JLabel("Identificaci\u00F3n:");
		lblNewLabel.setBounds(26, 30, 89, 14);
		this.add(lblNewLabel);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					frame.escuchar1(textField.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No se encontr? al usuario");
				}

			}
		});
		btnNewButton.setBounds(290, 26, 118, 23);
		this.add(btnNewButton);
	}
}
