package dependencies;

import java.io.*;
import application.FormatTranslate;

public class TranslateTest extends FormatTranslate{
	public static void main(String[] args) throws IOException {
		File F = new File("sample_exam_BB.txt");
		if(F.exists()) {
		  
		}
		else {
          System.out.println("txt not exists, it was created under the root directory of the Project,you should update it.");
        try {
          F.createNewFile();
        } catch (IOException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
		String path = F.getPath();
		TranslateToQuestionOnly(path);
		TranslateToqa(path);
	}
}
