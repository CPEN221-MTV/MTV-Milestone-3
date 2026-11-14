package app.net;

import app.math.Matrix;

/**
 * Client-side network component. Asks the server for today's Matrix of the Day.
 * Resides on the client only. Talks only to MatrixServer (over HTTP) and to its
 * caller (MatrixInputPanel).
 */
public class MatrixOfTheDayClient {

    /** The server's answer: the UTC date and that day's matrix. */
    public static class DailyMatrix {
        /** Date in the form YYYY-MM-DD (UTC). */
        public final String date;
        public final Matrix matrix;

        public DailyMatrix(String date, Matrix matrix) {
            this.date = date;
            this.matrix = matrix;
        }
    }

    /** Result handler. Both methods are called on the Swing event thread. */
    public interface Callback {
        /** @pre result non-null and well formed (3x3 finite numbers, valid date) */
        void onSuccess(DailyMatrix result);

        /**
         * @pre reason non-null; called on timeout, non-200 status, or malformed body
         */
        void onFailure(String reason);
    }

    /** @pre baseUrl non-null, e.g. "http://localhost:8080" */
    public MatrixOfTheDayClient(String baseUrl) {
        // TODO implement
    }

    /**
     * Sends one HTTP GET to baseUrl + "/api/matrix-of-the-day" without blocking the
     * calling thread.
     * 
     * @post exactly one of callback.onSuccess / callback.onFailure is eventually
     *       called
     * @post onFailure is called if no response arrives within 5 seconds, the status
     *       is not 200, or the body is not the expected JSON
     */
    public void fetchAsync(Callback callback) {
        // TODO implement
    }
}
