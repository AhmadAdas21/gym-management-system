package softwareProj;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class PdfGenerateTest {

    private PdfGenerate pdfGenerate;
    private String testFileName;
    private String testDir;

    @Before
    public void setUp() {
        testFileName = "testReport.pdf";
        testDir = System.getProperty("user.dir") + File.separator + "GeneratedReports";
        pdfGenerate = new PdfGenerate(testFileName);
    }

    @Test
    public void testGeneratePdf_createsDirectoryAndPdfFile() {
        File file = new File(testDir + File.separator + testFileName);
        pdfGenerate.addText("This is a test PDF report.");
        pdfGenerate.generatePdf();

        assertTrue(new File(testDir).exists());
        assertTrue(file.exists());
    }

    @Test
    public void testAddText_addsContentToPdf() {
        pdfGenerate.addText("Test content 1");
        pdfGenerate.addText("Test content 2");

        assertEquals(2, pdfGenerate.getContent().size());
        assertTrue(pdfGenerate.getContent().contains("Test content 1"));
        assertTrue(pdfGenerate.getContent().contains("Test content 2"));
    }

    @Test
    public void testGeneratePdf_handlesIOException() {
        pdfGenerate = new PdfGenerate("invalid/testReport.pdf");
        try {
            pdfGenerate.addText("This content should not be added due to invalid path.");
            pdfGenerate.generatePdf();
        } catch (Exception e) {
            assertTrue(e instanceof java.io.IOException);
        }
    }
}
