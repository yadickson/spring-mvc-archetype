#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.io.Serializable;

public interface OneDao extends Serializable {

    String toDo(final String text);

}
