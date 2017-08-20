package in.zipgo.automation_framework.base;

public interface ToolsFactory<T> {

    public void initialize();

    public T getInstance();

    public void close();
}
