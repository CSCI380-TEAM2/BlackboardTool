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
	        	  String [] str=s.split("\\t");
	        	  if (s.startsWith("MC")) {
	        		  str[0]="";
	        		  str[1]="Q1:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="A) "+str[2];
	        		  str[3]="";
	        		  str[4]="B) "+str[4];
	        		  str[5]="";
	        		  str[6]="C) "+str[6];
	        		  str[7]="";
	        		  str[8]="D) "+str[8];
	        		  str[9]="";
	        		  
	        	  }else if(s.startsWith("MA")&&str[0].contains("T")) {	       
	        		  str[0]="";
	        		  str[1]="Q6:"+str[1]+"(10 pts)\r\n"+"\r\n";
	        		  str[2]="1) "+str[2]+"\t\t\tA)"+str[3];
	        		  str[3]="";
	        		  str[4]="2) "+str[4]+"\t\t\tB)"+str[5];
	        		  str[5]="";
	        		  str[6]="3) "+str[6]+"\t\t\tC)"+str[7];
	        		  str[7]="";
	        	  }else if(s.startsWith("TF")) {
	        		  str[0]="";
	        		  str[1]="Q3:"+str[1]+"(10 pts)"+"\r\n";
	        		  if(str[2].equals("False")) {
	        			  str[2]="True"+"\r\n\r\n"+str[2];
	        		  }else {
	        			  str[2]=str[2]+"\r\n\r\n"+"False";
	        		  }
	        		  
	        	  }else if(s.startsWith("ESS")) {
	        		  str[0]="";
	        		  str[1]="Q4:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="";
	        		  
	        	  }else if(s.startsWith("ORD")) {
	        		  str[0]="";
	        		  str[1]="Q5:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="1. "+str[2];
	        		  str[3]="2. "+str[3];
	        		  str[4]="3. "+str[4];
	        		  str[5]="4. "+str[5];
	        		  str[6]="5. "+str[6];
	        	  }else if(s.startsWith("FIL")) {
	        		  str[0]="";
	        		  str[1]="Q9:"+str[1]+"(10 pts)"+"\r\n";
	        	  }else if(s.startsWith("NUM")) {
	        		  str[0]="";
	        		  str[1]="Q10:"+str[1]+"= ? "+"\r\n";
	        		  str[2]="";
	        		  str[3]="";
	        	  }else if(s.startsWith("SR")) {
	        		  str[0]="";
	        		  str[1]="Q11:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="";
	        	  }else if(s.startsWith("FIB_PLUS")&& str[1].contains("[y]")) {
	        		  str[0]="";
	        		  str[1]="Q7:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="";
	        		  str[3]="";
	        		  str[4]="";
	        		  str[5]="";
	        		  str[6]="";
	        		  str[7]="";
	        	  }else if(s.startsWith("FIB_PLUS")) {
	        		  str[0]="";
	        		  str[1]="Q8:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="";
	        		  str[3]="";
	        		  str[4]="";
	        	  }else if(s.startsWith("MA")) {
	        		  System.out.println(str.length);
	        		  str[0]="";
	        		  str[1]="Q2:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="A) "+str[2];
	        		  str[3]="";
	        		  str[4]="B) "+str[4];
	        		  str[5]="";
	        		  str[6]="C) "+str[6];
	        		  str[7]="";
                      str[8]="D) "+str[8];
                      str[9]="";
	        	  }	        	  
 		for(int i=0;i<str.length;i++) {			
    		bwout.write(str[i]);
    		bwout.newLine();
    		   		}
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
	        	  String [] str=s.split("\\t");
	        	  if (s.startsWith("MC")) {
	        		  str[0]="";
	        		  str[1]="Q1:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="A) "+str[2];
	        		  str[3]="";
	        		  str[4]="B) "+str[4];
	        		  str[5]="";
	        		  str[6]="C) "+str[6]+" ----**";
	        		  str[7]="";
	        		  str[8]="D) "+str[8];
	        		  str[9]="";
	        		  
	        	  }else if(s.startsWith("MA")&&str[0].contains("T")) {	       
	        		  str[0]="";
	        		  str[1]="Q6:"+str[1]+"(10 pts)\r\n"+"\r\n";
	        		  str[2]="1) "+str[2]+"\t\t\tA)"+str[3];
	        		  str[3]="";
	        		  str[4]="2) "+str[4]+"\t\t\tB)"+str[5];
	        		  str[5]="";
	        		  str[6]="3) "+str[6]+"\t\t\tC)"+str[7]+"\r\n";
	        		  str[7]="1-C, 2-B, 3-A";
	        	  }else if(s.startsWith("TF")) {
	        		  str[0]="";
	        		  str[1]="Q3:"+str[1]+"(10 pts)"+"\r\n";
	        		  if(str[2].equals("False")) {
	        			  str[2]="True"+"\r\n\r\n"+str[2]+"----**";
	        		  }else {
	        			  str[2]=str[2]+"----**"+"\r\n\r\n"+"False";
	        		  }
	        		  
	        	  }else if(s.startsWith("ESS")) {
	        		  str[0]="";
	        		  str[1]="Q4:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="bla bla bla bla bla bla bla";
	        		  
	        	  }else if(s.startsWith("ORD")) {
	        		  str[0]="";
	        		  str[1]="Q5:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="1. "+str[2];
	        		  str[3]="2. "+str[3];
	        		  str[4]="3. "+str[4];
	        		  str[5]="4. "+str[5];
	        		  str[6]="5. "+str[6]+"\r\n\r\n"+"3-4-1-2-5";
	        	  }else if(s.startsWith("FIL")) {
	        		  str[0]="";
	        		  str[1]="Q9:"+str[1]+"(10 pts)"+"\r\n"+"// this was a file upload questions.";
	        	  }else if(s.startsWith("NUM")) {
	        		  str[0]="";
	        		  str[1]="Q10:"+str[1]+"= ? "+"\r\n";
	        		  str[2]=str[2];
	        		  str[3]="";
	        	  }else if(s.startsWith("SR")) {
	        		  str[0]="";
	        		  str[1]="Q11:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]=str[2];
	        	  }else if(s.startsWith("FIB_PLUS")&& str[1].contains("[y]")) {
	        		  str[0]="";
	        		  str[1]="Q7:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="answer1\r\n";
	        		  str[3]="";
	        		  str[4]="answer2";
	        		  str[5]="";
	        		  str[6]="";
	        		  str[7]="";
	        	  }else if(s.startsWith("FIB_PLUS")) {
	        		  str[0]="";
	        		  str[1]="Q8:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="anwser";
	        		  str[3]="";
	        		  str[4]="";
	        	  }else if(s.startsWith("MA")) {
	        		  System.out.println(str.length);
	        		  str[0]="";
	        		  str[1]="Q2:"+str[1]+"(10 pts)"+"\r\n";
	        		  str[2]="A) "+str[2]+	"----**";
	        		  str[3]="";
	        		  str[4]="B) "+str[4];
	        		  str[5]="";
	        		  str[6]="C) "+str[6]+"----**";
	        		  str[7]="";
                      str[8]="D) "+str[8];
                      str[9]="";
	        	  }
	        	  for(int i=0;i<str.length;i++) {
	       			
	          		bwout.write(str[i]);
	          		bwout.newLine();
	          		System.out.println(s);
	          		   		}
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
	