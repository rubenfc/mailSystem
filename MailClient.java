/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    private MailServer server;
    private String user;
    
    
    public MailClient(MailServer newServer, String myUser)
    {
        server = newServer;
        user = myUser;
    }
    
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
   
    public void printNextMailItem()
    {
       MailItem item = server.getNextMailItem(user);
        if(item == null)
        {
            System.out.println("No new mail.");
        }
        else 
        {
            item.print();
        }
    }
    
    public void sendMailItem(String address, String message)
    {
        MailItem emailToSend = new MailItem(user, address, message);
        server.post(emailToSend);
    }
}