package torukobyte.hrms.core.utilities.results;

public class WarningDataResult<T> extends DataResult<T> {
    public WarningDataResult(T data, String message) {
        super(data, "warning", message);
    }

    public WarningDataResult(T data) {
        super(data, "warning");
    }

    public WarningDataResult(String message) {
        super(null, "warning", message);
    }

    public WarningDataResult() {
        super(null, "warning");
    }
}
