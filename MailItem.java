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
    
    public MailItem(String newFrom, String newTo, String newMessage)
    {
        from = newFrom;
        to = newTo;
        message = newMessage;
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
        System.out.println("message: " + message);
    }
}
