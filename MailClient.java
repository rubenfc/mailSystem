/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // instance variables - replace the example below with your own
    private MailServer server;
    private String user;
    private String lastEmail;
    private int numberOfSend;
    private int numberOfSpam;
    private int numberOfRecive;
    private MailItem lastSpam;

    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }
 
    public MailItem getNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        String message = email.getMessage();
        String spam1 = "viagra";
        String spam2 = "oferta";
        Boolean found1;
        Boolean found2;
        found1 = message.contains(spam1);
        found2 = message.contains(spam2);
        if (found1 == true || found2 == true)
        {
            email = lastSpam;
            email = null;
        }
        else
        {
            lastEmail = email.getMessage();
        }
        return email;
    }
   
    public void printNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        String message = email.getMessage();
        String spam1 = "viagra";
        String spam2 = "oferta";
        String spam3 = "proyecto";
        Boolean found1;
        Boolean found2;
        Boolean found3;
        found1 = message.contains(spam1);
        found2 = message.contains(spam2);
        found3 = message.contains(spam3);
        if (email == null) {
            System.out.println("No hay mensajes.");
        }
        else if (found3 == true){
            email.print();
            lastEmail = email.getMessage();
            int countRecive = +1;
        }
        else if (found1 == true || found2 == true){
            System.out.println("Tu mensaje contenia un spam");
            int countRecive = +1;
            int countSpam = +1;
        }
        else {
            email.print();
            lastEmail = email.getMessage();
            int countRecive = +1;
        }
    }
   
    public void sendMailItem(String to, String subject, String message){
        MailItem emailToSend = new MailItem(user, to, subject, message);
        server.post(emailToSend);
        int countSend = +1;
    }
    
    public void howManyMailItems()
    {
        System.out.println("Tienes " + server.howManyMailItems(user) + " correos pendientes.");
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
              System.out.println("El ultimo mensaje es:" + lastEmail);
        }
    }
    
    public void stadistics()
    {
        System.out.println("Mensajes recividos: " + numberOfRecive);
        System.out.println("mensajes enviados: " + numberOfSend);
        long spamPor = numberOfRecive / numberOfSpam * 100;
        System.out.println("Mensajes recividos de spam: " + numberOfRecive + "%");
    }
    
    public void printLastSpam()
    {
        if(lastSpam ==null)
        {
            System.out.println("no hay spam");
        }
    
        else 
        {
            System.out.println("El ultimo spam es:" + lastSpam);
        }
    }
}