package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FilesParsingTest {

    @Test
    @DisplayName("PDF: Тест проверки чтения и содержимого PDF файла из архива")
    void pdfFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/my archive.zip"))) {
            ZipEntry entry = zip.getEntry("My pdf.pdf");
            InputStream inputStream = zip.getInputStream(entry);
            {
                PDF pdf = new PDF(inputStream);
                Assertions.assertEquals("Новый документ", pdf.title);
            }
        }
    }

    @Test
    @DisplayName("CSV: Тест проверки чтения и содержимого CSV файла из архива")
    void csvFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/my archive.zip"))) {
            ZipEntry entry = zip.getEntry("Birthdays.csv");
            InputStream inputStream = zip.getInputStream(entry);
            Reader reader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> content = csvReader.readAll();

            Assertions.assertEquals(5, content.size());

            final String[] firstRow = content.get(0);
            final String[] secondRow = content.get(1);
            final String[] thirdRow = content.get(2);
            final String[] forthRow = content.get(3);
            final String[] fifthRow = content.get(4);

            Assertions.assertArrayEquals(new String[]{"Друзья", "День рождения"}, firstRow);
            Assertions.assertArrayEquals(new String[]{"Вася", "11.01.1983"}, secondRow);
            Assertions.assertArrayEquals(new String[]{"Таня", "25.09.1989"}, thirdRow);
            Assertions.assertArrayEquals(new String[]{"Ваня", "30.07.1981"}, forthRow);
            Assertions.assertArrayEquals(new String[]{"Оксана", "07.04.1985"}, fifthRow);
        }
    }

    @Test
    @DisplayName("XLS: Тест проверки чтения и содержимого XLS файла из архива")
    void xlsFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/my archive.zip"))) {
            ZipEntry entry = zip.getEntry("menu.xls");
            InputStream inputStream = zip.getInputStream(entry);
            XLS xls = new XLS(inputStream);

            Assertions.assertEquals("Макаронс",
                    xls.excel.getSheetAt(0).
                            getRow(2).
                            getCell(0).
                            getStringCellValue());
        }
    }
}













