package util;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRcodeCreater
{
	private String savePath =QRcodeSetter.savePath;
	public static void run() throws Exception
	{
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');//����ȼ�
		x.setQrcodeEncodeMode('B');// N ���� A��ĸ B����
		final int QRVersion =QRcodeSetter.QRVersion;
		x.setQrcodeVersion(QRVersion);//version 1-40
		final String qrData = QRcodeSetter.qrData;
		
		int QRsize = 67+12*(QRVersion-1);
		int height = QRsize;
		int width = QRsize;
		BufferedImage bufferedImage = new BufferedImage (QRsize,QRsize,BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(QRcodeSetter.backColor);
		gs.setColor(QRcodeSetter.mainColor);
		gs.clearRect(0, 0, width, height);
		
		int pixoff = 2;//ƫ����
		
		byte[] d = qrData.getBytes("gb2312");
		if (d.length>0 && d.length<120) 
		{
			boolean [][] s = x.calQrcode(d);
			for (int i=0;i<s.length;i++) 
			{
				for (int j=0;j<s.length;j++) 
				{
					if(s[j][i]) 
					{
						gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
					}
				}
			}
			
			
		}
		gs.dispose();
		bufferedImage.flush();
		
		ImageIO.write(bufferedImage, "png", new File (new QRcodeCreater().savePath));
	}


}
