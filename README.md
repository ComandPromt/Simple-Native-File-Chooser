# Simple Native File Chooser

![Preview](preview.png)

## Custom File Chooser

~~~java

	try {
	
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	
		DemoJavaFxStage test = new DemoJavaFxStage();
	
		LinkedList<File> lista = new LinkedList<File>();
	
		lista = test.showOpenFileDialog(false, "xml");
	
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
