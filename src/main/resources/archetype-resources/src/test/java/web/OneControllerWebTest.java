#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ${package}.constant.Constants;
import ${package}.controller.OneController;
import ${package}.service.OneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,
        classes = {
            MockControllerConfig.class
        })
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
@WebAppConfiguration
public class OneControllerWebTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    @InjectMocks
    OneController oneController;

    @Mock
    OneService oneService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testToDo() throws Exception {
        when(oneService.toDo(anyString())).thenReturn("output");
        mockMvc.perform(get("/one/toDo/texto"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.TEXT_PLAIN_VALUE));
    }

    @Test
    public void testTest() throws Exception {

        mockMvc.perform(get("/one/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.TEXT_PLAIN_VALUE));
    }

    @Test
    public void testJson() throws Exception {

        mockMvc.perform(get("/one/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.APPLICATION_JSON_VALUE));
    }

}

