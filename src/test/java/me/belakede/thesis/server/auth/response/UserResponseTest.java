package me.belakede.thesis.server.auth.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class UserResponseTest {

    public static final class UserResponseEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public UserResponseEqualsAndHashCodeTest(String name) {
            super(name, UserResponse.class, Arrays.asList("username"));
        }

        @Override
        protected UserResponse createInstance() throws Exception {
            return new UserResponse("admin");
        }

        @Override
        protected UserResponse createNotEqualInstance() throws Exception {
            return new UserResponse("demo");
        }
    }

    public static final class UserResponsePojoTest extends PojoClassTestCase {

        public UserResponsePojoTest(String name) {
            super(name, UserResponse.class);
        }
    }

}