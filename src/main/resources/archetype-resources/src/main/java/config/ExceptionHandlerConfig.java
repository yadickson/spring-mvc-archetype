#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import ${package}.constant.Constants;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleGlobalRuntimeExceptionRequest(
            final HttpServletRequest req,
            final RuntimeException ex
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(Constants.APPLICATION_JSON);
        ErrorInfo info = new ErrorInfo(req.getRequestURL().toString(), "Runtime", ex, stackTraceToString(ex));
        return new ResponseEntity<String>(info.toString(), headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleGlobalExceptionRequest(
            final HttpServletRequest req,
            final Exception ex
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(Constants.APPLICATION_JSON);
        ErrorInfo info = new ErrorInfo(req.getRequestURL().toString(), "Generic", ex, stackTraceToString(ex));
        return new ResponseEntity<String>(info.toString(), headers, HttpStatus.BAD_REQUEST);
    }

    /**
     * Getter de stacktrace string
     *
     * @param ex Exception
     * @return stacktrace
     */
    private String stackTraceToString(final Throwable ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

}

