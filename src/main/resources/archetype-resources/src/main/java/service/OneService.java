#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import java.io.Serializable;

public interface OneService extends Serializable {

    String toDo(final String text);

}
