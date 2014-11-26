/**
 * Write a description of class mailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    private String from;
    private String to;
    private String message;
    private String asunto;
    
    public MailItem(String newFrom, String newTo, String newMessage, String asunto)
    {
        this.from = from;
        this.to = to;
        this.message = message;
        this.asunto = asunto;
    }
    
    public String getFrom()
    {
        return from;
    }
    
    public String getTo()
    {
        return to;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void print()
    {
        System.out.println("from: " + from);
        System.out.println("to: " + to);
         System.out.println("asunto: " + asunto);
        System.out.println("message: " + message);
    }
}
