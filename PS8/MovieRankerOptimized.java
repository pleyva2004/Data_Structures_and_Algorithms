import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.util.Stack;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Collections;

public class MovieRankerOptimized {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		File file = new File("C:\\Coding\\Repositories\\Data_Structures_and_Algorithms\\PS8\\ratings.tsv");

		MaxHeap<MovieRating> movies = new MaxHeap<>();
		
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
                                String[] tkns = line.split("\\t");
                                int votes = Integer.parseInt(tkns[0]);
                                int rtg = Integer.parseInt(tkns[1]);

				MovieRating nr = new MovieRating(tkns[2], rtg, votes);

				//add MovieRating to Heap "movies"
				movies.insert(nr);
				

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


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

			
		MaxHeap<MovieRating> temp = processList(minVotes, numRecords, movies);

			
		while(0 < numRecords && !temp.isEmpty()){
			System.out.println(temp.removeMax());
			numRecords--;
		}


			System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
		}
		input.close();
	}


	static MaxHeap<MovieRating> processList(int minVotes, int numRecords, MaxHeap<MovieRating> movies){
		MaxHeap<MovieRating> temp = new MaxHeap<>();
		int pos = 0;

		while(pos < movies.heapsize()){
			MovieRating mr = findMovie(minVotes,pos, movies);
			if(mr != null){
				if(pos < numRecords){
				}
				// else{
					// 	for(MovieRating var : temp.returnHeap()){
						// 		if(var.getRating() > mr.getRating()){
							// 			if(temp.get(temp.heapsize()-2).getRating() > temp.get(temp.heapsize()-1).getRating()){
								// 				temp.remove(temp.heapsize()-1);
								// 			}
								// 			else{
									// 				temp.remove(temp.heapsize()-2);
									// 			}
									// E			temp.insert(var);
				// 		}
				// 	}
				// }
				
				
				temp.insert(mr);
	
			}
			pos++;
		}

		//System.out.println(temp.returnHeap().toString());
		return temp;
	} 

	//return movie rating if it has minVotes
	static MovieRating findMovie( int minVotes,int pos, MaxHeap<MovieRating> movies){
		
		MovieRating mr = movies.returnHeap().get(pos);
		//System.out.println( "mr votes:" + mr.getVotes());
		//System.out.println("minVotes: " + minVotes);
		if(mr.getVotes() >= minVotes){
			return mr;
		}
		return null;
	}
}
