import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;


public class MostAnagrams {

  static ArrayList<WordPair> wordList = new ArrayList<>();
  static ArrayList<String> collectedAnagrams = new ArrayList<>();
  static OALDictionary<String,ArrayList<String>> dictionary = new OALDictionary<>();

  public static void main(String[] args) {
    //Read user input
    Scanner robo = new Scanner(System.in);
    int end = robo.nextInt();
    

    
    //read user input
    File file = new File("C:/NJIT/Fall 23/PS7/words.txt");
    readFile(file, end);
    
    
        int num = 0;
    
        //debugging
          //System.out.println("Starting num: " + num);
          //System.out.println(wordList.toString() + "\n");
    
          // Comparator<WordPair> comparator = new Comparator<WordPair>() {
          //   @Override
          //   public int compare(WordPair w1, WordPair w2) {
          //     return w1.getSorted().compareTo(w2.getSorted());
          //   }
          // };


    //Sort ArrayList
    Collections.sort(wordList);
    
    
   
    
    //prompt the
    System.out.println("(1) count all the anagrams in the file before the line number " + end);
    System.out.println("(2) find the length of the largest anagram in the file before the line number " + end);
    System.out.println("(3) find the set of the largest anagram in the file before the line number " + end);
    System.out.println("(4) find the largest set of anagrams in the file before the line number " + end);
    System.out.println("(5) dictionary version" + end);

    System.out.print("Which program do you wanna run: ");

    int userChoice = robo.nextInt();

    if(userChoice == 1){
      // count all the anagrams in the file before the line number "end"
      num = countAllAnagrams(end);
    }
    else if(userChoice == 2){
      //finds the length of the largest anagram in the file before the line number "end"
      num = findLargestAnagram(end);
    }
    else if(userChoice == 3){
      //counts all the anagrams in the set with the largest word in the file before the line number "end"
      num = countLargestAnagram(end);
    }
    else if(userChoice == 4){
      //counts all the anagrams in the set with the largest word in the file before the line number "end"
      num = largestSetOfAnagram(end);
    }
    else if(userChoice == 5){
     ArrayList<String> max = searchDict();
      num = max.size();
      for(String str : max){
       System.out.println(str);
     }
    }
    robo.close();

    System.out.println("\n" + num);

    //System.out.println(wordList.toString());
    
    //  for(String str : dictionary.evaluate()){
    //    System.out.println(str);
    //  }
    
    
  }

