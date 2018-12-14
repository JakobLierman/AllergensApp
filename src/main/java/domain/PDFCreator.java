package domain;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

/**
 * The type Pdf creator.
 */
public class PDFCreator {

    private PDDocument document;

    /**
     * Instantiates a new Pdf creator.
     */
    PDFCreator() {
    }

    /**
     * Create a pdf document.
     *
     * @param documentName the document name
     * @param companyName  the company name
     */
    protected void create(String documentName, String companyName) {
        document = new PDDocument();
        PDDocumentInformation information = document.getDocumentInformation();
        information.setAuthor(companyName);
        information.setCreator("AllyDesktop");
        information.setTitle(documentName);
    }

    /**
     * Add page to the document.
     *
     * @param lines the lines
     * @throws IOException the io exception
     */
    private void addPage(String[] lines) throws IOException {
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Font settings
        PDFont font = PDType0Font.load(document, new File("/Roboto/Roboto-Regular.ttf"));
        float fontSize = 12;
        float leading = 1.5f * fontSize;

        // Margin settings
        final float margin = 72;
        final float width = page.getMediaBox().getWidth() - 2 * margin;
        final float startX = page.getMediaBox().getLowerLeftX() + margin;
        final float startY = page.getMediaBox().getUpperRightY() - margin;

        // Import text
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(startX, startY);
        for (String line : lines) {
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, -leading);
        }
        contentStream.endText();
        contentStream.close();
    }

    /**
     * Save the PDF file.
     *
     * @param directory the directory
     * @param fileName  the file name
     * @throws IOException the io exception
     */
    protected void save(String directory, String fileName) throws IOException {
        String filePath = directory + "/" + fileName + ".pdf";
        document.save(filePath);
        document.close();
    }
}
