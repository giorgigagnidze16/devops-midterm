package ge.kiu.devops.model;

/**
 * Task DTO.
 */
public class Task {
  private String description;

  /**
   * Task Constructor.
   */
  public Task() {}

  /**
   * Task Constructor.
   */
  public Task(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
