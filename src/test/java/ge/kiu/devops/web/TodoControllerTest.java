package ge.kiu.devops.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Controller tests.
 */
@WebMvcTest(TodoController.class)
public class TodoControllerTest {
  /**
   * Add javadoc.
   */
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetTasksRoute() throws Exception {
    mockMvc.perform(get("/tasks"))
        .andExpect(status().isOk())
        .andExpect(view().name("tasks"));
  }
}
