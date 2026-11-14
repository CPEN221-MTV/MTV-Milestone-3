package server;

/**
 * Server-side controller. Listens for HTTP requests and answers them using
 * MatrixOfTheDayModel. Resides on the server only. Talks to clients
 * (MatrixOfTheDayClient) over HTTP and to MatrixOfTheDayModel.
 */
public class MatrixServer {

    /** @pre model non-null */
    public MatrixServer(MatrixOfTheDayModel model) {
        // TODO implement
    }

    /** @post the server is accepting HTTP connections on TCP port 8080 */
    public void start() {
        // TODO implement
    }

    /**
     * Handles one request.
     * @post GET /api/matrix-of-the-day: status 200, body
     *       {"date":"YYYY-MM-DD","matrix":[[a,b,c],[d,e,f],[g,h,i]]} using the
     *       current UTC date and model.getMatrixFor(thatDate)
     * @post any other path: status 404
     * @post any non-GET method on that path: status 405
     */
    void handleRequest(String method, String path) {
        // TODO implement
    }

    /** @post creates a MatrixOfTheDayModel and starts a MatrixServer */
    public static void main(String[] args) {
        // TODO implement
    }
}
