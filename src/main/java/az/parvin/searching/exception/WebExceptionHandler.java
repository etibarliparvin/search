package az.parvin.searching.exception;

import az.parvin.searching.exception.common.CommonMessage;
import az.parvin.searching.exception.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(BaseException.class)
    private ResponseEntity<?> handle(BaseException e, WebRequest request) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus("Error");
        CommonMessage message = new CommonMessage();
        message.setMessage(e.getMsg());
        message.setCode(e.getCode());
        message.setDescription(e.getDescription());

        commonResponse.setErrorMessage(message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(commonResponse);
    }
}
