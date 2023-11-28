import java.io.*;
import java.sql.Array;
import java.util.*;

public class Quantiles {
    public static void main(String[] args){
        File incomes = new File("C:\\Git\\Data_Structures_and_Algorithms\\PS11\\Testing.txt");

        ArrayList<Integer> incomeList = new ArrayList<>();


        //Read file
        try {
			Scanner scanner = new Scanner(incomes);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
                //Add elements in file to list 
                incomeList.add(Integer.parseInt(line));

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        Scanner robo = new Scanner(System.in);
        int k = robo.nextInt();
        int m = (int)Math.ceil((double)incomeList.size()/k); //Length of each Quartile

        System.out.println(m);
    }
}
