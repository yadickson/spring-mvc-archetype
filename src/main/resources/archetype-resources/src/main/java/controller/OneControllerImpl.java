#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ${package}.constant.Constants;
import ${package}.domain.OneTO;
import ${package}.service.OneService;

@RestController
public final class OneControllerImpl implements OneController {

    @Autowired
    private OneService oneService;

    @Override
    public String toDoText(final String text) {
        return oneService.toDo(text);
    }

    @Override
    public String test() {
        return "hello world";
    }

    @Override
    public OneTO json() {
        OneTO to = new OneTO();
        to.setNumber(10);
        to.setText("text");
        return to;
    }

}
