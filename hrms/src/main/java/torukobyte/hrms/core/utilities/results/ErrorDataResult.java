package torukobyte.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data, String message) {
        super(data, "error", message);
    }

    public ErrorDataResult(T data) {
        super(data, "error");
    }

    public ErrorDataResult(String message) {
        super(null, "error", message);
    }

    public ErrorDataResult() {
        super(null, "error");
    }
}
