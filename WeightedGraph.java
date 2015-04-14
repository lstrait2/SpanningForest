import java.io.*;
import java.util.*;


public class WeightedGraph
{
	/*
	static class Node
	{
		final int index;
		Node ancestor;
	
		Node(int index)
		{
			this.index = index;
			ancestor = this;
		}
		

	}
	*/

	/*
	static class Edge implements Comparable<Edge>
	{
		final Node u, v;
		boolean inSF = false;
		int weight;
		Edge(Node u, Node v, int w)
		{
			this.u = u;
			this.v = v;
			this.weight = w;
		}

		public int compareTo(Edge other)
		{
			// return 0 if equal, < 0 if other is greater, and > 0 if this is greater
			return(this.weight - other.weight);

		}

	}
	*/

	

	ArrayList<Edge> edges;
	Node[] nodes;

	public WeightedGraph()
	{
		edges = new ArrayList<>();
		nodes = new Node[0];
	}
	
	static WeightedGraph readWeightedEdgeGraph(String file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		WeightedGraph g = new WeightedGraph();
		
		if(!"WeightedEdgeArray".equals(reader.readLine()))
			throw new IOException("invalid edge graph format");

		while(true)
		{
			String line;

			try
			{
				line = reader.readLine();
			}catch(EOFException e){ break;}
			

			if(line == null)
				break;
			
			String[] words = line.split("[ \t]+");
			if(words.length != 3)
				throw new IOException("invalid edge graph format");
			
			int u = Integer.parseInt(words[0]);
			int v = Integer.parseInt(words[1]);
			double w = Double.parseDouble(words[2]);

			Node U = g.getVertex(u);
			Node V = g.getVertex(v);
		
			g.addEdge(U,V,w);
		}
		return g;
	}

	public Node getVertex(int n)
	{
		if(nodes.length < n)
			nodes = Arrays.copyOf(nodes, n+1+ n/2);
		
		if(nodes[n] == null)
			nodes[n] = new Node(n);
		
		return nodes[n];
	}

	public void addEdge(Node u, Node v, double w)
	{
		Edge edge = new Edge(u,v,w);
		edges.add(edge);
	}


}
