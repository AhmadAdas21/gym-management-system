package softwareProj;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfGenerate {

    private String path;
    private List<String> content;

    public PdfGenerate(String fileName) {
        String projectDir = System.getProperty("user.dir");
        this.path = projectDir + File.separator + "GeneratedReports" + File.separator + fileName;
        this.content = new ArrayList<>();
    }

    public void addText(String text) {
        content.add(text);
    }

    public void generatePdf() {
        File pdfFile = new File(path);
        pdfFile.getParentFile().mkdirs();

        try {
            PdfWriter writer = new PdfWriter(pdfFile);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            for (String text : content) {
                document.add(new Paragraph(text));
            }

            document.close();
            System.out.println("PDF report generated successfully at: " + path);
        } catch (IOException e) {
            System.err.println("An error occurred while generating the PDF: " + e.getMessage());
            e.printStackTrace();
        }

        if (pdfFile.exists()) {
            System.out.println("File found at: " + pdfFile.getAbsolutePath());
        } else {
            System.err.println("File not found. Please check the path and permissions.");
        }
    }

    public List<String> getContent() {
        return content;
    }

   
}
