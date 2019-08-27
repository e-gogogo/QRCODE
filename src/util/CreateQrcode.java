package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import domain.QrCode;

public class CreateQrcode {
	public static String create(QrCode qrcode) throws IOException{
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');// 纠错等级
		x.setQrcodeEncodeMode('B');// N 数字 A字母 B其他
		x.setQrcodeVersion(7);// version 1-40
		
		int QRsize = 67 + 12 * (7 - 1);
		int height = QRsize;
		int width = QRsize;
		BufferedImage bufferedImage = new BufferedImage(QRsize, QRsize, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.RED);
		gs.clearRect(0, 0, width, height);

		int pixoff = 2;// 偏移量

		byte[] d = qrcode.getQrData().getBytes("utf8");
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}

		}
		gs.dispose();
		bufferedImage.flush();
		ImageIO.write(bufferedImage, "png", new File(qrcode.getSavePath()));
		return "suc";
	}
}
