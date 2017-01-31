
package util;

import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {


    
    public void EnviaMensage (String emailUser,String nome,String URL){
        try{
        // cria o anexo. 
        EmailAttachment attachment = new EmailAttachment(); 
        attachment.setURL(new URL(URL));
        //caminho da imagem 
        attachment.setDisposition(EmailAttachment.ATTACHMENT);  
        attachment.setDescription("Picture of John"); 
        attachment.setName("John");
        
     
        
        
       
             MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setFrom("sgmprtcc2014@gmail.com", "TCC SGMPR");
        email.addTo(emailUser,nome);
        email.setSubject("Promoções do Mês");
        email.setMsg("Promoção imperdível");
        email.setSSL(true);
        email.setAuthentication("sgmprtcc2014@gmail.com","13d8xhh96");
        email.attach(attachment);
        email.send();
        JOptionPane.showMessageDialog(null, "Email enviado com sucesso");
        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    
    
}
