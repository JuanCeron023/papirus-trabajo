package Vacunas.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import java.awt.Color;

import Vacunas.mundo.*;
/**
 * clase principal que maneja la interfaz
 */
public class Interfaz extends JFrame {

	private JPanel contentPane;
	private Interfaz frame;
	private Vacunacion vacunacion;
	private panelDatos panel2;
	private panelBuscar panel;
	private String id;

	/**
	 * Empieza la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		});
	}

	/**
	 * Crea el frame
	 */
	public Interfaz() {
		Municipio d1 = new Municipio("municipio1");
		Municipio d2 = new Municipio("municipio2");
		Municipio d3 = new Municipio("municipio3");
		ArrayList<Municipio> e1 = new ArrayList<Municipio>();
		e1.add(d1);
		e1.add(d2);
		e1.add(d3);
		Departamento a1 = new Departamento("departamento1", e1);
		Municipio d4 = new Municipio("municipio4");
		Municipio d5 = new Municipio("municipio5");
		Municipio d6 = new Municipio("municipio6");
		ArrayList<Municipio> e2 = new ArrayList<Municipio>();
		e2.add(d4);
		e2.add(d5);
		e2.add(d6);
		Departamento a2 = new Departamento("departamento2", e2);
		Usuario c1 = new Usuario("1", "nombre1", "email1", "cedula", "apellido1", "100", "10", a1, d1, "direccion1");
		Usuario c2 = new Usuario("2", "nombre2", "email2", "cedula", "apellido2", "200", "20", a1, d2, "direccion2");
		Usuario c3 = new Usuario("3", "nombre3", "email3", "cedula", "apellido3", "300", "30", a1, d3, "direccion3");
		Usuario c4 = new Usuario("4", "nombre4", "email4", "cedula", "apellido4", "400", "40", a2, d4, "direccion4");
		Usuario c5 = new Usuario("5", "nombre5", "email5", "cedula", "apellido5", "500", "50", a2, d5, "direccion5");
		Usuario c6 = new Usuario("6", "nombre6", "email6", "cedula", "apellido6", "600", "60", a2, d5, "direccion6");
		ArrayList<Usuario> g1 = new ArrayList<Usuario>();
		g1.add(c1);
		g1.add(c2);
		g1.add(c3);
		ArrayList<Usuario> g2 = new ArrayList<Usuario>();
		g2.add(c4);
		g2.add(c5);
		g2.add(c6);
		Eps b1 = new Eps(g1, "eps1");
		Eps b2 = new Eps(g2, "eps2");

		ArrayList<Departamento> h1 = new ArrayList<Departamento>();
		h1.add(a1);
		h1.add(a2);
		ArrayList<Eps> h2 = new ArrayList<Eps>();
		h2.add(b1);
		h2.add(b2);
		vacunacion = new Vacunacion(h2, h1);

		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		panel = new panelBuscar(frame);
		panel.setBounds(10, 24, 414, 58);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(panel);

		panel2 = new panelDatos(frame, vacunacion.getDepartamento());
		panel2.setBounds(10, 94, 414, 437);
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(panel2);
		this.setTitle("Vacunaci?n");
	}

	/**
	 * busca un  usuario
	 * @param texto  identificacion del usuario
	 * */
	public void escuchar1(String texto) {
		id = texto;
		Usuario temporal = vacunacion.buscarUsuario(texto);
		panel2.enviarUsuario(temporal);

	}

	/**
	 * actualiza un  usuario
	 * @param pNombres   nombres del usuario
	 * @param pEmail    email del usuario
	 * @param pTipoId  tipo de identificacion del usuario
	 * @param pApellidos  apellidos del usuario
	 * @param Pcelular  celular del usuario
	 * @param pTelefono   telefono del usuario
	 * @param pDepartamento   departamento del usuario
	 * @param pMunicipio   municipio del usuario
	 * @param pDireccion   direccion del usuario
	 */
	public void escuchar2(String pNombres, String pEmail, String pTipoId, String pApellidos, String Pcelular,
			String pTelefono, Departamento pDepartamento, Municipio pMunicipio, String pDireccion) {

		vacunacion.actualizarUsuario(id, pNombres, pEmail, pTipoId, pApellidos, Pcelular, pTelefono, pDepartamento,
				pMunicipio, pDireccion);

	}

}
