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
    private MailItem lastEmail;
    
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }
    
    public MailItem getNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        lastEmail = item;
        return server.getNextMailItem(user);
    }
   
    public void printNextMailItem()
    {
       MailItem item = server.getNextMailItem(user);
       lastEmail = item;
        if(item == null)
        {
            System.out.println("No new mail.");
        }
        else 
        {
            item.print();
            
        }
    }
    
    public void sendMailItem(String address, String message, String asunto)
    {
        MailItem emailToSend = new MailItem(user, address, message, asunto);
        server.post(emailToSend);
    }
    
    public void sloopMail()
    {
        int numberOfMails = server.howManyMailItems(user);
        System.out.println("numero de emails en el servidor" + numberOfMails);
    }
    
    public void getNextMailItemAndAutorespond()
    {
        MailItem email = server.getNextMailItem(user);
        if(email != null)
        {
            String newTo = email.getFrom();
            String newMessage = "estoy de vacaciones .\n" + email.getMessage();
            String newAsunto = "R.E";
            MailItem autorespond = new MailItem(user, newTo, newAsunto, newMessage);
            server.post(autorespond);
        }
    }
    
    public void printLastEmail()
    {
        if(lastEmail == null)
        {
            System.out.println("no hay mensajes nuevos");
        }
        else 
        {
             
            lastEmail.print();
        }
    }
}