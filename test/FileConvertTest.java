import java.io.*;
public class FileConvertTest{
	public static void main(String[] args) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		InputStreamReader isr1 = null;
		InputStreamReader isr2 = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try{
			fis1 = new FileInputStream("E:/GBK.txt");
			fis2 = new FileInputStream("E:/UTF-8.txt");
			isr1 = new InputStreamReader(fis1,"GBK");
			fos = new FileOutputStream("D:/abc.txt");
			osw = new OutputStreamWriter(fos);
			int len1 = 0;
			char[] cha1 = new char[4];
			while((len1 = isr1.read(cha1)) != -1){
				osw.write(cha1,0,len1);
				osw.flush();
			}

			isr2 = new InputStreamReader(fis2,"utf-8");
			int len2 = 0;
			char[] cha2 = new char[4];
			while((len2 = isr2.read(cha2)) != -1){
				osw.write(cha2,0,len2);
				osw.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(isr1 != null){
					isr1.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(isr2 != null){
					isr2.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(osw != null){
					osw.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
				