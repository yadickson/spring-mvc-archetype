#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ${package}.constant.Constants;
import ${package}.domain.OneTO;
import ${package}.service.OneService;

@RestController
@RequestMapping(value = "/one")
public final class OneController {

    @Autowired
    private OneService oneService;

    @RequestMapping(value = "/toDo/{text}",
            method = RequestMethod.GET,
            produces = Constants.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String toDoText(@PathVariable String text) {
        return oneService.toDo(text);
    }

    @RequestMapping(value = "/test",
            method = RequestMethod.GET,
            produces = Constants.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String test() {
        return "hello world";
    }

    @RequestMapping(value = "/json",
            method = RequestMethod.GET,
            produces = Constants.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OneTO json() {
        OneTO to = new OneTO();
        to.setNumber(10);
        to.setText("text");
        return to;
    }

}

