import com.file.FileExtensionRewriter;

/**
 * Sep 16, 2023
 */

/**
 * @author admin
 *
 */
public class FileExtensionRewriterMain {

	public static void main(String[] args) {
		// Include trailing slashes for folders
		String sourceFolder = "E:\\Eclipse Workspace\\catis\\src\\main\\java\\gov\\";
		String targetFolder = "E:\\TEST\\CATIS\\source\\";
		String fromExtension = ".java";
		String toExtension = ".txt";

		new FileExtensionRewriter().rewriteFileExtensions(sourceFolder, fromExtension, targetFolder, toExtension);

		// Include trailing slashes for folders
		sourceFolder = "E:\\Eclipse Workspace\\catis\\src\\main\\webapp\\WEB-INF\\Views\\";
		targetFolder = "E:\\TEST\\CATIS\\Views\\";
		fromExtension = ".jsp";
		toExtension = ".txt";

		new FileExtensionRewriter().rewriteFileExtensions(sourceFolder, fromExtension, targetFolder, toExtension);

		// Include trailing slashes for folders
		sourceFolder = "E:\\Eclipse Workspace\\catis\\src\\main\\webapp\\js\\";
		targetFolder = "E:\\TEST\\CATIS\\Scripts\\";
		fromExtension = ".js";
		toExtension = ".txt";

		new FileExtensionRewriter().rewriteFileExtensions(sourceFolder, fromExtension, targetFolder, toExtension);
	}

}
