package kodlama.io.hrms.core.utilities.result;

public class SuccessDataResult<T> extends DataResult{
    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }
}
