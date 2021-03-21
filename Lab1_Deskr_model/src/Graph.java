import java.util.*;
public class Graph
{

    // Representation of the graph

    private static int infinite = 9999999;

    int[][]  LinkCost; // graph matrix
    int      num_nodes; // number of nodes

    // constructor takes in a matrix as its input
    Graph(int[][] mat)
    {
        int i, j;

        num_nodes = mat.length;

        LinkCost = new int[num_nodes][num_nodes];

        // copying the weights to LinkCost matrix
        for ( i=0; i < num_nodes; i++)
        {
            for ( j=0; j < num_nodes; j++)
            {
                LinkCost[i][j] = mat[i][j];

                if ( LinkCost[i][j] == 0 )
                    LinkCost[i][j] = infinite;
            }
        }
    }

    //function to get the nodes that are unreached
    public int unReached(boolean[] r)
    {
        boolean done = true;

        for ( int i = 0; i < r.length; i++ )
            if ( r[i] == false )
                return i;

        return -1;
    }


    public void Prim( )
    {
        int i, j, k, x, y;

        boolean[] Reached = new boolean[num_nodes]; // array to keep track of the reached nodes
        int[] predNode = new int[num_nodes];        // array to maintain min cost edge

        int cost = 0;
// starting vertex
        Reached[0] = true;
        //setting other vertices as unreached
        for ( k = 1; k < num_nodes; k++ )
        {
            Reached[k] = false;
        }

        predNode[0] = 0;      // No edge for node 0

        printCoveredNodes( Reached );

        //we iterate for n-1 nodes that haven't been reached yet
        for (k = 1; k < num_nodes; k++)
        {
            x = y = 0;

            for ( i = 0; i < num_nodes; i++ )
                for ( j = 0; j < num_nodes; j++ )
                {
//update the MST with the minimum cost Link
                    if ( Reached[i] && !Reached[j] &&
                            LinkCost[i][j] < LinkCost[x][y] )
                    {
                        x = i;
                        y = j;
                    }
                }

            System.out.println("Наступна вершина: (" +
                    + (x+1) + "," +
                    + (y+1) + ")" +
                    ", вартість = " + LinkCost[x][y]);


            predNode[y] = x;          // add the min cost link to predNode
            Reached[y] = true;

            printCoveredNodes( Reached );
            System.out.println();
            cost = cost + LinkCost[x][y];
        }
        System.out.println("Сумарна вартість: " + cost + "\n");
        printMinCostEdges( predNode );
    }
    // function to print the edges of spanning tree
    void printMinCostEdges( int[] a )
    {
        System.out.println("Вершини МПД: ");
        for ( int i = 0; i < num_nodes; i++ )
            System.out.println( (a[i]+1) + " --> " + (i+1) );
    }


    void printCoveredNodes(boolean[] Reached )
    {
        System.out.print("Покриті вершини = ");
        for (int i = 0; i < Reached.length; i++ )
            if ( Reached[i] )
                System.out.print( (i+1) + " ");
        System.out.println();
    }

}
