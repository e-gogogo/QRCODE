package util;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;

public class QRcodeSetter
{
	
	static String qrData = "hello, world";
	static int QRVersion = 7;
	static Color mainColor = Color.RED;
	static Color backColor = Color.WHITE;
	static String savePath = "D:/code/qrcode.png";
	
	public static void setQRData(String qrData) 
	{
		QRcodeSetter.qrData=qrData;
	}
	public static void setsavePath() 
	{
		Frame f = new Frame("ѡȡ��ַ");
		FileDialog d = new FileDialog(f,"ѡ������·��",FileDialog.SAVE);
		d.setVisible(true);
		QRcodeSetter.savePath=d.getDirectory()+d.getFile();
	}
	public static void setsavePath(String savePath) 
	{
		QRcodeSetter.savePath=savePath;
	}
	public static void setQRVersion(int QRVersion) 
	{
		QRcodeSetter.QRVersion=QRVersion;
	}
	public static void setMainColor(Color mainColor) 
	{
		QRcodeSetter.mainColor=mainColor;
	}
	public static void setBackColor(Color backColor) 
	{
		QRcodeSetter.backColor=backColor;
	}
}
