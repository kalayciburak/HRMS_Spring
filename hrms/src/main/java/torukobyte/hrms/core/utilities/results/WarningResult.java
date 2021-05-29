package torukobyte.hrms.core.utilities.results;

public class WarningResult extends Result {
    public WarningResult() {
        super("warning");
    }

    public WarningResult(String message) {
        super(message);
    }
}
