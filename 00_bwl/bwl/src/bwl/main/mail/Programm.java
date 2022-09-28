package bwl.main.mail;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
public class Programm {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Email email = EmailBuilder
        .startingBlank()
        .from("Markus Leue", "markus@leues.de")
        .to("mom", "jean.baker@hotmail.com")
        .to("dad", "StevenOakly1963@hotmail.com")
        .withSubject("My Bakery is finally open!")
        .withPlainText("Mom, Dad. We did the opening ceremony of our bakery!!!")
        .buildEmail();

    MailerBuilder.withSMTPServer("smtp-ox.front.d0m.de", 465, "markus@leues.de", "Indien1234")
        .buildMailer().sendMail(email);
  }

}
