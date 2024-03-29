package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFormMapperTest {

    private final String NAME = "FULANO";
    private final String EMAIL = "fulano@email.com";
    private final String PASSWORD = "123456";

    private UserFormMapper mapper;

    @Test
    void shouldConvertUserFormToUser() {
        var userForm = new UserForm(NAME, EMAIL, PASSWORD);
        mapper = new UserFormMapper();

        var user = mapper.map(userForm);
        assertEquals(NAME, user.getName());
        assertEquals(EMAIL, user.getEmail());
        assertEquals(PASSWORD, user.getPassword());
    }
}
