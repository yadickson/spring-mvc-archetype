#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneTO {
    
    private String text;
    private Integer number;
    
}
