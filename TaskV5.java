import java.io.*;
import java.nio.file.*;
import java.util.*;



public class TaskV5{
	public File inSameDirectory(String pathWay){// funkciya dlya raboty programmy s papkoy v toy zhe direktorii
		Path path = Paths.get("");
		String currentDir = new String(path.toAbsolutePath().toString() + pathWay);
		File mainDir = new File(currentDir);
		return mainDir;
	}
	
	
	
	
	
	public void task1(File workDir){// Zadanie 1
		File[] workDirFiles = workDir.listFiles();
		for(int i = 0; i < workDirFiles.length; i++){
			int flag = 0;// init i obnulrnie permennoy dlya opredeleniya chego ne hvataet
			File[] workDirFile = workDirFiles[i].listFiles();
			for (int n = 0; n < workDirFile.length; n++){
				
				String temp = workDirFile[n].getName();
				if (temp.equals("ft_reference")){flag++;}
				if (temp.equals("ft_run")){flag+=2;}
			}
			switch (flag){
				case 0: System.out.println("Fail: " + workDirFiles[i].getPath() + " missing: ft_run, ft_reference");
				case 1: System.out.println("Fail: " + workDirFiles[i].getPath() + " missing: ft_run");
				case 2: System.out.println("Fail: " + workDirFiles[i].getPath() + " missing: ft_reference");
				case 3: {System.out.println("OK: " + workDirFiles[i].getPath()); /*task2(workDirFiles[i]);*/}
			}
		}
	}
	
	
	
	
	/*public List<String> searcher(File f){ // popytka napisat vtoroe zadanie
		List<String> result = new ArrayList<String>();
		File[] currentDirectory = f.listFiles();
		//result.addAll(Arrays.asList(currentDirectory));
		for(int i = 0; i < currentDirectory.length; i++){
			if (currentDirectory[i].isDirectory()){
				searcher(currentDirectory[i]);
				//continue;
			}else if(currentDirectory[i].isFile()){
				String s = currentDirectory[i].getPath();
				result.add(s);
				
			}
		}
		System.out.println(result);
		return result;
	}





	public void task2(File f){
		File[] currentDirectory = f.listFiles();
		List<String> ft_reference = new ArrayList<String>();
		List<String> ft_run = new ArrayList<String>();
		for(int i = 0; i < currentDirectory.length; i++){
			if (currentDirectory[i].getName().equals("ft_reference")){
				
				ft_reference = searcher(currentDirectory[i]);
				//ft_reference[n] = searcher(currentDirectory[i]);
				//System.out.println("ft_reference detected");
				continue;
			}else if(currentDirectory[i].getName().equals("ft_run")){
				
				ft_run = searcher(currentDirectory[i]);
				//ft_run[n] = searcher(currentDirectory[i]);
				//System.out.println("ft_run detected");
				continue;
			}
			
			int dif = ft_reference.size() - ft_run.size();
			if(dif > 0){
				System.out.println("Missing: " + ft_reference.get(dif));
				ft_reference.clear();
				ft_run.clear();
			}else if(dif < 0){
				System.out.println("Missing: " + ft_run.get(dif));
				ft_reference.clear();
				ft_run.clear();
			}
			//System.out.println(currentDirectory[i]);
			//String[] ft_reference;
			//String[] ft_run;
			
				/*for(int n = 0; n < currentDirectory[i].listFiles().length; n++){
					if (currentDirectory[i].getName().equals("ft_reference")){
						//ft_reference[n] = searcher(currentDirectory[i]);
						System.out.println("ft_reference detected");
						continue;
					}else if(currentDirectory[i].getName().equals("ft_run")){
						//ft_run[n] = searcher(currentDirectory[i]);
						System.out.println("ft_run detected");
						continue;
					}
				}*/
				
			
				
			/*int dif = ft_reference.length - ft_run.length;
			if(dif > 0){
				System.out.println("Missing: " + ft_reference[dif]);
			}else if(dif < 0){
				System.out.println("Missing: " + ft_run[dif]);
			}*/
		//}
	//}



	

	
	
	

	
	public static void main(String[] args){
		TaskV5 V5 = new TaskV5();
		V5.task1(V5.inSameDirectory("/logs/13-ROTATED_FLOWS"));
		V5.task1(V5.inSameDirectory("/logs/14-HEAT_TRANSFER_IN_SOLID"));
		V5.task1(V5.inSameDirectory("/logs/15-JOULE_HEATING_IN_SOLID"));
		//V5.task2(V5.inSameDirectory("/logs/14-HEAT_TRANSFER_IN_SOLID"));
	}
}