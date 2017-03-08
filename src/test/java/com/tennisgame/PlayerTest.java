package com.tennisgame;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void PlayerNameCanBeSet() throws Exception {
        Player underTest = new Player();
        underTest.setName("Rita");
        assertThat(underTest.getName(), is("Rita"));
    }
}
