package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class FrameMenu extends JFrame {

	private static final long serialVersionUID = -7703754494214959683L;
	private JPanel contentPane = new JPanel();
	private final JButton btnCarga = new JButton("Carga");
	private final JButton btnPasseio = new JButton("Passeio");
	private final JButton btnSair = new JButton("Sair");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMenu frame = new FrameMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public FrameMenu(){
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Gestão de Veículos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnCarga.setBounds(226, 137, 212, 70);
		btnPasseio.setBounds(12, 137, 212, 70);
		btnSair.setBounds(381, 232, 57, 27);
		
		contentPane.setLayout(null);
		contentPane.add(btnCarga);
		contentPane.add(btnPasseio);
		contentPane.add(btnSair);
		
		JPanel panelImagePasseio = new JPanel();
		panelImagePasseio.setBounds(12, 0, 212, 125);
		contentPane.add(panelImagePasseio);
		
		JPanel panelImageCarga = new JPanel();
		panelImageCarga.setBounds(226, 0, 212, 125);
		contentPane.add(panelImageCarga);
		
		
		btnCarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAbreMenuCarga(arg0);
			}
		});
		btnPasseio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAbreMenuPasseio(arg0);
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSairAction(arg0);
			}
		});
		
	}

	private void setImagePasseio(JPanel panelImagePasseio) {
		panelImagePasseio.setLayout(new FlowLayout());
		JLabel imagePasseioLabel = new JLabel();
		imagePasseioLabel.setIcon(new ImageIcon("/home/andrek/Pictures/UTFPR/Passeio.webp"));
		panelImagePasseio.add(imagePasseioLabel);
	}
	
	public boolean confirmaAcao(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem, null, JOptionPane.YES_NO_OPTION) == 0;
	}
	
	private void btnSairAction(ActionEvent e) {
		if (confirmaAcao("Deseja sair do programa?")) {
			dispose();
		}
	}
	
	private void btnAbreMenuCarga(ActionEvent e) {
		MenuCarga.getMenuCargaSingle().setVisible(true);
	}
	
	private void btnAbreMenuPasseio(ActionEvent e) {
		MenuPasseio.getMenuPasseioSingle().setVisible(true);
	}
}