package be.kdg.gedistribueerde.client;

/**
 * Created by xaviergeerinck on 19/11/13.
 */
public interface ChatClient {
    public String getName();

    public void send(String message);

    public void receive(String message);

    public void setTextReceiver(TextReceiver textReceiver);

    public void unregister();
}
