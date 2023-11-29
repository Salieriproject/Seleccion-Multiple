package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Probsm1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbocodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Probsm1 frame = new Probsm1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Probsm1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcodigo = new JLabel("Codigo");
		lblcodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblcodigo.setBounds(59, 56, 107, 45);
		contentPane.add(lblcodigo);
		
		JLabel lblcantidad = new JLabel("Cantidad");
		lblcantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantidad.setBounds(59, 134, 107, 45);
		contentPane.add(lblcantidad);
		
		cbocodigo = new JComboBox();
		cbocodigo.setBounds(176, 56, 160, 45);
		llenarArreglo();
		contentPane.add(cbocodigo);
		
		JSpinner spncantidad = new JSpinner();
		spncantidad.setBounds(176, 134, 160, 45);
		contentPane.add(spncantidad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 208, 562, 213);
		contentPane.add(scrollPane);
		
		JTextArea txtresultado = new JTextArea();
		scrollPane.setViewportView(txtresultado);
		
		JButton btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaracion de Variables
				int cantidad, caramelos=0;
				double precio=0, impcom, impdes=0, imppag=0;
				String cod;
				
				
				//Entrada de datos
				/*if (cbocodigo.getSelectedItem()=="101")	{
					precio=17.5;
				}
				if (cbocodigo.getSelectedItem()=="102")	{
					precio=25.0;
				}
				if (cbocodigo.getSelectedItem()=="103")	{
					precio=15.5;
				}*/
				cod=cbocodigo.getSelectedItem().toString();
				
				switch (cod)	{
				case "101":
					precio=17.5;
					break;
				case "102":
					precio=25;
					break;
			    case "103":
			    	precio=15.15;
			    	break;			    	
				}
				
				cantidad=(Integer)(spncantidad.getValue());
								
				//Calcula el importe de la compra
				impcom=precio*cantidad;	
				
				
				//Calculo el importe del descuento
				if (cantidad<11)
					impdes=0.05*impcom;
				if (cantidad>=11 && cantidad<21)
					impdes=0.075*impcom;
				if (cantidad>=21 && cantidad<31)
					impdes=0.10*impcom;
				if (cantidad>=31)
					impdes=0.125*impcom;
				
					
				//Calculo el importe a pagar
				imppag=impcom-impdes;
				
				//Calculo los caramelos
				if (imppag>250)	{
					caramelos=3*cantidad;				
				}else	{
					caramelos=2*cantidad;
				}	
				
				//Salida
				txtresultado.setText("Precio del Producto   :"+precio+"\n");
				txtresultado.append("Importe de compra    :"+impcom+"\n");
				txtresultado.append("Descuento                   :"+impdes+"\n");
				txtresultado.append("Importe de pago         :"+imppag+"\n");
				txtresultado.append("Caramelos                  :"+caramelos);
			}
			
			
		});
		btnprocesar.setBounds(351, 56, 149, 45);
		contentPane.add(btnprocesar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setBounds(351, 134, 149, 45);
		contentPane.add(btnborrar);
	}
	public void llenarArreglo()	{
		String	[] arr_codigos=	{"Seleccione codigo","101","102","103"};
		for (String codigo: arr_codigos) {
			cbocodigo.addItem(codigo);			
		}
	}
}
