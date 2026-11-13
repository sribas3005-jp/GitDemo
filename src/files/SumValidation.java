package files;
//Verify if Sum of all Course prices matches with Purchase Amount
import org.testng.annotations.Test;

	import io.restassured.path.json.JsonPath;

	public class SumValidation {
		
		@Test
		public void SumofCourses()
		{
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("course.size()");
		for (int i=0;i<count;i++)
		{
		int courseprice	= js.getInt("courses["+i+"].price");
		int coursecopies = js.getInt("courses["+i+"].copies");
		int amount =  courseprice * coursecopies;
		System.out.println(amount);
		
	}
		
	}
	}


