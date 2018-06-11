package ClassDesign;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLoader {
//	
//	public static void main(String[] args) throws Exception {
//	    String imageUrl = "https://res.cloudinary.com/thoatt/image/upload/v1527178246/llk0rzil6lobaum2wte1.jpg";
//	    String destinationFile = "src/images/image.jpg";
//
//	    saveImage(imageUrl, destinationFile);
//	    System.out.println("Done");
//	}

	
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
	    URL url = new URL(imageUrl);
	    InputStream is = url.openStream();
	    OutputStream os = new FileOutputStream(destinationFile);

	    byte[] b = new byte[2048];
	    int length;

	    while ((length = is.read(b)) != -1) {
	        os.write(b, 0, length);
	    }

	    is.close();
	    os.close();
	}

	

}
