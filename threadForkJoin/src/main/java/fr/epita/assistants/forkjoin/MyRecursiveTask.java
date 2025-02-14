package fr.epita.assistants.forkjoin;

import javax.xml.transform.Result;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {
    private final double[][] matrix;
    private final int xLowerBound;
    private final int xUpperBound;
    private final int yLowerBound;
    private final int yUpperBound;

    // Constructor to initialize the matrix and bounds
    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound,
                           int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }
    public static class Result{
        double sum;
        int count;
        Result(double sum, int count){
            this.sum=sum;
            this.count=count;
        }
    }

    // Override the compute method to perform the work
    @Override
    protected Double compute() {
        // Check if the current sub-matrix is small enough to compute the average directly
        int rows = yUpperBound - yLowerBound;
        int cols = xUpperBound - xLowerBound;

        if(rows <=0 || cols <=0){
            return 0.0;
        }

        // If the sub-matrix is small enough (<= 5x5), compute the average directly
        if (rows <= 5 && cols <= 5) {
            double sum = 0;
            int count = 0;
            for (int y = yLowerBound; y < yUpperBound; y++) {
                for (int x = xLowerBound; x < xUpperBound; x++) {
                    sum += matrix[y][x];
                    count++;
                }
            }
            return count==0 ? 0.0 : sum/count;
        }

        // Otherwise, split the matrix into 4 sub-matrices and fork new tasks
        int midX = (xLowerBound + xUpperBound) / 2;
        int midY = (yLowerBound + yUpperBound) / 2;

        // Create 4 new tasks for the 4 sub-matrices
        MyRecursiveTask topLeft = new MyRecursiveTask(matrix, xLowerBound, midX, yLowerBound, midY);
        MyRecursiveTask topRight = new MyRecursiveTask(matrix, midX, xUpperBound, yLowerBound, midY);
        MyRecursiveTask bottomLeft = new MyRecursiveTask(matrix, xLowerBound, midX, midY, yUpperBound);
        MyRecursiveTask bottomRight = new MyRecursiveTask(matrix, midX, xUpperBound, midY, yUpperBound);

        // Fork the tasks asynchronously
        topLeft.fork();
        topRight.fork();
        bottomLeft.fork();
        bottomRight.fork();

        // Wait for results from all tasks and combine them
        Double resultTopLeft = topLeft.join();
        Double resultTopRight = topRight.join();
        Double resultBottomLeft = bottomLeft.join();
        Double resultBottomRight = bottomRight.join();

        return (resultTopLeft+resultTopRight+resultBottomLeft+resultBottomRight)/4;


        // Return the average of all the sub-matrices
    }
    public static double getAverage(double [][]  matrix){
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return 0.0;

        }
        MyRecursiveTask mrt = new MyRecursiveTask(matrix,0,matrix[0]
                .length,0, matrix.length);
        return mrt.fork().join();
    }
}
