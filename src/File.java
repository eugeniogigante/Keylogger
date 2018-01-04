import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File {

	public File(String text) {
	try(FileWriter fw = new FileWriter("c:/tmp/myfile.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(text);
		    //more code
		    //out.println("more text");
		    //more code
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	
}
