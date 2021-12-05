import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DemoJavaFxStage extends JFrame {

	private JButton buttonBrowse;

	public DemoJavaFxStage() {

		super("Demo File Type Filter");

		setLayout(new FlowLayout());

		buttonBrowse = new JButton("Browse...");

		buttonBrowse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				showOpenFileDialog();

			}
		});

		getContentPane().add(buttonBrowse);

		setSize(300, 100);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}

		catch (Exception e) {

		}

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new DemoJavaFxStage();

			}

		});

	}

	private void showOpenFileDialog() {

		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		fileChooser.setMultiSelectionEnabled(true);

		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif"));

		fileChooser.setAcceptAllFileFilterUsed(true);

		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {

			File[] selectedFile = fileChooser.getSelectedFiles();

			for (File i : selectedFile) {

				System.out.println("Selected file: " + i);

			}

		}

	}

}
