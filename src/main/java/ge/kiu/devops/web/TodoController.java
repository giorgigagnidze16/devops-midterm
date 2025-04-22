package ge.kiu.devops.web;

import ge.kiu.devops.model.Task;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Todo controller.
 */
@Controller
public class TodoController {
  private final List<Task> tasks = new ArrayList<>();

  /**
   * Returns tasks page.
   *
   * @param model of form
   * @return html tasks page
   */
  @GetMapping("/tasks")
  public String getTasks(Model model) {
    model.addAttribute("tasks", tasks);
    model.addAttribute("newTask", new Task());
    return "tasks";
  }

  /**
   * Adds task to tasks list.
   *
   * @param task taken from form
   * @return html tasks page
   */
  @PostMapping("/tasks")
  public String addTask(@ModelAttribute Task task) {
    tasks.add(task);
    return "redirect:/tasks";
  }
}
