package db;

public class MySQLDBUtil {
	private static final String INSTANCE = "jobproject-instance.cawt4p6uelac.ap-northeast-1.rds.amazonaws.com";
	private static final String PORT_NUM = "3306";
	public static final String DB_NAME = "jobproject";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "19971997";
	public static final String URL = "jdbc:mysql://"
			+ INSTANCE + ":" + PORT_NUM + "/" + DB_NAME
			+ "?user=" + USERNAME + "&password=" + PASSWORD
			+ "&autoReconnect=true&serverTimezone=UTC";
}
