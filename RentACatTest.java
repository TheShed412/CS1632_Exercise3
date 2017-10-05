import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.mockito.*;


public class RentACatTest 
{
	@Test
	public void returnNonrentedCatTest(){
		RentACat rc = new RentACat();
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(false);
		boolean actual = rc.returnCat(c);

		assertFalse(actual);
	}

	@Test
	public void returnRentedCatTest(){
		RentACat rc = new RentACat();
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(true);
		boolean actual = rc.returnCat(c);

		assertTrue(actual);
	}

	@Test
	public void rentRentedCatTest(){
		RentACat rc = new RentACat();
		Cat c = Mockito.mock(Cat.class);
		Mockito.when(c.getRented()).thenReturn(true);
		boolean actual = rc.rentCat(c);

		assertFalse(actual);
	}

	@Test
	public void listCatsTest(){
		RentACat rc = new RentACat();
		ArrayList<Cat> cats = new ArrayList<Cat>();
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);

		Mockito.when(c1.toString()).thenReturn("ID 1. Joe");
		Mockito.when(c2.toString()).thenReturn("ID 2. Gary");

		cats.add(c1);
		cats.add(c2);

		String actual = rc.listCats(cats);

		String expected = 	"ID 1. Joe\n"+
							"ID 2. Gary\n";
		
		assertEquals(actual, expected);
	}

	@Test
	public void catExistTestSameID(){
		RentACat rc = new RentACat();
		ArrayList<Cat> cats = new ArrayList<Cat>();
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);

		Mockito.when(c1.getName()).thenReturn("Joe");
		Mockito.when(c1.getId()).thenReturn(1);
		Mockito.when(c1.getName()).thenReturn("Gary");
		Mockito.when(c1.getId()).thenReturn(1);

		boolean actual = rc.catExists(1, cats);

		assertTrue(actual);
	}

		@Test
		public void catDoesntExistID(){
		RentACat rc = new RentACat();
		ArrayList<Cat> cats = new ArrayList<Cat>();
		Cat c1 = Mockito.mock(Cat.class);
		Cat c2 = Mockito.mock(Cat.class);

		Mockito.when(c1.getName()).thenReturn("Joe");
		Mockito.when(c1.getId()).thenReturn(1);
		Mockito.when(c1.getName()).thenReturn("Gary");
		Mockito.when(c1.getId()).thenReturn(2);

		boolean actual = rc.catExists(1, cats);

		assertFalse(actual);
	}

}