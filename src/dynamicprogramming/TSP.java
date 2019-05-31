package dynamicprogramming;

import factory.IMatrixManipulatorFactory;
import factory.MatrixManipulatorFactorty;
import java.util.ArrayList;
import java.util.List;
import matrix.IMatrixManipulator;

public class TSP extends AbstractTSP {

    final double MAX_DOUBLE = Double.MAX_VALUE;

    public TSP() {
    }

    @Override
    public void define(double[][] adjacencyMatrix) {        
        initializeTSP(adjacencyMatrix);
    }

    @Override
    public void solve() {
        int[] vertex = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            vertex[i] = i + 1;
        }

        cost[mapSubsetToNumber(new int[]{1})][1] = 0;
        for (int size = 2; size < numberOfVertices + 1; size++) {
            boolean[] used = new boolean[vertex.length];
            List<int[]> result = new ArrayList<>();
            allSubsetOfSizeK(result, vertex, size, 0, 0, used);
            for (int i = 0; i < result.size(); i++) {
                int[] subset = result.get(i);
                cost[mapSubsetToNumber(subset)][1] = MAX_DOUBLE;
                for (int k = 0; k < subset.length; k++) {
                    int j = subset[k];
                    if (j == 1) {
                        continue;
                    }
                    cost[mapSubsetToNumber(subset)][j] = minCost(subset, j);
                }
            }
        }

        cost[mapSubsetToNumber(vertex)][1] = totalMinCost(vertex, 1);
        // printPath(vertex, 1);
        System.out.println("\n" + totalMinCost(vertex, 1));
        print(adjacencyMatrix);
        print(cost);
    }

    private void printAllSubsetOfSizeK(List<int[]> result, int k) {
        for (int i = 0; i < result.size(); i++) {
            int[] subset = result.get(i);
            for (int j = 0; j < subset.length; j++) {
                System.out.print(subset[j] + ",");
            }
            System.out.println();
        }
    }

    private void allSubsetOfSizeK(List<int[]> result, int[] vertex, int k, int start, int N, boolean[] used) {
        if (N == k) {
            int[] subset = new int[k];
            int counter = 0;
            for (int i = 0; i < vertex.length; i++) {
                if (used[i] == true) {
                    subset[counter++] = vertex[i];
                }
            }
            result.add(subset);
            return;
        }

        if (start == vertex.length) {
            return;
        }

        used[start] = true;
        allSubsetOfSizeK(result, vertex, k, start + 1, N + 1, used);
        used[start] = false;
        allSubsetOfSizeK(result, vertex, k, start + 1, N, used);
    }

    private int mapSubsetToNumber(int[] subset) {
        int sum = 0;
        for (int i = 0; i < subset.length; i++) {
            sum += Math.pow(2, subset[i] - 1);
        }
        return sum;
    }

    public void initializeAdjacencyMatrix(double[][] adjacencyMatrix) {
        this.adjacencyMatrix = new double[numberOfVertices + 1][numberOfVertices + 1];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                this.adjacencyMatrix[i + 1][j + 1] = adjacencyMatrix[i][j];
            }
        }
        for (int i = 0; i < numberOfVertices + 1; i++) {
            this.adjacencyMatrix[i][i] = 0;
        }
    }

    public void initializeCost() {
        int costRowSize = (int) Math.pow(2, numberOfVertices);
        cost = new double[costRowSize][numberOfVertices + 1];
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    private void initializeTSP(double[][] adjacencyMatrix) {
        setNumberOfVertices(adjacencyMatrix.length);
        initializeAdjacencyMatrix(adjacencyMatrix);
        initializeCost();
    }

    private double minCost(int[] subset, int j) {
        double result = MAX_DOUBLE;
        for (int k = 0; k < subset.length; k++) {
            int i = subset[k];
            if (i == j) {
                continue;
            }
            if (adjacencyMatrix[i][j] == 0) {
                continue;
            }
            double value = cost(subsetMinus(subset, j), i) + adjacencyMatrix[i][j];
            if (result > value) {
                result = value;
            }
        }
        return result;
    }

    private double totalMinCost(int[] subset, int j) {
        double result = MAX_DOUBLE;
        for (int k = 0; k < subset.length; k++) {
            int i = subset[k];
            if (i == j) {
                continue;
            }
            if (adjacencyMatrix[i][j] == 0) {
                continue;
            }
            double value = cost(subset, i) + adjacencyMatrix[i][j];
            if (result > value) {
                result = value;
            }
        }
        return result;
    }

    private void printPath(int[] subset, int j) {
        double result = MAX_DOUBLE;
        int vertex = 0;
        for (int k = 0; k < subset.length; k++) {
            int i = subset[k];
            if (i == j) {
                continue;
            }
            if (adjacencyMatrix[i][j] == 0) {
                continue;
            }

            double value = cost(subset, i) + adjacencyMatrix[i][j];

            if (result > value) {
                vertex = i;
            }
        }

        if (subset.length > 1) {
            if (j == 1) {
                System.out.print("1" + " --> ");
            }
            printPath(subsetMinus(subset, vertex), vertex);
            System.out.print(vertex + " --> ");
            if (j == 1) {
                System.out.print("1");
            }
        }
    }

    private int[] subsetMinus(int[] subset, int j) {
        int size = subset.length - 1;
        int[] result = new int[size];
        int index = 0;
        for (int i = 0; i < subset.length; i++) {
            if (subset[i] != j) {
                result[index++] = subset[i];
            }
        }
        return result;
    }

    private void print(double[][] matrix) {
        IMatrixManipulatorFactory manipulatorFactory = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactory.createMatrixManipulatorInstance();
        manipulator.print(matrix);
    }

    private double cost(int[] subset, int i) {
        if (subset.length == 1) {
            if (subset[0] == 1 && i == 1) {
                return 0;
            }
            return adjacencyMatrix[subset[0]][i];
        }
        return cost[mapSubsetToNumber(subset)][i];
    }
}
