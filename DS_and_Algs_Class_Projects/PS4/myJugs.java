
import java.util.Scanner;
import java.util.ArrayDeque;
public class myJugs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C1 = scan.nextInt();
		int C2 = scan.nextInt();
		int C3 = scan.nextInt();
		int d = scan.nextInt();
		
	System.out.println(pour(C1,C1,0, C2, 0,C3,d));
		
		scan.close();
		
		
}
	public static String pour(int c1, int C1, int c2, int C2, int c3, int C3, int d) {
		ArrayDeque <State> checked = new ArrayDeque <State> ();
		ArrayDeque <State> visited = new ArrayDeque <State> ();

		checked.add(new State(c1, c2, c3,null));

		int [] max = {C1, C2, C3};
		
		while(!checked.isEmpty()) {

			State current = checked.poll();
			visited.add(current);

		
			if(current.c1 == d || current.c2==d || current.c3==d) {
				StringBuilder resluts = new StringBuilder();
				State s = current;
				while(s != null) {
					resluts.insert(0, s.c1 + " "+ s.c2 + " " + s.c3 + "\n");
					s = s.prev;
				}
				return resluts.toString();
			}

			for(int i = 0; i <= 2;i++) {
				for(int m = 0; m <= 2; m++) {
					
					int[] jugs = {current.c1,current.c2,current.c3};

					if(i!=m) {
						if(jugs[i]>0) {
							if(jugs[m]<max[m]) {
								int temp = Math.min(max[m]-jugs[m], jugs[i]);
								jugs[i] -= temp;
								jugs[m] += temp;

								State next = new State(jugs[0],jugs[1],jugs[2],current);
								
								
								boolean flag = false;
								for(State s: visited) {
									if(s.equiv(next)) {
										 flag = true;
									}
								}

								if(!flag) {
									checked.add(next);
									visited.add(current);
								}
							}						
						}
					}	
				}
			}
		}
			return " ";
}

/* 
static class State {
	int c1; 
	int c2; 
	int c3; 
	State prev;
	//State pred; 
	State() {
	c1 = 0;
	c2 = 0;
	c3 = 0;
	}
	State(State s,State prev) {
	c1 = s.c1;
	c2 = s.c2;
	c3 = s.c3;
	this.prev = prev;
	}
	State(int c1, int c2, int c3, State prev) {
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.prev = prev;
		}
	
 }
 */

}