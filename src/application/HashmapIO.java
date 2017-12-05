package application;

import java.util.*;
import java.io.*;

public class HashmapIO {
	
    public static void readtxt(String path){
    	HashMap<String, String> h = new HashMap<String,String>();
    	ArrayList<Integer> key = new ArrayList<Integer>();
    	ArrayList<String> value = new ArrayList<String>();
	    File file = new File(path);
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
	        String s = null;
	        while((s=br.readLine())!=null){
	        	String [] st = s.split(" : ");
	            key.add(st[0].hashCode());
	            value.add(st[1]);	            
	        }
	        br.close();
	        for(int i = 0; i < key.size(); i++){
	            h.put(key.get(i).toString(), value.get(i));
	        }
	        System.out.println(h);
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
    
    public static void writetxt(String path,String key_added,String value_added) {
    	HashMap<String, String> H = new HashMap<String,String>();
    	H.put(key_added, value_added);
    	try {
    		String line = System.getProperty("line.separator");
    		StringBuffer str = new StringBuffer();
    		FileWriter fw = new FileWriter(path, true);
    		Set set = H.entrySet();
    		Iterator iter = set.iterator();
    		while(iter.hasNext()){
    		HashMap.Entry entry = (HashMap.Entry)iter.next();
    		str.append(entry.getKey()+" : "+entry.getValue()).append(line);
    		}
    		fw.write(str.toString());
    		fw.close();
    		} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
    		}    

}
