package softwareProj;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

public class IDCardGenerate {

    public static void generateIDCard(String path, String name, String joinDate) throws IOException {
        PdfWriter writer = new PdfWriter(path);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Gym Membership ID Card"));
        document.add(new Paragraph("Name: " + name));
        document.add(new Paragraph("Join Date: " + joinDate));

    
        document.close();
    }
}
