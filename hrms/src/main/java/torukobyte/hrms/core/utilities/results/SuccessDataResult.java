package torukobyte.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, "success", message);
    }

    public SuccessDataResult(T data) {
        super(data, "success");
    }

    public SuccessDataResult(String message) {
        super(null, "success", message);
    }

    public SuccessDataResult() {
        super(null, "success");
    }
}
