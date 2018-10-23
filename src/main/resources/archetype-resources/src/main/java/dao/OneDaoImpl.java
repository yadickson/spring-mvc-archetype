#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import org.springframework.stereotype.Repository;

@Repository
public final class OneDaoImpl implements OneDao {

    static final long serialVersionUID = 1L;

    @Override
    public String toDo(final String text) {
        return "Full [" + text + "]";
    }
}
