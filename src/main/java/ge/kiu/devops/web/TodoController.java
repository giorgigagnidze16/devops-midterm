package ge.kiu.devops.web;

import java.util.ArrayList;
import java.util.List;

import ge.kiu.devops.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

  private final List<Task> tasks = new ArrayList<>();

  @GetMapping("/tasks")
  public String getTasks(Model model) {
    model.addAttribute("tasks", tasks);
    model.addAttribute("newTask", new Task());
    return "tasks";
  }

  @PostMapping("/tasks")
  public String addTask(@ModelAttribute Task task) {
    tasks.add(task);
    return "redirect:/tasks";
  }
}
