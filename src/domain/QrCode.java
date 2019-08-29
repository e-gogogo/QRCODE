package domain;

import java.awt.Color;

public class QrCode {
	private String qrData;
	private int QRVersion;
	private Color mainColor;
	private Color backColor;
	private String savePath;
	public String getQrData() {
		return qrData;
	}
	public void setQrData(String qrData) {
		this.qrData = qrData;
	}
	public int getQRVersion() {
		return QRVersion;
	}
	public void setQRVersion() {
		QRVersion = 7;
	}
	public Color getMainColor() {
		return mainColor;
	}
	public void setMainColor() {
		this.mainColor = Color.RED;
	}
	public Color getBackColor() {
		return backColor;
	}
	public void setBackColor() {
		this.backColor = Color.WHITE;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}
