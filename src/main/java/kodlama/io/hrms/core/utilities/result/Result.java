package kodlama.io.hrms.core.utilities.result;

import lombok.Data;


public class Result {
    private boolean success;
    private String message;
    public Result(boolean success,String message){
        this.message=message;
        this.success=success;
    }
    public Result(boolean success){
        this.success=success;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
