package controller;

import database.PersonDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import model.person;
import register_entry.RegisterEntry;

// Run with PowerMock, an extended version of Mockito
@RunWith(PowerMockRunner.class)
// Prepare class RegistrationController for testing by injecting mocks
@PrepareForTest(PersonController.class)
public class PersonController_UTest {
    public PersonController_UTest(){

    }

    @Before
    public void initialize(){

    }

    @Test
    public void t_addPerson() throws Exception
    {
        PersonDatabase mock_pdb = Mockito.mock(PersonDatabase.class);
        person mock_person = Mockito.mock(person.class);

        RegisterEntry mock_registerEntry = Mockito.mock(RegisterEntry.class);
        Mockito.when(mock_registerEntry.isCheckedIn()).thenReturn(true);
        PowerMockito.whenNew(RegisterEntry.class).withArguments(true).thenReturn(mock_registerEntry);

        Controller controllerTest = new PersonController(mock_pdb);
        controllerTest.addPerson(mock_person);
        Mockito.verify(mock_pdb, Mockito.times(1)).AddPerson(mock_person, mock_registerEntry);
    }

    @Test
    public void t_removePerson() throws Exception
    {
        PersonDatabase mock_pdb = Mockito.mock(PersonDatabase.class);
        person mock_person = Mockito.mock(person.class);

        RegisterEntry mock_registerEntry = Mockito.mock(RegisterEntry.class);
        Mockito.when(mock_registerEntry.isCheckedIn()).thenReturn(false);
        PowerMockito.whenNew(RegisterEntry.class).withArguments(false).thenReturn(mock_registerEntry);

        Controller controllerTest = new PersonController(mock_pdb);
        controllerTest.removePerson(mock_person);
        Mockito.verify(mock_pdb, Mockito.times(1)).DeletePerson(mock_person, mock_registerEntry);
    }


}
