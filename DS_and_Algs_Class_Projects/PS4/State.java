
/*
 Define states to be used in solving the Jug problem.
*/


class State {
    	int c1; // First jug
    	int c2; // Second jug 
    	int c3; // Third jug

	
	int d; // Goal

    	State prev; // predecessor state

    	State () {

		c1 = 0;
		c2 = 0;
		c3 = 0;

	}

	State(int inC1, int inC2, int inC3, int goal){

		c1 = inC1;
		c2 = inC2;
		c3 = inC3;
		d = goal;
	}

    	State (State s, State prev) {
        	c1 = s.c1;
        	c2 = s.c2;
        	c3 = s.c3;
		this.prev = prev;
		
    	}


	State (int j1, int j2, int j3, State prev){
	
		c1 = j1;
		c2 = j2;
		c3 = j3;
		this.prev = prev;
	
	}

	boolean equiv(State s){
        	if(s.c1 == c1 && s.c2 == c2 && s.c3 == c3)
            		return true;
        	else
            		return false;
    	}


}
