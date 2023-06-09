import com.project0.daos.DepartmentDAO;
import com.project0.models.Department;
import com.project0.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class DepartmentServicetest { // We're mocking the DAO to prevent calls to the actual DB
    DepartmentDAO mockDepartmentDao = mock(DepartmentDAO.class);
    DepartmentService depService = new DepartmentService(mockDepartmentDao);

    @Test
    public void getDepartmentByIdZero(){
        // What should we get when we pass zero to this method?
        // Zero shouldn't pass the if condition, so we should be able to just verify null

        Assertions.assertNull(depService.getDepartmentById(0));
    }

    @Test
    public void getDepartmentByIdNegativeInt(){
        // What should we get when we pass zero to this method?
        // Zero shouldn't pass the if condition, so we should be able to just verify null

        Assertions.assertNull(depService.getDepartmentById(-3));
    }

    // Now, how do we go about testing for positive values?
    // We need fake a call to the departmentDAO and essentially return it with a return value

    @Test
    public void getDepartmentByIdPositiveInt(){
        // Let's create a fake Role object we want to return from the db
        Department department = new Department("Accounting", "111 Peoria st", "7677899890", 200000);

        // Now we need to make sure our dao returns this when called
        when(mockDepartmentDao.getDepartmentById(4)).thenReturn(department);

        Assertions.assertEquals(department, depService.getDepartmentById(4));
    }

    // Let's test the update salary method
    @Test
    public void updateDepartmentBudgetNullTitle(){
        String title = null;

        Assertions.assertFalse(depService.updateDepBudget(12345, title));

        // We need to make this test "stronger"
        // Let's also verify that our method for updating the db was NOT called
        verifyNoInteractions(mockDepartmentDao);
    }

    @Test
    public void updateDepartmentBudgetBlankTitleString(){
        String title = "    ";

        Assertions.assertFalse(depService.updateDepBudget(453444, title));

        // We need to make this test "stronger"
        // Let's also verify that our method for updating the db was NOT called
        verifyNoInteractions(mockDepartmentDao);
    }
    @Test
    public void updateBudgetMalformedTitle(){
        String title = "fiNANCE";

        when(mockDepartmentDao.updateDepBudget(anyInt(), anyString())).thenReturn(true);

        depService.updateDepBudget(12345, title);

        verify(mockDepartmentDao, times(1)).updateDepBudget(12345, "Finance");
    }


}