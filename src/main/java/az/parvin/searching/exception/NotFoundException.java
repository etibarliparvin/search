package az.parvin.searching.exception;

public class NotFoundException extends BaseException {

    public NotFoundException(BusinessExceptionEnum exception) {
        super(exception.getMsg(), exception.getCode(), exception.getDescription());
    }

    public NotFoundException(BusinessExceptionEnum exception, Object object) {
        super(String.format(exception.getMsg(), object), exception.getCode(), exception.getDescription());
    }
}
