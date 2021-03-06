package Vacunas.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Vacunas.mundo.Departamento;
import Vacunas.mundo.Municipio;
import Vacunas.mundo.Usuario;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
/**
 * clase del panel de ingresar datos
 */
public class panelDatos extends JPanel {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField;
	private Interfaz frame;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private ArrayList<Departamento> departamentos;

	/**
	 * Create the frame.
	 */
	public panelDatos(Interfaz framew, ArrayList<Departamento> departamentosw) {
		frame = framew;
		departamentos = departamentosw;
		this.setLayout(null);

		JLabel lblTipoId = new JLabel("Tipo ID: *");
		lblTipoId.setBounds(35, 30, 148, 14);
		add(lblTipoId);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(175, 58, 197, 20);
		add(textField_3);

		JLabel lblNewLabel_1_1 = new JLabel("Nombres:  *");
		lblNewLabel_1_1.setBounds(35, 63, 148, 14);
		add(lblNewLabel_1_1);

		JLabel lblApellidos = new JLabel("Apellidos: *");
		lblApellidos.setBounds(35, 99, 148, 14);
		add(lblApellidos);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(175, 93, 197, 20);
		add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(175, 127, 197, 20);
		add(textField_5);

		JLabel lblNewLabel_1_2 = new JLabel("No. Celular: *");
		lblNewLabel_1_2.setBounds(35, 132, 148, 14);
		add(lblNewLabel_1_2);

		JLabel lblTelefono = new JLabel("Telefono: *");
		lblTelefono.setBounds(35, 165, 148, 14);
		add(lblTelefono);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(175, 159, 197, 20);
		add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(175, 193, 197, 20);
		add(textField_7);

		JLabel lblNewLabel_1_3 = new JLabel("Correo electr\u00F3nico: *");
		lblNewLabel_1_3.setBounds(35, 198, 148, 14);
		add(lblNewLabel_1_3);

		JLabel lblDepartamento = new JLabel("Departamento: *");
		lblDepartamento.setBounds(35, 236, 148, 14);
		add(lblDepartamento);

		JLabel lblNewLabel_1_4 = new JLabel("Ciudad / Municipio: *");
		lblNewLabel_1_4.setBounds(35, 269, 148, 14);
		add(lblNewLabel_1_4);

		JLabel lblDireccion = new JLabel("Direccion: *");
		lblDireccion.setBounds(35, 302, 148, 14);
		add(lblDireccion);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(175, 296, 197, 20);
		add(textField);

		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_3.getText().equals("") || textField_4.getText().equals("")
						|| textField_5.getText().equals("") || textField_6.getText().equals("")
						|| textField_7.getText().equals("") || textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "llena todos los campos");
				} else if (!textField_5.getText().matches("\\d+") || !textField_6.getText().matches("\\d+")) {
					JOptionPane.showMessageDialog(null,
							"solo se ascceptan numeros en los campos de telefono y celular");
				} else {

					String pNombres = textField_3.getText();
					String pApellidos = textField_4.getText();
					String Pcelular = textField_5.getText();
					String pTelefono = textField_6.getText();
					String pEmail = textField_7.getText();
					String pDireccion = textField.getText();

					String depar = comboBox_1.getSelectedItem().toString();
					String muni = comboBox_2.getSelectedItem().toString();
					String pTipoId = comboBox.getSelectedItem().toString();

					Departamento pDepartamento = null;
					for (int i = 0; i < departamentos.size(); i++) {
						if (depar.equalsIgnoreCase(departamentos.get(i).getNombre())) {
							pDepartamento = departamentos.get(i);
						}
					}

					Municipio pMunicipio = null;
					ArrayList<Municipio> temp = pDepartamento.getMunicipio();
					for (int i = 0; i < temp.size(); i++) {
						if (muni.equalsIgnoreCase(temp.get(i).getNombre())) {
							pMunicipio = temp.get(i);
						}
					}
					frame.escuchar2(pNombres, pEmail, pTipoId, pApellidos, Pcelular, pTelefono, pDepartamento,
							pMunicipio, pDireccion);

					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField.setText("");

				}

			}
		});
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(99, 337, 99, 33);
		btnNewButton.setForeground(new Color(255, 255, 255));
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField.setText("");

			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(231, 337, 111, 33);
		add(btnNewButton_1);

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(175, 27, 197, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "cedula", "tarjeta de identidad", "pasaporte" }));
		add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(175, 229, 197, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "departamento1", "departamento2" }));

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});

		add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(175, 263, 197, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "municipio1" }));
		add(comboBox_2);
	}

	/**
	 * mostrar la inforamcion del usuario que se busca
	 */
	public void enviarUsuario(Usuario temporal) {

		textField_3.setText(temporal.getNombres());
		textField_4.setText(temporal.getApellidos());
		textField_5.setText(temporal.getCelular());
		textField_6.setText(temporal.getTelefono());
		textField_7.setText(temporal.getEmail());
		textField.setText(temporal.getDireccion());

		Departamento temporal1 = temporal.getDepartamento();
		ArrayList<Municipio> temp = temporal1.getMunicipio();
		String[] array = new String[temporal1.getMunicipio().size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = temp.get(i).getNombre();
		}
		comboBox_2.setModel(new DefaultComboBoxModel(array));

		comboBox_1.setSelectedItem(temporal.getDepartamento().getNombre());
		comboBox.setSelectedItem(temporal.getTipoId());

		comboBox_2.setSelectedItem(temporal.getMunicipio().getNombre());

	}

	/**
	 * actualizar los combo box segun el departamento
	 */
	public void actualizar() {

		Departamento temporal1 = null;
		String depar = comboBox_1.getSelectedItem().toString();
		for (int i = 0; i < departamentos.size(); i++) {
			if (depar.equalsIgnoreCase(departamentos.get(i).getNombre())) {
				temporal1 = departamentos.get(i);
			}
		}
		ArrayList<Municipio> temp = temporal1.getMunicipio();
		String[] array = new String[temporal1.getMunicipio().size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = temp.get(i).getNombre();
		}
		comboBox_2.setModel(new DefaultComboBoxModel(array));
	}

}
