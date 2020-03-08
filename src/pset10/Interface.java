package pset10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class Interface {

	private JFrame frmInterface;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		getWords();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static ArrayList<Words> getWordList() throws FileNotFoundException{
		Gson gson = new Gson();
        String classpathDirectory = Utils.getClasspathDir();
        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        ArrayList<Words> listOfWords = new ArrayList<Words>();
        for (Words word : words) {
        	listOfWords.add(word);
        }
       ;
        return listOfWords;
	}

	private static DefaultListModel<String> getWords() throws FileNotFoundException{
		Gson gson = new Gson();
        String classpathDirectory = Utils.getClasspathDir();
        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
        for (Words word : words) {
        	listOfWords.addElement(word.getWord());
        }
       ;
        return  Utils.sortWordsAscending(listOfWords);
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public Interface() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frmInterface = new JFrame();
		frmInterface.setResizable(false);
		frmInterface.setTitle("Interface");
		frmInterface.setBounds(100, 100, 800, 600);
		frmInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInterface.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(207, 11, 566, 549);
		frmInterface.getContentPane().add(scrollPane_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("1. Example (pos)");
		textPane.setEditable(false);
		scrollPane_2.setViewportView(textPane);
		StyledDocument rightWindow = textPane.getStyledDocument();
		DefaultCaret caret = (DefaultCaret) textPane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(107, 142, 35));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("add");
			}
		});
		btnNewButton.setBounds(2, 11, 89, 23);
		frmInterface.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Remove");
			}
		});
		btnNewButton_1.setBounds(101, 11, 89, 23);
		frmInterface.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 332, -57, -98);
		frmInterface.getContentPane().add(scrollPane);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 114, 179, 446);
		frmInterface.getContentPane().add(scrollPane_1);
		
		JList<String> list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {			
				String selected = list.getSelectedValue();		
					try {
						ArrayList<Words> Words = getWordList();
						for(Words word: Words) {
							if(word.getWord().equals(selected)) {
								rightWindow.remove(0, rightWindow.getLength());
								Definitions[] definitions = word.getDefinitions();
								int definitionCounter = 1;
								for (Definitions definition : definitions) {
									rightWindow.insertString(rightWindow.getLength(), definitionCounter + "." + selected +" (" + definition.getPartOfSpeech() +")\n\n    "  +  definition.getDefinition() + "\n\n", null);
									definitionCounter++;
								}
								
							}
						}
					} catch (FileNotFoundException | BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}									
			}
		});
		scrollPane_1.setViewportView(list);
		
		DefaultListModel<String> DLM =  getWords();
		
		list.setModel(DLM);
		
		JRadioButton ascendingButton = new JRadioButton("Ascending");
		ascendingButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		buttonGroup.add(ascendingButton);
		ascendingButton.setBounds(12, 78, 79, 23);
		frmInterface.getContentPane().add(ascendingButton);
		ascendingButton.setSelected(true);
		
		JRadioButton descendingButton = new JRadioButton("Descending");
		descendingButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		buttonGroup.add(descendingButton);
		descendingButton.setBounds(101, 78, 89, 23);
		frmInterface.getContentPane().add(descendingButton);
		
		descendingButton.addItemListener(new ItemListener() {

		    @Override
		    public void itemStateChanged(ItemEvent event) {
		    	
		        int state = event.getStateChange();
		        if (state == ItemEvent.SELECTED) {		        	
		            try {
						list.setModel(Utils.reverseOrder(getWords()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
		            
		        } else if (state == ItemEvent.DESELECTED) {
		        	try {
						list.setModel(getWords());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}		 
		        }
		    }

		});
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String input = txtSearch.getText().toLowerCase();
				System.out.println(input);
				DefaultListModel<String> words = new DefaultListModel<String>();
				if (!ascendingButton.isSelected()) {		        	
				    try {
				    	words = Utils.reverseOrder(getWords());
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}		    
				} else {
					try {
						words = getWords();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}	
		}
				DefaultListModel<String> filtered = new DefaultListModel<String>();
				for(int i = 0 ; i < words.size(); i++) {
					if((words.get(i).contains(input))) {
						System.out.println(words.get(i));
						filtered.addElement(words.get(i));							
					}
				}
				list.setModel(filtered);
		}
			});
		txtSearch.setToolTipText("");
		txtSearch.setBounds(12, 45, 179, 20);
		frmInterface.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
	}
}