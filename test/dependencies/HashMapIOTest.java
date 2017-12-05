package dependencies;

import java.io.*;
import application.HashmapIO;

public class HashMapIOTest extends HashmapIO{
	public static void main(String[] args) {
		File F = new File("config.inf");
		if(F.exists()) {
		  System.out.println("Config Exists.");	
		}
		else {
          System.out.println("Config not exists, it was created under the root directory of the Project.");
        try {
          F.createNewFile();
        } catch (IOException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
		String path = F.getPath();
		writetxt(path,"autorun","True");
		writetxt(path,"UserName","MyAccount");
		writetxt(path,"K","V");
		readtxt(path);
	}
}
