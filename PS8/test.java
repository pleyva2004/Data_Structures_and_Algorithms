public class test {
      public static void main(String[] args){
            MaxHeap<MovieRating> heap = new MaxHeap<>();

            heap.insert(new MovieRating("abc", 50, 1000));
            heap.insert(new MovieRating("abc", 50, 1000));
            heap.insert(new MovieRating("abc", 50, 1000));
            
            System.out.println(heap.returnHeap().get(2));
      
      }
}
