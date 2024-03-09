package kodlama.io.hrms.core.utilities.result;

public class ErrorDataResult extends DataResult{
    public ErrorDataResult(Object data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(Object data) {
        super(data, false);
    }
}