  static void readFile(File file, int end){ 
    try {
      Scanner scanner = new Scanner(file);

      while (scanner.hasNext() && end > 0) {

        // read in the next word
        String str = scanner.next();

        // Fill ArrayList with words
        //wordList.add(new WordPair(str));  
        WordPair wp =new WordPair(str);

        insertWord(wp);
        

        end--;
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  static void insertWord(WordPair wp){
    ArrayList<String> temp = dictionary.find(wp.getSorted()); 
    if(temp == null){
      ArrayList<String> arr = new ArrayList<>();
      arr.add(wp.getUnsorted());
      dictionary.insert(wp.getSorted(),arr);
    }
    else{
    temp.add(wp.getUnsorted());
    }
  }

  static int countAllAnagrams(int end){
    int count = 0;
    int i = 0, j = 1;
    
    //adjust end
    if(end > wordList.size()){
      end = wordList.size();
    }

    while(j < end){

      //if two words are anagrams, increase count and add to list
      if(wordList.get(i).compareTo(wordList.get(j)) == 0){
        count += 1; //increase count

        //add anagram pair to list
        collectedAnagrams.add(wordList.get(i).getWord());
        collectedAnagrams.add(wordList.get(j).getWord());


        //debugging
        //System.out.println("First Word: " + wordList.get(i).getWord());
        //System.out.println("Second Word: " + wordList.get(j).getWord());
        //System.out.println("Count: " + count);

      }

      i += 1;
      j += 1;
    }

    return count;
  }

  static int findLargestAnagram(int end){
    int max = 0;
    int i = 0, j = 1;
    
    //adjust end
    if(end > wordList.size()){
      end = wordList.size();
    }

    while(j < end){

      //if two words are anaagrams, compare word size to max
      if(wordList.get(i).compareTo(wordList.get(j)) == 0){

        //debugging
        //System.out.println("First Word: " + wordList.get(i).getWord());
        //System.out.println("Second Word: " + wordList.get(j).getWord());
        //System.out.println("Max: " + max);

        int temp = wordList.get(i).getWord().length();

        //compare current word size to max
        if(temp > max){
          max = temp;
        }
      }

      i += 1;
      j += 1;
    }

    return max;


  }

  static int countLargestAnagram(int end){
    int i = 0, j = 1;
    int max = 0; int count = 0;
    WordPair myWP = null;
    
    //adjust end
    if(end > wordList.size()){
      end = wordList.size();
    }

    while(j < end){

      //if two words are anagrams, compare size and add to list
      if(wordList.get(i).compareTo(wordList.get(j)) == 0){

        //debugging
        //System.out.println("First Word: " + wordList.get(i).getWord());
        //System.out.println("Second Word: " + wordList.get(j).getWord());
        //System.out.println("Max: " + max);
        //System.out.println("Count: " + count);

        int temp = wordList.get(i).getWord().length();

        //compare current size to max
        if(temp > max){
          max = temp;
          count = 1; //reset count when found new max

          //add anagram pair to list
          collectedAnagrams.clear();
          collectedAnagrams.add(wordList.get(i).getWord());
          collectedAnagrams.add(wordList.get(j).getWord());
          myWP = wordList.get(i);
        }
        else if(temp == max){
          count += 1; //increase count
          //check to to see if it is the same word and if it is add pair
          if(myWP.compareTo(wordList.get(i)) == 0){
            collectedAnagrams.add(wordList.get(i).getWord());
          }
        }
      }

        i += 1;
        j += 1;
    }

    

      return count;
  }

  static int largestSetOfAnagram(int end){
    int i = 0, j = 1;
    int count = 0;
     
    
    while(j < wordList.size()){

      //if two words are anaagrams, count the words that are in that set of anagrams and adjust count
      if(wordList.get(i).compareTo(wordList.get(j)) == 0){

        //debugging
        //System.out.println("First Word: " + wordList.get(i).getWord());
        //System.out.println("Second Word: " + wordList.get(j).getWord());
        //System.out.println("Count: " + count);

        //find all the anagrams in the set 
        WordPair myWord = wordList.get(i);
        int newCount = countHelper(j, myWord, 2);

        //adjust count if bigger set found
        if(newCount > count){
          count = newCount;

          //add anagram pair to list
          collectedAnagrams.clear();
          collectedAnagrams.add(wordList.get(i).getWord());
          collectedAnagrams.add(wordList.get(j).getWord());
          addAnagramPairs(j, myWord);
        }
           
    
      }

      i += 1;
      j += 1;
    }

    return count;
  }

  static int countHelper(int start, WordPair word, int count){
    
    int j = start + 1;

    while(j < wordList.size()){
      

      //if two words are anaagrams, inc count
      if(word.compareTo(wordList.get(j)) == 0){
        count += 1;

        //debugging
        //System.out.println("First Word: " + word.getWord());
        //System.out.println("Second Word: " + wordList.get(j).getWord());
        //System.out.println("Count: " + count);

      }
      j += 1;
    }


    return count;
  }
  static void addAnagramPairs(int start, WordPair word){
    int j = start + 1;

    while(j < wordList.size()){
      
      //if two words are anaagrams, inc count
      if(word.compareTo(wordList.get(j)) == 0){
        collectedAnagrams.add(wordList.get(j).getWord());

        //debugging
        //System.out.println("First Word: " + word.getWord());
        //System.out.println("Second Word: " + wordList.get(j).getWord());
        //System.out.println("Count: " + count);

      }

      j += 1;
    }

  }

  static ArrayList<String> searchDict(){
    ArrayList<String> max = new ArrayList<>();
    for(ArrayList<String> arr : dictionary.values()){
      if(arr.size() > max.size()){
        max = arr;
      }
    }
    return max;
  }

  
}




