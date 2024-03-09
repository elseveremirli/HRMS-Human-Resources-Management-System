package kodlama.io.hrms.core.utilities.result;

public class SuccessDataResult extends DataResult{
    public SuccessDataResult(Object data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(Object data) {
        super(data, true);
    }
}
