package resources;

public class ResourceServerController implements ResourceServerControllerMBean {
    private final TestResource testResource;
    public ResourceServerController(TestResource testResource) {this.testResource = testResource;}

    public String getname() {
        return testResource.getName();
    }

    public int getage() {
        return testResource.getAge();
    }
}
