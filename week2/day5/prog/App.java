package prog;
import java.util.*;
import org.apache.commons.csv.*;
import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.JSONObject.*;
import org.json.simple.parser.*;
import java.io.*;
public class App 
{

	public static void main(String[] args) throws IOException,ParseException{
		JSONParser parser = new JSONParser();
	try(
		BufferedReader reader = new BufferedReader(new FileReader("./prog/sample-input.csv - Sheet1.csv"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("./prog/sample-output.csv"));
		
		CSVParser csvParser =  new CSVParser(reader,CSVFormat.DEFAULT.withFirstRecordAsHeader());
		)
		{
			Object obj = parser.parse(new FileReader("./prog/config.json"));
			JSONObject jsonObject =(JSONObject) obj;

			Map<String,Integer> headerMap = csvParser.getHeaderMap();			//getting headers of the csv
			List<String> headers = new ArrayList<>();
			List<String> dField=new ArrayList<>();
			headerMap.entrySet().stream().forEach(hp->headers.add(hp.getKey()));
			CSVPrinter csvPrinter = new CSVPrinter(writer,CSVFormat.DEFAULT);

			JSONObject groupHeader = (JSONObject)jsonObject.get("GroupHeaders");
			JSONArray oldHeaders = (JSONArray)groupHeader.get("Old");

			List<String> oHead = new ArrayList<>();
			for(int i=0;i<oldHeaders.size();i++)						//Getting the header which has to b grouped
				oHead.add((String)oldHeaders.get(i));
			
			

			JSONArray changeHeader = (JSONArray)jsonObject.get("ChangeHeader");
			//JSONArray changeValue = (JSONArray)jsonObject.get("ChangeValue");
			JSONArray dateField = (JSONArray)jsonObject.get("DateField");
			String timeFormat = (String)jsonObject.get("TimeFormat");

			Map<String,String> chHead = new HashMap<String,String>();
			Iterator it = changeHeader.iterator();

			for(int i=0;i<dateField.size();i++)
				dField.add((String)dateField.get(i));

			while(it.hasNext())											//Getting the headers which has to be changed
			{
			  Object head = it.next();
			  JSONObject chnHead = (JSONObject) head;
			  String old = (String) chnHead.get("Old");
			  String new1= (String) chnHead.get("New");
			  chHead.put(old,new1);
			}

			for(String s : headers)									//Writing Headers to new File
			{
				if(!oHead.contains(s) && chHead.containsKey(s))
					csvPrinter.print(chHead.get(s));
				else
				if(!oHead.contains(s))
					csvPrinter.print(s);	
				
			}
			String headerName = (String)groupHeader.get("HeaderName");
			csvPrinter.print(headerName);
			csvPrinter.println();


			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			Map<String,String> custDetails = new LinkedHashMap<>();
			

		
		DateFormat df = new DateFormat();

			for(CSVRecord csvRecord : csvRecords)
			{
				for(String s: headers)
				{
					if(!oHead.contains(s))
					{
						if(dField.contains(s))
							csvPrinter.print(df.changeDateFormat(csvRecord.get(s),timeFormat));				//changing dateFormat
						else
							csvPrinter.print(csvRecord.get(s));
					}
				}

				for(String s : oHead)						//Writing the grouped fields
				{
					custDetails.put(s.substring(9),csvRecord.get(s));
				}
				csvPrinter.print(custDetails);
				csvPrinter.println();
			}

 
		}

		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}