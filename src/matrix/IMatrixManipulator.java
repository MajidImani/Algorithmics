package matrix;

public interface IMatrixManipulator {
    public double[][] generateRandomMatrix(int numOfRows, int numOfCols, int bound);
    public void print(double[][] a);
    public double[][] add(double[][] first, double[][] second);
    public double[][] subtract(double[][] first, double[][] second);
    public double[][] multiply(double[][] first, double[][] second);
    
}
