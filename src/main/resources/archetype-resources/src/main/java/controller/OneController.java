#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${package}.constant.Constants;
import ${package}.domain.OneTO;
import ${package}.service.OneService;

@RequestMapping(value = "/one")
public interface OneController {

    @RequestMapping(value = "/toDo/{text}",
            method = RequestMethod.GET,
            produces = Constants.TEXT_PLAIN_VALUE)
    @ResponseBody
    String toDoText(@PathVariable(name = "text") final String text);

    @RequestMapping(value = "/test",
            method = RequestMethod.GET,
            produces = Constants.TEXT_PLAIN_VALUE)
    @ResponseBody
    String test();

    @RequestMapping(value = "/json",
            method = RequestMethod.GET,
            produces = Constants.APPLICATION_JSON_VALUE)
    @ResponseBody
    OneTO json();

}
