package ${package}.service;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import ${package}.dao.OneDao;

@RunWith(MockitoJUnitRunner.class)
public class OneServiceTest {

    @InjectMocks
    OneServiceImpl oneService;

    @Mock
    OneDao oneDao;
    
    @Test
    public void testToDo() {
        when(oneDao.toDo(anyString())).thenReturn("output");
        String result = oneService.toDo("input");
        assertEquals("output", result);
    }
}
