package me.belakede.thesis.server.auth.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class UsersResponseTest {

    public static final class UsersResponseEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public UsersResponseEqualsAndHashCodeTest(String name) {
            super(name, UsersResponse.class, Arrays.asList("users"));
        }

        @Override
        protected UsersResponse createInstance() throws Exception {
            return new UsersResponse(new HashSet<>(Arrays.asList(new UserResponse("admin"), new UserResponse("test1"))));
        }

        @Override
        protected UsersResponse createNotEqualInstance() throws Exception {
            return new UsersResponse(new HashSet<>(Collections.singletonList(new UserResponse("test1"))));
        }
    }

    public static final class UsersResponsePojoTest extends PojoClassTestCase {

        public UsersResponsePojoTest(String name) {
            super(name, UsersResponse.class);
        }
    }
    
}