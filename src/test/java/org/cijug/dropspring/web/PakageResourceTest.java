package org.cijug.dropspring.web;

import org.cijug.dropspring.core.Pakage;
import org.cijug.dropspring.db.PakageDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PakageResourceTest {

    @Mock PakageDAO dao;
    @InjectMocks PakageResource resource;

    @Test public void shouldFindByName() {
        resource.getPakagesByName("name");

        verify(dao).getPakagesByName("name");
    }

    @Test public void shouldSavePakage() {
        Pakage pakage = new Pakage();

        resource.addPakage(pakage);

        verify(dao).savePakage(pakage);
    }

}
