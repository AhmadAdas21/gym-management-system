package softwareProj;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class IDCardGenerateTest {
    private static final String TEST_FILE_PATH = "test_IDCard.pdf";

    @After
    public void cleanUp() {
     
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testGenerateIDCard() {
        String name = "Jane Doe";
        String joinDate = "2025-01-04";

        try {
         
            IDCardGenerate.generateIDCard(TEST_FILE_PATH, name, joinDate);

           
            File file = new File(TEST_FILE_PATH);
            assertTrue("The ID card PDF file was not created.", file.exists());

         
            assertTrue("The ID card PDF file is empty.", file.length() > 0);

        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}
