package com.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

import com.util.DateFormatHelper;

public class FileExtensionRewriter {

	public void rewriteFileExtensions(String sourceFolder, String fromExtension, String targetFolder,
			String toExtension) {
		try {
			if (fromExtension.equals(toExtension)) {
				System.err.println("From and to extensions are same");
				return;
			}

			if (sourceFolder.equalsIgnoreCase(targetFolder)) {
				System.err.println("Source and target folder same");
				return;
			}

			targetFolder = targetFolder + DateFormatHelper.getTimeStampString() + "//";

			File srcDir = new File(sourceFolder);
			File destDir = new File(targetFolder);
			destDir.mkdir();

			try {
				FileUtils.copyDirectory(srcDir, destDir);
			} catch (IOException e) {
				e.printStackTrace();
			}

			File file = new File(targetFolder);
			rewriteFile(file, fromExtension, toExtension);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void rewriteFile(File dirPath, String fromExtension, String toExtension) {
		System.out.println(dirPath.getAbsolutePath());
		File filesList[] = dirPath.listFiles();
		for (File file : filesList) {
			if (file.isFile()) {
				System.out.println("Processing file: " + file.getName() + " (" + file.getAbsolutePath() + ")");
				int index = file.getName().lastIndexOf(".");
				String ext = file.getName().substring(index);
				if (ext.equalsIgnoreCase(fromExtension)) {
					System.out.println("New name: " + file.getParent() + "\\" + file.getName().substring(0, index) + toExtension);
					file.renameTo(new File(file.getParent()+ "\\" + file.getName().substring(0, index) + toExtension));
//					File file1 = new File(file.getParent()+ "\\" + file.getName().substring(0, index) + toExtension);
//					// file.getName().substring(0, index)+toExtension
//					try {
//						System.err.println("Creating file:  "+ file1.createNewFile());
//					} catch (IOException e) {
//						e.printStackTrace();
//					}

					
					System.out.println("Processed: " + file.getName() + " (" + file.getAbsolutePath() + ")");
				}else {
					
				}
				System.out.println("Deleting file: " + file.getName() + " (" + file.getAbsolutePath() + ")");
				System.err.println("Deletion: " + file.delete());

				System.out.println("-------------------------------------------------");

			} else {
				rewriteFile(file, fromExtension, toExtension);
			}
		}
	}

//	public void rewriteFile(File dirPath, String fromExtension, String toExtension) {
//		System.out.println(dirPath.getAbsolutePath());
//		File filesList[] = dirPath.listFiles();
//		for (File file : filesList) {
//			if (file.isFile()) {
//				System.out.println("Processing file: " + file.getName() + " (" + file.getAbsolutePath() + ")");
//				int index = file.getName().lastIndexOf(".");
//				String ext = file.getName().substring(index);
//				if (ext.equalsIgnoreCase(fromExtension)) {
//					System.out.println("New name: " + file.getName().substring(0, index) + toExtension);
//					File file1 = new File(file.getName().substring(0, index) + toExtension);
//					// file.getName().substring(0, index)+toExtension
//					try {
//						System.out.println("Creating file:  "+ file1.createNewFile());
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//
//					
//					System.out.println("Processed: " + file1.getName() + " (" + file1.getAbsolutePath() + ")");
//				}
//				System.out.println("Deleting file: " + file.getName() + " (" + file.getAbsolutePath() + ")");
//				System.err.println(file.delete());
//
//				System.out.println("-------------------------------------------------");
//
//			} else {
//				rewriteFile(file, fromExtension, toExtension);
//			}
//		}
//	}
}
