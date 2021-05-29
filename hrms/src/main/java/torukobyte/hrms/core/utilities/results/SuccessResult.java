package torukobyte.hrms.core.utilities.results;

public class SuccessResult extends Result {
    public SuccessResult() {
        super("success");
    }

    public SuccessResult(String message) {
        super("success", message);
    }
}