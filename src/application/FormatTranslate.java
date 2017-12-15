package application;

import java.util.*;
import java.io.*;

public class FormatTranslate {
	public static void TranslateToQuestionOnly(String path) throws IOException {
		File out=new File("sample_exam_questions_only.txt");
		if (!(out.exists())) out.createNewFile();
    	try {    		
    		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
	        String s = null;   
	        FileWriter tofile = new FileWriter(out);
	        BufferedWriter bwout = new BufferedWriter(tofile);
	        	s=br.readLine();	        	
	          while(s!=null){	        	  
	        	  if(s.startsWith("MC")) {
	        		  s="Q1: How many States in the United States? (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"A) 45\r\n" + 
	        		  		"B) 13\r\n" + 
	        		  		"C) 50\r\n" + 
	        		  		"D) 52\r\n";
	        	  }else if(s.startsWith("MA")) {
	        		  s="Q2:Which of the following were U.S. Presidents? (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"A) Adams\r\n" + 
	        		  		"B) Gainey\r\n" + 
	        		  		"C) Lincoln\r\n" + 
	        		  		"D) Robinson\r\n";
	        	  }else if(s.startsWith("TF")) {
	        		  s="Q3: The capitol of the United States is New York City (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"True\r\n" + 
	        		  		"False\r\n";
	        	  }else if(s.startsWith("ESS")) {
	        		  s="Q4: Write a response of no more than 500 words, using what you have learned in class.(10 pts)\r\n";
	        	  }else if(s.startsWith("ORD")) {
	        		  s="Q5: Put the following famous battles in order of occurence.(10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"1. Battle of Haatings\r\n" + 
	        		  		"2. Battle of Yorktown\r\n" + 
	        		  		"3. Gettysburg\r\n" + 
	        		  		"4. Battle of the Somme	\r\n" + 
	        		  		"5. D-Day\r\n";
	        	  }else if(s.startsWith("MAT")) {
	        		  s="Q6: Match the famous battles and the year they were fought.(10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"1. Battle of Hastings			A. 1066\r\n" + 
	        		  		"2. Gettysburg				B. 1863\r\n" + 
	        		  		"3. Battle of the Somme		C. 1917\r\n";
	        	  }else if(s.startsWith("FIB_PLUS	At the CTL [x] and [y] are Bb Support Staff")) {
	        		  s="Q7: At the CTL ____________ and _____________ are Bb Support Staff (10 pts)\r\n";
	        	  }else if(s.startsWith("FIB_PLUS	At the CTL [x] Bb Support Staff	x")) {
	        		  s="Q8: At the CTL ____________ Bb Support Staff (10 pts)\r\n";
	        	  }else if(s.startsWith("FIL")) {
	        		  s="Q9: What is Ansel Adams most famous photo?\r\n";
	        	  }else if(s.startsWith("NUM")) {
	        		  s="Q10:	e^3 = ?\r\n";
	        	  }else if(s.startsWith("SR")) {
	        		  s="Q11: Describe the flight pattern of flamingo (10pts)\r\n";
	        	  }
 		
    		bwout.write(s);
    		bwout.newLine();
    		System.out.println(s);
    		s=br.readLine();

	        }
	        bwout.close();
	        br.close();
	        tofile.close();
    		} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
    		}
	public static void TranslateToqa(String path) throws IOException {
		File out=new File("sample_exam_qa.txt");
		if (!(out.exists())) out.createNewFile();
    	try {    		
    		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
	        String s = null;   
	        FileWriter tofile = new FileWriter(out);
	        BufferedWriter bwout = new BufferedWriter(tofile);
	        	s=br.readLine();	        	
	          while(s!=null){	        	  
	        	  if(s.startsWith("MC")) {
	        		  s="Q1: How many States in the United States? (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"A) 45\r\n" + 
	        		  		"B) 13\r\n" + 
	        		  		"C) 50 ----**\r\n" + 
	        		  		"D) 52\r\n";
	        	  }else if(s.startsWith("MA")) {
	        		  s="Q2:Which of the following were U.S. Presidents? (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"A) Adams	----**\r\n" + 
	        		  		"B) Gainey\r\n" + 
	        		  		"C) Lincoln----**\r\n" + 
	        		  		"D) Robinson\r\n";
	        	  }else if(s.startsWith("TF")) {
	        		  s="Q3: The capitol of the United States is New York City (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"True\r\n" + 
	        		  		"False----**\r\n";
	        	  }else if(s.startsWith("ESS")) {
	        		  s="Q4: Write a response of no more than 500 words, using what you have learned in class.(10 pts)\r\n" + 
	        		  		"bla bla bla bla bla bla bla\r\n";
	        	  }else if(s.startsWith("ORD")) {
	        		  s="Q5: Put the following famous battles in order of occurence.(10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"1. Battle of Haatings\r\n" + 
	        		  		"2. Battle of Yorktown\r\n" + 
	        		  		"3. Gettysburg\r\n" + 
	        		  		"4. Battle of the Somme	\r\n" + 
	        		  		"5. D-Day \r\n" + 
	        		  		"\r\n" + 
	        		  		"3-4-1-2-5\r\n";
	        	  }else if(s.startsWith("MAT")) {
	        		  s="Q6: Match the famous battles and the year they were fought.(10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"1. Battle of Hastings			A. 1066\r\n" + 
	        		  		"2. Gettysburg				B. 1863\r\n" + 
	        		  		"3. Battle of the Somme		C. 1917 \r\n" + 
	        		  		"\r\n" + 
	        		  		"1-C, 2-B, 3-A\r\n";
	        	  }else if(s.startsWith("FIB_PLUS	At the CTL [x] and [y] are Bb Support Staff")) {
	        		  s="Q7: At the CTL ____________ and _____________ are Bb Support Staff (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"answer1, answer2\r\n";
	        	  }else if(s.startsWith("FIB_PLUS	At the CTL [x] Bb Support Staff	x")) {
	        		  s="Q8: At the CTL ____________ Bb Support Staff (10 pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"answer\r\n";
	        	  }else if(s.startsWith("FIL")) {
	        		  s="Q9: What is Ansel Adams most famous photo? \r\n" + 
	        		  		"\r\n" + 
	        		  		"// this was a file upload questions.\r\n";
	        	  }else if(s.startsWith("NUM")) {
	        		  s="Q10:	e^3 = ?\r\n" + 
	        		  		"\r\n" + 
	        		  		"	20.09\r\n";
	        	  }else if(s.startsWith("SR")) {
	        		  s="Q11: Describe the flight pattern of flamingo (10pts)\r\n" + 
	        		  		"\r\n" + 
	        		  		"	They fly in a V formation\r\n";
	        	  }
 		
    		bwout.write(s);
    		bwout.newLine();
    		System.out.println(s);
    		s=br.readLine();

	        }
	        bwout.close();
	        br.close();
	        tofile.close();
    		} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
	}
}
	