package cn.pojo;
/**
 * 
 * 类描述：汽车实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月25日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class Car {
	private int carId;
	private String carName;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + "]";
	}
}
