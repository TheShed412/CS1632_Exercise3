import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class RentACatTest 
{
	RentACat rc = new RentACat();

	@Test
	public void getCatEmptyTest(){
		
		ArrayList<Cat> cats = new ArrayList<Cat>();
		Cat actual = rc.getCat(0, cats);

		assertEquals(actual, null);
	}

}