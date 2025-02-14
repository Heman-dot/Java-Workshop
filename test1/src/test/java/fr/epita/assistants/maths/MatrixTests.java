package fr.epita.assistants.maths;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MatrixTests {

    @Test
    void testMatrixConstructor_ValidInput() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);
        assertNotNull(matrix, "Matrix should be initialized");
    }

    @Test
    void testMatrixConstructor_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> new Matrix(null), "Constructor should throw exception for null input");
    }

    @Test
    void testMatrixConstructor_EmptyMatrix() {
        int[][] empty = {};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(empty), "Constructor should handle empty matrices");
    }

    @Test
    void testMatrixConstructor_InconsistentRowLengths() {
        int[][] invalid = {{1, 2}, {3}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(invalid), "Constructor should handle inconsistent row lengths");
    }

    @Test
    void testMatrixEquality_SameMatrix() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data);
        Matrix matrix2 = new Matrix(data);
        assertTrue(matrix1.equals(matrix2), "Matrices with same values should be equal");
    }

    @Test
    void testMatrixEquality_DifferentMatrices() {
        int[][] data1 = {{1, 2}, {3, 4}};
        int[][] data2 = {{5, 6}, {7, 8}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        assertFalse(matrix1.equals(matrix2), "Different matrices should not be equal");
    }

    @Test
    void testMatrixMultiplication_ValidCase() {
        int[][] data1 = {{1, 2}, {3, 4}};
        int[][] data2 = {{2, 0}, {1, 2}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.multiply(matrix2);

        int[][] expected = {{4, 4}, {10, 8}};
        assertArrayEquals(expected, result.getMatrix(), "Multiplication result should match expected");
    }

    @Test
    void testMatrixMultiplication_InvalidDimensions() {
        int[][] data1 = {{1, 2}};
        int[][] data2 = {{2, 0}, {1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix2), "Multiplication should fail for invalid dimensions");



    }
    @Test
    void testmatrixisEquality_WithNonMatrixObject(){
        int [][] data={{1,2},{3,4}};
        Matrix matrix = new Matrix(data);
        String notAMatrix= "This ia a string not a matrix";

        assertThrows(ClassCastException.class, () -> matrix.equals(notAMatrix),"matrix.equals should not allow to comparision with non matrix object");
    }
}