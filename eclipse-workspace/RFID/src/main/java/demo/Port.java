package demo;

public interface Port {
  public void open();

  public String read() throws ReadError;

  public void close();
}
