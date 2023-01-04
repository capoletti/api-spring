package com.cpoletti.apispring;

import com.cpoletti.apispring.util.UtilDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UtilDateTests {

    @Test
    void calculateDate() {

        // setup
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2000, 01, 12);

        Calendar currentDate = Calendar.getInstance();
        currentDate.set(2022, 01, 12);

        // exercise
        int actual = UtilDate.calculateAge(birthDate, currentDate);
        // assert
        assertThat(actual).isEqualTo(22);
    }
    
}

