import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
public class Interface {

	private JFrame frmDictionary;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmDictionary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDictionary = new JFrame();
		frmDictionary.setResizable(false);
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 800, 600);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(2, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBounds(101, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 332, -57, -98);
		frmDictionary.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(22, 110, 168, 450);
		frmDictionary.getContentPane().add(scrollPane_1);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("");
		txtSearch.setBounds(12, 45, 179, 20);
		frmDictionary.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Asc");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(36, 78, 59, 23);
		frmDictionary.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Desc");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(110, 78, 59, 23);
		frmDictionary.getContentPane().add(rdbtnNewRadioButton_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(207, 11, 566, 549);
		frmDictionary.getContentPane().add(scrollPane_2);
	}
}