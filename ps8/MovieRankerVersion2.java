import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.util.Stack;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Collections;

public class MovieRankerVersion2{

	//static MaxHeap<MovieRating> movies = new MaxHeap<>();
	

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		File file = new File("C:/NJIT/Fall 23/PS8/ratings.tsv");
		MaxHeap<MovieRating> temp = new MaxHeap<>();

		//ArrayList<MovieRating> rl = new ArrayList<MovieRating>();

		
		
		//System.out.println(movies.returnHeap().toString());
		
		

		//System.out.println("Reading in took: "+(System.currentTimeMillis()-startTime));


		int minVotes = 1;
		int numRecords = 1;
                assert minVotes==0: "pos minvotes";
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("Enter minimum vote threshold and number of records:");
			minVotes = input.nextInt();
			numRecords = input.nextInt();
			if (minVotes * numRecords == 0)
				break;
				
				startTime = System.currentTimeMillis();
				
				// fill in code to process query
				
				
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
						String[] tkns = line.split("\\t");
						int votes = Integer.parseInt(tkns[0]);
						int rtg = Integer.parseInt(tkns[1]);
		
						MovieRating nr = new MovieRating(tkns[2], rtg, votes);
						processList(minVotes, numRecords, nr, temp);
		
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}


		
			while(0 < numRecords && !temp.isEmpty()){
			System.out.println(temp.removeMax());
			numRecords--;
			}


			System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
		}
		input.close();
	}


	static void processList(int minVotes, int numRecords,MovieRating nr, MaxHeap<MovieRating> temp){
			MovieRating mr = findMovie(minVotes,nr);
			if(mr != null){
				temp.insert(mr);
				//System.out.println(temp.returnHeap().toString());
			}

	} 

	static MovieRating findMovie(int minVotes,MovieRating nr){
		
		MovieRating mr = nr;
		//System.out.println( "mr votes:" + mr.getVotes());
		//System.out.println("minVotes: " + minVotes);
		if(mr.getVotes() >= minVotes){
			return mr;
		}
		return null;
	}
}
