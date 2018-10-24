package ${package}.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import ${package}.domain.OneTO;
import ${package}.service.OneService;

@RunWith(MockitoJUnitRunner.class)
public class OneControllerTest {

    @InjectMocks
    OneController oneController;

    @Mock
    OneService oneService;

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

}
