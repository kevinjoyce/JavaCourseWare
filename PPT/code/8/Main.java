import java.io.*;
public class Main{
	public static void main(String[] args) throws Exception{
		Car c = new Car("BMW");
		RadarCar rc = new RadarCar(c);
		rc.show();
		FileInputStream in = new FileInputStream("source.txt");
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream out = new FileOutputStream("dest.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		FileOutputStream fos = new FileOutputStream("objectStream.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Car("BMW"));
		
		
		FileInputStream fis = new FileInputStream("objectStream.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Car c2 = (Car) ois.readObject();
		
		FileOutputStream fos2 = new FileOutputStream("dataStream.txt");
		BufferedOutputStream bos2 = new BufferedOutputStream(fos2);
		DataOutputStream dos = new DataOutputStream(bos2);
		dos.writeByte(12);
		dos.writeChar('1');
		dos.writeBoolean(true);
		dos.writeUTF("同学你好");
		dos.close();
		
		FileInputStream fis2 = new FileInputStream("dataStream.txt");
		BufferedInputStream bfs2 = new BufferedInputStream(fis2);
		DataInputStream dis = new DataInputStream(bfs2);
		System.out.println(dis.readByte());
		System.out.println(dis.readChar());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readUTF());
		dis.close();
		
		
		FileInputStream fis3 = new FileInputStream("data.txt");
		ByteArrayOutputStream bais = new ByteArrayOutputStream();
		
		int b;
		while((b = in.read())!=-1){
			bais.write(b);
		}
		fis3.close();
		bais.close();
		
		FileOutputStream fos3 = new FileOutputStream("data2.txt");
		fos3.write(bais.toByteArray());
		fos3.close();
		
		System.setIn(new FileInputStream("source.txt"));
		System.setOut(new PrintStream("target.txt"));
		
		
		
		File file = new File("d:\\adir");
		if(file.isDirectory()){
			String[] names = file.list();
			for(String name:names){
				System.out.println(name);
			}
		}
		
		
		FilenameFilter filter = new FilenameFilter(){
			public boolean accept(File dir, String name){
				File currFile = new File(dir, name);
				
				if(currFile.isFile() && name.endsWith(".java"))
					return true;
				else
					return false;
				
			}
		};
		
		File file2 = new File("d:\\adir");
		if(file2.isDirectory()){
			String[] names = file2.list(filter);
			for(String name:names){
				System.out.println(name);
			}
		}
		
	}
	public static void fileDir(File dir){
		File [] files = dir.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				fileDir(file);
			}
			System.out.println(file.getAbsolutePath());
		}
	}
	
	public static void fileDelete(File dir){
		File [] files = dir.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				fileDelete(file);
			}
			file.delete();
		}
	}
}