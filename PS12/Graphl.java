import java.util.ArrayList;
import java.util.Iterator;

/** Adjacency list graph implementation */
class Graphl implements Graph {
	private ArrayList<ArrayList<Integer>> vertex; // The vertex list
	private int numEdge; // Number of edges
	public int[] Mark; // The mark array
	public Iterator[] it;

	public Graphl(int n) // Constructor
	{
		vertex = new ArrayList<>();
		Init(n);
	}

	public void Init(int n) {
		Mark = new int[n];
		it = new Iterator[n];
		for (int i = 0; i < n; i++)
			vertex.add(new ArrayList<>());
		numEdge = 0;
	}

	public int n() {
		return Mark.length;
	} // # of vertices

	public int e() {
		return numEdge;
	} // # of edges

	/** @return v's first neighbor */
	public int first(int v) {

		if (vertex.get(v).size() == 0)
			return Mark.length; // No neighbor
		else {
			it[v] = vertex.get(v).iterator();
			int w = (int) it[v].next();
			return w;
		}
	}

	/** @return v's next neighbor after w */
	public int next(int v, int w) {
		if (it[v].hasNext()) {
			return (int) it[v].next();
		} else
			return Mark.length;
	}

	public void setEdge(int i, int j, int weight) {
		vertex.get(i).add(j);
		++numEdge;
	}

	/** Delete an edge */
	public void delEdge(int i, int j) {
		if (isEdge(i, j)) {
			vertex.get(i).remove(j);
			numEdge--;
		}
	}

	/** Determine if an edge is in the graph */
	public boolean isEdge(int v, int w) {
                boolean b = vertex.get(v).contains(w);
                //if(b) System.out.println("Contained edge.");
                return b;
	}

	/** @return an edge's weight */
	public int weight(int i, int j) {
		return 0;
	}

	/** Set/Get the mark value for a vertex */
	public void setMark(int v, int val) {
		Mark[v] = val;
	}

	public int getMark(int v) {
		return Mark[v];
	}

	/** @return iterable object for neighbors */
	public Iterable<Integer> neighbors(int v) {
		return vertex.get(v);
	}



}
