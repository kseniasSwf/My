import java.util.*; 
import java.io.*; 

public class Sol {

	public static void main(String[] args) throws Exception  {
		ArrayList<String> lines = new ArrayList<String>(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String fileName1 = reader.readLine(); 
		String fileName2 = reader.readLine();
		reader.close(); 
		
		BufferedReader readerF1 = new BufferedReader(new FileReader(fileName1)); 
		BufferedReader readerF2 = new BufferedReader(new FileReader(fileName2)); 
		
		String currentF1 = readerF1.readLine(); 
		String currentF2 = readerF2.readLine(); 
		String nextF1 = null; 
		while(currentF1  != null && currentF2 !=null) {
			if(currentF1.equals(currentF2)) {
				lines.add("Same " + currentF1); 
				currentF1 = (nextF1 == null) ? readerF1.readLine() : nextF1;
				nextF1 = null; 
				currentF2 = readerF2.readLine(); 
			} else {
				nextF1 = readerF1.readLine(); 
				if(nextF1.equals(currentF2)) {
					lines.add("Remove " + currentF1);  
					currentF1 = nextF1; 
					nextF1 = null;
				} else {
					lines.add("Add " + currentF2);
					currentF2 = readerF2.readLine(); 	
				}
			}
		}
		readerF1.close();
		readerF2.close();
		if (currentF1 == null && currentF2 != null) {
			lines.add("Add " + currentF2);
		} else {
			if (currentF1 != null && currentF2 == null) {
				lines.add("Remove " + currentF1);
			}
		}
		
		for(String sr : lines) {
			System.out.println(sr); 
		}
	}

}
