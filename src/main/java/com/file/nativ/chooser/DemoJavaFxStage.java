package com.file.nativ.chooser;

import java.awt.Toolkit;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")

public class DemoJavaFxStage extends JFrame {

	private JFileChooser fileChooser;

	public JFileChooser getFileChooser() {

		return fileChooser;

	}

	public void setFileChooser(JFileChooser fileChooser) {

		this.fileChooser = fileChooser;

	}

	public DemoJavaFxStage() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(DemoJavaFxStage.class.getResource("/images/folder.png")));

		this.setVisible(false);

	}

	public LinkedList<File> customShowOpenFileDialog(boolean carpeta, JFileChooser chooser, String filtro) {

		LinkedList<File> files = new LinkedList<File>();

		fileChooser = chooser;

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		fileChooser.setMultiSelectionEnabled(true);

		if (carpeta) {

			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		}

		else {

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		}

		fileChooser.setAcceptAllFileFilterUsed(true);

		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {

			File[] selectedFile = fileChooser.getSelectedFiles();

			files = addImages(carpeta, filtro, selectedFile);

		}

		return files;

	}

	public LinkedList<File> showOpenFileDialog(boolean carpeta, String filtro) {

		LinkedList<File> files = new LinkedList<File>();

		fileChooser = new JFileChooser();

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		fileChooser.setMultiSelectionEnabled(true);

		if (carpeta) {

			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		}

		else {

			switch (filtro) {

			case "":
			case "none":

			case "all":

				break;

			case "images":

				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif"));

				break;

			case "videos":

				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Videos", "mp4", "avi", "mpg", "mkv"));

				break;

			default:

				fileChooser.addChoosableFileFilter(
						new FileNameExtensionFilter(filtro + " Files (*." + filtro + ")", filtro));

				break;

			}

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		}

		fileChooser.setAcceptAllFileFilterUsed(true);

		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {

			File[] selectedFile = fileChooser.getSelectedFiles();

			files = addImages(carpeta, filtro, selectedFile);

		}

		return files;

	}

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}

		catch (Exception e) {

		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				new DemoJavaFxStage();

			}

		});

	}

	public static String extraerExtension(String nombreArchivo) {

		String extension = "";

		if (nombreArchivo.length() >= 3) {

			extension = nombreArchivo.substring(nombreArchivo.length() - 3, nombreArchivo.length());

			extension = extension.toLowerCase();

			if (extension.equals("peg")) {
				extension = "jpeg";
			}

			if (extension.equals("fif")) {
				extension = "jfif";
			}

			if (extension.equals("ebp")) {
				extension = "webp";
			}

			if (extension.equals("ebm")) {
				extension = "webm";
			}

			if (extension.equals("3u8")) {
				extension = "m3u8";
			}

			if (extension.equals(".ts")) {
				extension = "ts";
			}

		}

		return extension;
	}

	public static String saberSeparador() {

		if (System.getProperty("os.name").equals("Linux")) {

			return "/";

		}

		else {

			return "\\";

		}

	}

	public static LinkedList<File> addImages(boolean carpeta, String filtro, File[] fc) {

		LinkedList<File> files = new LinkedList<File>();

		files.clear();

		Arrays.asList(fc).forEach(x -> {

			if (!carpeta) {

				String extension;

				if (x.isFile()) {

					switch (filtro) {

					case "":

					case "none":

					case "all":

						files.add(new File(x.getAbsolutePath()));

						break;

					case "images":

						extension = extraerExtension(x.getAbsolutePath());

						if (extension.equals("jpeg") || extension.equals("bmp") || extension.equals("jpg")
								|| extension.equals("png") || extension.equals("gif")) {

							files.add(new File(x.getAbsolutePath()));

						}

						break;

					default:

						extension = extraerExtension(x.getAbsolutePath());

						if (extension.equals(filtro)) {

							files.add(new File(x.getAbsolutePath()));

						}

						break;

					}

				}

			}

			else {

				if (x.isDirectory()) {

					files.add(new File(x.getAbsolutePath()));

				}

			}

		});

		return files;

	}

}
