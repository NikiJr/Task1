import java.io.*;
import java.nio.file.*;
import java.util.*;
public class Test{
	public File inSameDirectory(String pathWay){// funkciya dlya raboty programmy s papkoy v toy zhe direktorii
		Path path = Paths.get("");
		String currentDir = new String(path.toAbsolutePath().toString() + pathWay);
		File mainDir = new File(currentDir);
		return mainDir;
	}
	public String searcher(File f){ // sborka ArrayList s adresami tolko failov v direktorii na vhode
		List<String> result = new ArrayList<String>();
		File[] currentDirectory = f.listFiles();
		//result.addAll(Arrays.asList(currentDirectory));
		for(int i = 0; i < currentDirectory.length; i++){
			if (currentDirectory[i].isFile()){
				String s = currentDirectory[i].getPath();
				//result.add(s);
				continue;
			}else /*if(currentDirectory[i].isFile())*/{
				searcher(currentDirectory[i]);
				continue;
						//return result;
			}

		}
		
			/*System.out.println(result);
			System.out.println(result.size());*/
			return s;
		

	}
	
	public List<String> listMaker(String l){
		l = searcher(inSameDirectory("/logs/14-HEAT_TRANSFER_IN_SOLID"));
		List<String> result;
		result.add(l);
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args){
		Test t = new Test();
		t.searcher(t.inSameDirectory("/logs/14-HEAT_TRANSFER_IN_SOLID"));
	}
}
