import java.io.*; 
/*
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName  = reader.readLine(); 
        reader.close();
    
        FileInputStream readerByte = new FileInputStream(fileName); 
        int [] countsByte = new int[256];  
        int currentByte; 
        while(readerByte.available() > 0){
            currentByte = readerByte.read(); 
            countsByte[currentByte]++; 
        }
        readerByte.close(); 
        for (int i = 0; i < countsByte.length; i++){
            if (countsByte[i] > 0) {
                System.out.print(i + " "); 
            }
        }
    }  
}