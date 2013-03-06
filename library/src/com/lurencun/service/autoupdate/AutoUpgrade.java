package com.lurencun.service.autoupdate;



/**
 * 自动更新服务的操作接口
 * 
 * @author ilovedeals
 * 
 */
public interface AutoUpgrade {

	/**
	 * 取得checkLatestVersion调用后创建的Version信息
	 * 
	 * @return
	 */
	Version getLatestVersion();

	/**
	 * 设置自定义显示新版本信息接口
	 * 
	 * @param delegate
	 */
	void setCustomVersionShowing(CustomDisplay delegate);

	/**
	 * 从指定URL检查新版本，并指定响应数据解析器。
	 * 如果URL返回的版本码大于当前App的版本码，若没有通过setCustomVersionShowing指定版本提示的
	 * 显示方式，默认弹出一个系统级窗口（需要指定 <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" /> 权限）。
	 * @param url
	 * @param parser
	 */
	void checkLatestVersion(String url, ResponseParser parser);

	/**
	 * 从指定版本中下载并安装APK文件
	 * 
	 * @param url
	 */
	void downloadAndInstall(Version targetVersion);

	/**
	 * 在调用checkLatestVersion取得服务器返回版本信息后，调用此方法将直接下载并安装该版本
	 */
	void downloadAndInstall();

	/**
	 * 注册接收器
	 */
	void registerReceiver();

	/**
	 * 反注册接收器
	 */
	void unregisterReceiver();
}
