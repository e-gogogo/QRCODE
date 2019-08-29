package util;

import java.awt.Color;



public class QRUseageDemmo
{

	public static void main(String[] args) throws Exception
	{
		//设置二维码内容，初始值为"hello, world"
		//QRcodeSetter.setQRData("WWW.ICBC.COM");
		
		//设置保存路径，初始值为"D:/code/qrcode.png"
		//QRcodeSetter.setsavePath(); //后缀应为.png
		//QRcodeSetter.setsavePath("D:/code/qrcode11.png");
		
		//设置二维码版本1-40，初始值为7
		//QRcodeSetter.setQRVersion(7);
		
		//设置二维码颜色，初始值为白底红色
		//QRcodeSetter.setMainColor(Color.BLUE);
		//QRcodeSetter.setBackColor(Color.GREEN);
		
		//生成二维码
		QRcodeCreater.run();
		

	}

}