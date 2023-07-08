package guru.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.StudentModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JsonParsingTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonParsingTest() throws Exception {
        File file = new File("src/test/resources/student.json");
        StudentModel student = objectMapper.readValue(file, StudentModel.class);

        Assertions.assertEquals("Elena", student.getName());
        Assertions.assertEquals("test@test.com", student.getEmail());
        Assertions.assertEquals("Female", student.getGender());
        Assertions.assertEquals("07.07.1989", student.getDateBirth());
        Assertions.assertEquals("English", student.getSubjects());
        Assertions.assertEquals("Sport", student.getHobbies().get(0));
        Assertions.assertEquals("Traveling", student.getHobbies().get(1));
        Assertions.assertEquals("Cooking", student.getHobbies().get(2));
        Assertions.assertEquals("Address", student.getCurrentAddress());
        Assertions.assertEquals(true, student.isOffline());
    }
}
