package pset10;


import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class Utils {
	
        public static String getClasspathDir() {
        String classpath = System.getProperty("java.class.path", ".");
        boolean windows = false;
        if (classpath.matches(".*\\\\.*")) {
            windows = true;
        }
        if (windows) {
            String[] splitClasspathDir = classpath.split(";");
            String classpathDirectory = "";
            for (String s : splitClasspathDir) {
                if (s.matches(".*lib\\\\.*")) {
                    classpathDirectory = s;
                }
            }
            return classpathDirectory;
        }else {
            String[] splitClasspathDir = classpath.split(":");
            String classpathDirectory = "";
            for (String s : splitClasspathDir) {
                if (s.matches(".*lib/.*")) {
                    classpathDirectory = s;
                }
            }
            return classpathDirectory;
        }
    }
    	public static DefaultListModel<String> sortWordsAscending(DefaultListModel<String> wordList) {
    		String temp;
    		int n = wordList.getSize();
    		for (int i = 0; i < n; i++) 
            {
                for (int j = i + 1; j < n; j++) 
                {
                    if ((wordList.get(i).compareTo(wordList.get(j)) > 0)) 
                    {
                        temp = wordList.get(i);
                        wordList.set(i, wordList.get(j));
                        wordList.set(j, temp);
                    }
                }
            }
    		return wordList;
    	}

		public static DefaultListModel<String> reverseOrder(DefaultListModel<String> words) {
			DefaultListModel<String> b = new DefaultListModel<String>(); 
			int j = words.getSize();
	        int k = j; 
	        for (int i = 0; i < j; i++) { 
	            b.addElement(words.get(k-1)); 
	            k = k - 1; 
	        } 
	        return b;
		}

}
