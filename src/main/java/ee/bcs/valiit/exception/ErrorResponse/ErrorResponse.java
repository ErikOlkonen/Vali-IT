package ee.bcs.valiit.exception.ErrorResponse;

public class ErrorResponse {
    public String getMessage() {
        return message;
    }
    // miks seda getMessage ei kasutata ja kuidas seda kasutada?

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
