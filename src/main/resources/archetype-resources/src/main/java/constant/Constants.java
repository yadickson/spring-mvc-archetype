#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constant;

import org.springframework.http.MediaType;

public final class Constants {

    public static final String CHARSET = "; charset=UTF-8";

    public static final String APPLICATION_JSON_VALUE = MediaType.APPLICATION_JSON_VALUE + CHARSET;

    public static final String TEXT_PLAIN_VALUE = MediaType.TEXT_PLAIN_VALUE + CHARSET;

    public static final String TEXT_HTML_VALUE = MediaType.TEXT_HTML_VALUE + CHARSET;

    public static final String TEXT_XML_VALUE = MediaType.TEXT_XML_VALUE + CHARSET;

    public static final MediaType APPLICATION_JSON = MediaType.parseMediaType(APPLICATION_JSON_VALUE);

    public static final MediaType TEXT_PLAIN = MediaType.parseMediaType(TEXT_PLAIN_VALUE);

    public static final MediaType TEXT_HTML = MediaType.parseMediaType(TEXT_HTML_VALUE);

    public static final MediaType TEXT_XML = MediaType.parseMediaType(TEXT_XML_VALUE);
}
