package server;

import java.time.LocalDate;

/**
 * Server-side model. Holds the fixed list of matrices and picks one per UTC date.
 * Resides on the server only. Only MatrixServer communicates with it.
 */
public class MatrixOfTheDayModel {

    /** @post the list contains at least 7 matrices, all 3x3 with finite entries */
    public MatrixOfTheDayModel() {
        // TODO implement
    }

    /**
     * @pre date non-null (a UTC date)
     * @return a copy of the matrix at index (days since 1970-01-01) mod size();
     *         the same date always gives the same matrix
     */
    public double[][] getMatrixFor(LocalDate date) {
        // TODO replace with actual implementation
        return new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    }

    /** @return the number of matrices in the list (>= 7) */
    public int size() {
        // TODO replace with actual implementation
        return 0;
    }
}
