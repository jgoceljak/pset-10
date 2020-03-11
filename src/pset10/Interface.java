package pset10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

public class Interface {

	private JFrame frmInterface;
	private JTextField textField;

	private JTextField txtSearch;
	private JTextField txtDefinitions;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
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
	    frmInterface.setTitle("Dictionary");
	    frmInterface.setBounds(100, 100, 800, 600);
	    frmInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frmInterface.getContentPane().setLayout(null);

	    JPanel panel = new JPanel();
	    panel.setBounds(207, 11, 566, 549);
	    frmInterface.getContentPane().add(panel);
	    panel.setLayout(new CardLayout(0, 0));
	    
	    JScrollPane scrollPane_3 = new JScrollPane();
	    panel.add(scrollPane_3, "addWord");
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
	    scrollPane_3.setViewportView(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Add Word");
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
	    lblNewLabel.setBounds(10, 11, 244, 54);
	    panel_1.add(lblNewLabel);
	    
	    textField = new JTextField();
	    textField.setToolTipText("Word");
	    textField.setBounds(20, 76, 286, 20);
	    panel_1.add(textField);
	    textField.setColumns(10);
	    
	    JButton btnNewButton_2 = new JButton("Add");
	    btnNewButton_2.setBounds(465, 513, 89, 23);
	    panel_1.add(btnNewButton_2);
	    
	    JLabel lblDefinitions = new JLabel("Definitions");
	    lblDefinitions.setFont(new Font("Tahoma", Font.BOLD, 32));
	    lblDefinitions.setBounds(10, 107, 199, 54);
	    panel_1.add(lblDefinitions);
	    
	    
	    JLabel lblSeperateByComma = new JLabel("Seperate using commas");
	    lblSeperateByComma.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblSeperateByComma.setBounds(20, 264, 137, 20);
	    panel_1.add(lblSeperateByComma);
	    
	    txtDefinitions = new JTextField();
	    txtDefinitions.setToolTipText("Definitions");
	    txtDefinitions.setColumns(10);
	    txtDefinitions.setBounds(20, 182, 286, 20);
	    panel_1.add(txtDefinitions);
	    
	    
	    JLabel lblPartOfSpech = new JLabel("Parts of Speech");
	    lblPartOfSpech.setFont(new Font("Tahoma", Font.BOLD, 18));
	    lblPartOfSpech.setBounds(336, 130, 157, 20);
	    panel_1.add(lblPartOfSpech);
	    
	    JLabel label = new JLabel("Seperate using commas");
	    label.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label.setBounds(20, 157, 137, 20);
	    panel_1.add(label);
	    
	    textField_2 = new JTextField();
	    textField_2.setToolTipText("Part of Speech");
	    textField_2.setColumns(10);
	    textField_2.setBounds(346, 182, 147, 20);
	    panel_1.add(textField_2);
	    
	    JLabel lblSynonyms = new JLabel("Synonyms");
	    lblSynonyms.setFont(new Font("Tahoma", Font.BOLD, 32));
	    lblSynonyms.setBounds(10, 213, 184, 54);
	    panel_1.add(lblSynonyms);
	    
	    textField_1 = new JTextField();
	    textField_1.setToolTipText("synonym");
	    textField_1.setColumns(10);
	    textField_1.setBounds(20, 287, 286, 20);
	    panel_1.add(textField_1);
	    
	    JLabel label_1 = new JLabel("Seperate using commas");
	    label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label_1.setBounds(346, 161, 137, 20);
	    panel_1.add(label_1);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    panel.add(scrollPane_2, "defintions");
	    
	    CardLayout cardLayout = (CardLayout) panel.getLayout();
	    cardLayout.show(panel, "defintions");
	    
	    JTextPane textPane = new JTextPane();
	    textPane.setEditable(false);
	    scrollPane_2.setViewportView(textPane);
		
		StyledDocument rightWindow = textPane.getStyledDocument();
		DefaultCaret caret = (DefaultCaret) textPane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		
		textPane.setBorder(BorderFactory.createCompoundBorder(
		        textPane.getBorder(),
		            BorderFactory.createEmptyBorder(10, 10 ,10 , 10)));
		    Style bigWord = textPane.addStyle("Style", null);
		    Style header = textPane.addStyle("Style", null);
		    StyleConstants.setFontSize(header, 20);
		    StyleConstants.setFontSize(bigWord, 36);
		    StyleConstants.setBold(bigWord, true);

		    try {
				rightWindow.insertString(rightWindow.getLength(),"Example Word\n" ,bigWord );
				rightWindow.insertString(rightWindow.getLength(),"\n" , null );
			    rightWindow.insertString(rightWindow.getLength(),"Definitions\n" ,header );
			    rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
			    rightWindow.insertString(rightWindow.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
			    rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
			    rightWindow.insertString(rightWindow.getLength(),"Synonyms\n" ,header );
			    rightWindow.insertString(rightWindow.getLength(),"\n1.Synonym " ,null );
			    rightWindow.insertString(rightWindow.getLength(),"\n\n" ,null );
			    rightWindow.insertString(rightWindow.getLength(),"Antonyms\n" ,header );
			    rightWindow.insertString(rightWindow.getLength(),"\n1.Antonym " ,null );
			
			} catch (BadLocationException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		    
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(107, 142, 35));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        System.out.println("add");
	        cardLayout.show(panel, "addWord");
	      }
	    });
	    btnNewButton.setBounds(2, 11, 89, 23);
	    frmInterface.getContentPane().add(btnNewButton);
		btnNewButton.setBounds(2, 11, 89, 23);
		frmInterface.getContentPane().add(btnNewButton);
		
		
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
								Style bigWord = textPane.addStyle("Style", null);
								Style header = textPane.addStyle("Style", null);
								StyleConstants.setFontSize(header, 20);
								StyleConstants.setFontSize(bigWord, 36);
								StyleConstants.setBold(bigWord, true);
								rightWindow.insertString(rightWindow.getLength(),selected.substring(0, 1).toUpperCase() + selected.substring(1) + "\n" ,bigWord );
								rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
								rightWindow.insertString(rightWindow.getLength(),"Definitions\n" ,header );
								rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
								Definitions[] definitions = word.getDefinitions();
								int definitionCounter = 1;
								for (Definitions definition : definitions) {
									rightWindow.insertString(rightWindow.getLength(), definitionCounter + "." + selected +" (" + definition.getPartOfSpeech() +")\n\n    "  +  definition.getDefinition() + "\n\n", null);
									definitionCounter++;
								}
								
								String[] synonyms = word.getSynonyms();
				                if(synonyms.length != 0) {
				                	rightWindow.insertString(rightWindow.getLength(),"Synonyms\n" ,header );
				                	rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
				                  int scount = 1;
				                  for(String synonym : synonyms) {
				                	  rightWindow.insertString(rightWindow.getLength(), scount + "." + synonym + "\n", null);
				                    scount++;
				                  }
				                }
				                String[] antonyms = word.getAntonyms();
				                if (antonyms.length != 0) {
				                	rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
				                	rightWindow.insertString(rightWindow.getLength(),"Antonyms\n" ,header );
				                	rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
				                  int acount = 1;
				                  for(String antonym : antonyms) {
				                	  rightWindow.insertString(rightWindow.getLength(), acount +"."+ antonym + "\n", null);
				                    acount++;
				                  }
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
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.BLACK);
	    btnNewButton_1.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent arg0) {
	    	  boolean confirmed =  false;
	    	  List<String> selected = list.getSelectedValuesList();
				try {
					ArrayList<Words> newWords = getWordList();
					ArrayList<Words> remove = new ArrayList<Words>();
					 for(String i : selected) {
					        for (Words word : newWords) {
					        	if(i.equals(word.getWord())) { 
					                  remove.add(word);

					}
					        }
					 }
					 
					 int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the following word(s)\nfrom the dictionary?\n\nThis action cannot be undone.\n\n","Warning",JOptionPane.YES_NO_OPTION);
			    	  if(dialogResult == JOptionPane.YES_OPTION){
			    		  confirmed = true;
			    	  }
			    	  
			    	  if(confirmed) {
					for (Words removeWord : remove) {
						newWords.remove(removeWord);
					}
						
					}
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
			        String classpathDirectory = Utils.getClasspathDir();
			         try (FileWriter writer = new FileWriter(classpathDirectory +"words.json")) {
			                  gson.toJson(newWords, writer);
			              } catch (IOException e) {
			                  e.printStackTrace( );
			              }
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
				} list.setModel(words);
				try {
					rightWindow.remove(0, rightWindow.getLength());
					rightWindow.insertString(rightWindow.getLength(),"Example Word\n" ,bigWord );
					rightWindow.insertString(rightWindow.getLength(),"\n" , null );
					rightWindow.insertString(rightWindow.getLength(),"Definitions\n" ,header );
					rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
					rightWindow.insertString(rightWindow.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
					rightWindow.insertString(rightWindow.getLength(),"\n" ,null );
					rightWindow.insertString(rightWindow.getLength(),"Synonyms\n" ,header );
					rightWindow.insertString(rightWindow.getLength(),"\n1.Synonym " ,null );
					rightWindow.insertString(rightWindow.getLength(),"\n\n" ,null );
					rightWindow.insertString(rightWindow.getLength(),"Antonyms\n" ,header );
					rightWindow.insertString(rightWindow.getLength(),"\n1.Antonym " ,null );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				}catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		      }
	    });
		btnNewButton_1.setBounds(101, 11, 89, 23);
		frmInterface.getContentPane().add(btnNewButton_1);
		
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