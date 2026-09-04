package softwareProj;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IDCardSent {

    public void generateAndSendCard(String name, String recipientEmail) {
        String joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String idCardPath = createIDCard(name, joinDate);
        sendEmailWithAttachment("Welcome to Our Gym!", 
            "Dear " + name + ",\n\nWelcome to our gym! Your membership started on " + joinDate + ".\n\nKeep pushing your limits!", 
            recipientEmail, 
            idCardPath, 
            name + "_IDCard.png");
    }

    private String createIDCard(String name, String joinDate) {
        String outputPath = System.getProperty("user.dir") + "/GeneratedRe/" + name + "_IDCard.png";

        File directory = new File(System.getProperty("user.dir") + "/GeneratedRe/");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        BufferedImage idCardImage = new BufferedImage(400, 250, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = idCardImage.createGraphics();

        Color color1 = new Color(255, 223, 92);
        Color color2 = new Color(255, 255, 255);
        GradientPaint gradient = new GradientPaint(0, 0, color1, 0, 250, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 400, 250);

        g2d.setColor(new Color(0, 0, 0));
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRoundRect(10, 10, 380, 230, 20, 20);

        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawString("Welcome to the Gym!", 100, 40);

        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.setColor(Color.BLACK);
        g2d.drawString(name, 100, 90);

        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        g2d.setColor(Color.BLACK);
        g2d.drawString("Membership Start Date: " + joinDate, 100, 120);

        g2d.setFont(new Font("Arial", Font.ITALIC, 14));
        g2d.setColor(Color.BLACK);
        g2d.drawString("Keep pushing your limits!", 100, 180);

        g2d.dispose();

        try {
            ImageIO.write(idCardImage, "png", new File(outputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputPath;
    }

    private void sendEmailWithAttachment(String subject, String message, String recipientEmail, String attachmentFilePath, String attachmentName) {
        Email_Test emailTest = new Email_Test();
        emailTest.sendEmailWithAttachment(subject, message, recipientEmail, attachmentFilePath, attachmentName);
    }

    public static void main(String[] args) {
        IDCardSent idCardSent = new IDCardSent();
        idCardSent.generateAndSendCard("Ahmed Ali", "iyasabusaeed9@gmail.com");
    }
}
