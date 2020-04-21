

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Utilidades {
    
    public static Boolean enviarCorreo(Mensaje m) {
        
        try{

            // Propiedades de la conexión
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");// puerto de salida, de
            // entrada 110
            props.setProperty("mail.smtp.user", "progwebufps@gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            //props.put("mail.transport.protocol.", "smtp");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            // Construimos el mensaje

            /**
             * Ojo aca reemplazar por consulta de la base deatos 
             * estan las direcciones en codigo duro.
             */
            // multiples direcciones
            String[] to = { m.getEmail(), "progwebufps@gmail.com" };
        
            
            // arreglo con las direcciones de correo
            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < addressTo.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }
            
            String mensajeHtml = "<i>Cordial saludo!</i><br>";
            mensajeHtml += "<b>De: </b>" + m.getName() +"<br>";
            mensajeHtml += "<b>Email: </b>" + m.getEmail() + "<br>";
            mensajeHtml += "<b>Sitio: </b> " + m.getWebsite() + "<br>";
            mensajeHtml += "<b>"+m.getMessage()+"</b><br>";
            
            // se compone el mensaje (Asunto, cuerpo del mensaje y direccion origen)
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("progwebufps@gmail.com"));
            message.setRecipients(Message.RecipientType.BCC, addressTo);
            message.setSubject("Mensaje de Contacto Programacion Web");
            message.setContent(mensajeHtml, "text/html; charset=utf-8");

            // Lo enviamos.
            Transport t  = session.getTransport("smtp");
            
            t.connect("progwebufps@gmail.com", "rlfqkcrbknkaoqge");

            try{
                t.sendMessage(message, message.getAllRecipients());
            }catch(MessagingException e){
                
                System.out.println(e.toString());
                System.out.println("Error ");
                return(false);
                
            }
            
            // Cierre de la conexion
            t.close();
            return(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return(false);
            
        }
        
    }

}
