package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
 public static void main(String[] args)
 {
	 JsonPath js= new JsonPath(payload.CoursePrice());
	 //1. Print No of courses returned by API
	 
	int count =  js.getInt("courses.size()");
	System.out.println(count);

	//2.Print Purchase Amount
	 
	int totalamount = js.getInt("dashboard.purchaseAmount");
	System.out.println(totalamount);
	
	//3. Print Title of the first course
	
	String firstcoursetitle = js.getString("courses[0].title");
	System.out.println(firstcoursetitle);
	
	//4. Print All course titles and their respective Prices
	
	for (int i=0;i<count;i++)
	{
		String CourseTitles = js.getString("courses["+i+"].title");
		int priceofcourse= js.getInt("courses["+i+"].price");
		
		System.out.println("The course title is " +CourseTitles);
		System.out.println("The price of course is " +priceofcourse);
		}
	//5. Print no of copies sold by RPA Course
	
	int copies = js.getInt("courses[2].copies");
	System.out.println("The no of copies sold by RPA course is " + copies);
	
	System.out.println(" Print no of copies sold by RPA Course");
	for(int i=0;i<count;i++)
	{
		String CourseTitles = js.getString("courses["+i+"].title");
		if(CourseTitles.equalsIgnoreCase("RPA"))
		{
			int nocopies =js.getInt("courses["+i+"].copies");
			System.out.println("The no of copies sold by RPA course is " + nocopies);
			break;
		}
		
		
	}
		
}
		}

	