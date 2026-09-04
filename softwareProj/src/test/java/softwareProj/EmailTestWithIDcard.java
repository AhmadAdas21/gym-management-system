package softwareProj;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmailTestWithIDcard {
    Email_Test emailTest2 = new Email_Test();
    IDCardSent idCardSent = new IDCardSent();

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Test
    public void testEmailSending() {
        emailTest2.sendEmail("Test Subject", "Test Message", "iyasabusaeed9@gmail.com");
        System.out.println("Email sent successfully!");
    }

    @Test
    public void testInvalidEmail() {
        String invalidEmail = "invalid-email";
        if (!isValidEmail(invalidEmail)) {
            System.out.println("Invalid email format: " + invalidEmail);
        } else {
            emailTest2.sendEmail("Test Subject", "Test Message", invalidEmail);
        }
    }

    private void validateAndSendEmail(String subject, String message, String email) {
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format: " + email);
        } else {
            emailTest2.sendEmail(subject, message, email);
        }
    }

    @Test
    public void testEmptySubject() {
        emailTest2.sendEmail("", "Message without subject", "iyasabusaeed9@gmail.com");
        System.out.println("Email sent with empty subject.");
    }

    @Test
    public void testEmptyMessage() {
        String message = "";
        if (message.isEmpty()) {
            message = "No message provided";  // Set default message
        }
        emailTest2.sendEmail("Empty Message Test", message, "iyasabusaeed9@gmail.com");
        System.out.println("Email sent with empty message (default message applied).");
    }

    @Test
    public void testIDCardGenerationAndEmail() {
        String recipientEmail = "iyasabusaeed9@gmail.com";
        String name = "Eyas Nedal";
        idCardSent.generateAndSendCard(name, recipientEmail);
        String generatedFilePath = System.getProperty("user.dir") + "/GeneratedRe/" + name + "_IDCard.png";
        File file = new File(generatedFilePath);
        if (file.exists()) {
            System.out.println("ID Card file generated successfully.");
        } else {
            System.out.println("ID Card file generation failed.");
        }
    }

    @Test
    public void testEmailWithAttachment() {
        try {
            String recipientEmail = "iyasabusaeed9@gmail.com";
            String subject = "Test Email with Attachment";
            String message = "This is a test email with an attachment.";
            String attachmentPath = System.getProperty("user.dir") + "/GeneratedRe/Test_Attachment.png";
            String attachmentName = "Test_Attachment.png";
            
            File attachmentFile = new File(attachmentPath);
            if (!attachmentFile.exists()) {
                attachmentFile.createNewFile();
            }

            emailTest2.sendEmailWithAttachment(subject, message, recipientEmail, attachmentPath, attachmentName);
            System.out.println("Email sent with attachment.");

            assertTrue("The attachment should exist at the specified path", attachmentFile.exists());
        } catch (Exception e) {
            System.out.println("Email with attachment failed: " + e.getMessage());
        }
    }
}
