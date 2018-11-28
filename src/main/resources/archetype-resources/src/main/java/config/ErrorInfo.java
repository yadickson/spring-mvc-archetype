#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import lombok.Getter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public final class ErrorInfo {

    private final String url;
    private final String code;
    private final String messaje;
    private final String stackTrace;

    public ErrorInfo(
            final String url,
            final String code,
            final Throwable ex,
            final String stackTrace) {
        this.url = url;
        this.code = code;
        this.messaje = ex.getMessage();
        this.stackTrace = stackTrace;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
