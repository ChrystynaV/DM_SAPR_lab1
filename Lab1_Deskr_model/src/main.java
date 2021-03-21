import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\4 курс\\ІІ\\Дискретні моделі в САПР\\ЛР\\l1-1.txt")));
        int r = 8;
        int[][] matrix = new int[r][r];
        int[][] matrix2 = new int[r][r];
        while (sc.hasNextLine()) {
            for (int i = 0; i < matrix.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    matrix2[i][j] = Integer.parseInt(line[j]);
                }

            }
        }
        System.out.println("Матриця інцидентності з файлу:");
        for (int i=0; i<r; i++){
            for (int j=0; j<r; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        /*        int[][] conn = {{0, 4, 0, 0, 5},
                {4, 0, 3, 6, 1},
                {0, 3, 0, 6, 2},
                {0, 6, 6, 0, 7},
                {5, 1, 2, 7, 0},
        };   */
        Graph G = new Graph(matrix);
        MaxGraph G2 = new MaxGraph(matrix);
        System.out.println("\n-- Мінімальне покриваюче дерево --");
        G.Prim();

        System.out.println("\n\n-- Максимальне покриваюче дерево --");
        G2.Prim();
        //PrimMax.maximumSpanningTree(matrix2);
    }
}
