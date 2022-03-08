package az.parvin.searching.exception;

public class DateTimeFormatException extends BaseException{

    public DateTimeFormatException(BusinessExceptionEnum exception) {
        super(exception.getMsg(), exception.getCode(), exception.getDescription());
    }
}
