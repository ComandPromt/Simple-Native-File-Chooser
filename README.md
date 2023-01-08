# Simple Native File Chooser

![Preview](preview.png)

## Custom File Chooser

~~~java

	try {
	
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	
		DemoJavaFxStage test = new DemoJavaFxStage();
	
		LinkedList<File> lista = new LinkedList<File>();
	
		// Example 1 lista = test.showOpenFileDialog(false, "xml");
			
		/* Example 2 CustomFilter 

			JFileChooser test1 = new JFileChooser();

			test1.addChoosableFileFilter(new FileNameExtensionFilter("Files", "mp4", "gif", "jpg"));

			lista = test.customShowOpenFileDialog(false, test1, "mp4,gif,jpg");
			
		*/
		
		for (int i = 0; i < lista.size(); i++) {
	
			System.out.println(lista.get(i).getAbsolutePath());
	
		}
	
	}
	
	catch (Exception e1) {
	
	}
	
~~~

## Open Folders

~~~java

showOpenFileDialog(true, "");

~~~

## Open All Files

~~~java

showOpenFileDialog(false, "all");

~~~

## Open a type of file

~~~java

showOpenFileDialog(false, "pdf");

~~~

## Open Image files (jpg,png,gif,bmp)

~~~java

showOpenFileDialog(false, "images");

~~~

## Open Video files (mp4,avi,mpg,mkv)

~~~java

showOpenFileDialog(false, "videos");

~~~
