package ge.kiu.devops.model;

/**
 * Task DTO.
 */
public class Task {
  /**
   * description.
   */
  private String description;

  /**
   * Task Constructor.
   */
  public Task() {}

  /**
   * @param description Task Constructor.
   */
  public Task(String description) {
    System.out.println("Gamarjoba");
    this.description = description;
  }

  /**
   * Gets description.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
