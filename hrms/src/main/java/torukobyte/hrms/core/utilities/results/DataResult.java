package torukobyte.hrms.core.utilities.results;

public class DataResult<T> extends Result {
    private final T data;

    public DataResult(T data, String success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data, String success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
