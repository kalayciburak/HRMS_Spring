package torukobyte.hrms.core.utilities.results;

public class Result {

    private final String type;
    private String message;

    public Result(String type) {
        this.type = type;
    }

    public Result(
            String type,
            String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}