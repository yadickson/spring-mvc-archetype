#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.dao.OneDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class OneServiceImpl implements OneService {

    static final long serialVersionUID = 1L;

    @Autowired
    private OneDao oneDao;

    public String toDo(final String text) {
        return oneDao.toDo(text);
    }
}
