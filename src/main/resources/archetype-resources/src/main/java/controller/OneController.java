#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.service.OneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public final class OneController {

    @Autowired
    private OneService oneService;

    @RequestMapping(value = "/toDo/{text}", method = RequestMethod.GET)
    public String toDoText(@PathVariable String text) {
        return oneService.toDo(text);
    }

}
