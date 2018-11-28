package ${package}.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ${package}.config.ExceptionHandlerConfig;
import ${package}.constant.Constants;
import ${package}.domain.OneTO;
import ${package}.service.OneService;

@RunWith(MockitoJUnitRunner.class)
public class OneControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    OneControllerImpl oneController;

    @Mock
    OneService oneService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(oneController)
                .setControllerAdvice(new ExceptionHandlerConfig())
                //.setCustomArgumentResolvers(new ClassArgumentResolver())
                .build();
    }

    @Test
    public void testToDo() throws Exception {
        when(oneService.toDo(anyString())).thenReturn("output");
        String result = oneController.toDoText("text");
        assertEquals("output", result);
    }

    @Test
    public void testTest() throws Exception {
        String result = oneController.test();
        assertEquals("hello world", result);
    }

    @Test
    public void testJson() throws Exception {
        OneTO result = oneController.json();
        assertNotNull(result);
    }

    @Test
    public void testRestToDoError() throws Exception {
        
        when(oneService.toDo(anyString())).thenThrow(new RuntimeException("error"));
        
        mockMvc.perform(get("/one/toDo/texto"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(Constants.APPLICATION_JSON_VALUE));
    }

    @Test
    public void testRestToDo() throws Exception {
        
        when(oneService.toDo(anyString())).thenReturn("output");
        
        mockMvc.perform(get("/one/toDo/texto"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.TEXT_PLAIN_VALUE));
    }

    @Test
    public void testRestTest() throws Exception {

        mockMvc.perform(get("/one/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.TEXT_PLAIN_VALUE));
    }

    @Test
    public void testRestJson() throws Exception {

        mockMvc.perform(get("/one/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.APPLICATION_JSON_VALUE));
    }

}
