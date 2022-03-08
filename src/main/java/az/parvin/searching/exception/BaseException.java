package az.parvin.searching.exception;

public class BaseException extends RuntimeException{

    private String msg;
    private String code;
    private String description;

    public BaseException(String msg, String code, String description) {
        this.msg = msg;
        this.code = code;
        this.description = description;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
