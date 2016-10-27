package me.belakede.thesis.server.auth.request;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class UserRequestTest {

    public static final class UserRequestEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public UserRequestEqualsAndHashCodeTest(String name) {
            super(name, UserRequest.class, Arrays.asList("username", "password"));
        }

        @Override
        protected UserRequest createInstance() throws Exception {
            return new UserRequest("demouser", "secretpassword");
        }

        @Override
        protected UserRequest createNotEqualInstance() throws Exception {
            return new UserRequest("username");
        }
    }

    public static final class UserRequestPojoTest extends PojoClassTestCase {

        public UserRequestPojoTest(String name) {
            super(name, UserRequest.class);
        }
    }

}