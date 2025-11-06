package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class DatabaseConfig
{
	// Nhớ đổi tên thiết bị (Ở phần CONENCTION_URL) khi pull code về
	public static String DB_DRIVER          = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String CONNECTION_URL     = "jdbc:sqlserver://MSI:1433;databaseName=databasejava;encrypt=true;trustServerCertificate=true";
	public static String USER_NAME          = "sa";
	public static String PASSWORD           = "123456789";
	public static int    DB_MIN_CONNECTIONS = 100;
	public static int    DB_MAX_CONNECTIONS = 250; 

	private DatabaseConfig()
	{
		throw new IllegalStateException("Utility class");
	}

	/*
	 * public static String WORKSPACE; public static String HOST_NAME; public static String DB_PORT;
	 * public static String DB_NAME; public static String ENCRYPT; public static String
	 * TRUST_SERVER_CERTIFICATE; public static String USER_NAME; public static String PASSWORD; public
	 * static String DB_DRIVER; public static int DB_MIN_CONNECTIONS; public static int
	 * DB_MAX_CONNECTIONS;
	 * 
	 * // Connection URL to be generated after reading config file public static String CONNECTION_URL;
	 * 
	 * private static final InputStream CONFIG_FILE_STREAM;
	 * 
	 * // Lấy đường dẫn của file Config static { // Kiểm tra đường dẫn của file DatabaseConfig.txt
	 * (Debug) System.out.println("Classpath resources:"); URL url =
	 * DatabaseConfig.class.getClassLoader().getResource(""); if(url != null) {
	 * System.out.println(url.getPath()); }
	 * 
	 * CONFIG_FILE_STREAM =
	 * DatabaseConfig.class.getClassLoader().getResourceAsStream("DatabaseConfig.txt");
	 * if(CONFIG_FILE_STREAM == null) { throw new
	 * RuntimeException("DatabaseConfig.txt not found in classpath resources!"); } };
	 * 
	 * // Lấy dữ liệu từ file Config static { Map<String, String> config =
	 * readConfigFromFile(CONFIG_FILE_STREAM);
	 * 
	 * if(config != null) { WORKSPACE = config.getOrDefault("Workspace", "sqlserver"); HOST_NAME =
	 * config.getOrDefault("Hostname", "localhost"); DB_PORT = config.getOrDefault("Port", "1433");
	 * DB_NAME = config.getOrDefault("DatabaseName", "databasejava"); ENCRYPT =
	 * config.getOrDefault("Encrypt", "true"); TRUST_SERVER_CERTIFICATE =
	 * config.getOrDefault("TrustServerCertificate", "true"); USER_NAME =
	 * config.getOrDefault("Username", "sa"); PASSWORD = config.getOrDefault("Password", "123456789");
	 * DB_DRIVER = config.getOrDefault("DatabaseDriver",
	 * "com.microsoft.sqlserver.jdbc.SQLServerDriver"); DB_MIN_CONNECTIONS =
	 * Integer.parseInt(config.getOrDefault("DatabaseMinConnection", "2")); DB_MAX_CONNECTIONS =
	 * Integer.parseInt(config.getOrDefault("DatabaseMaxConnection", "4"));
	 * 
	 * CONNECTION_URL =
	 * String.format("jdbc:%s://%s:%s;databaseName=%s;encrypt=%s;trustServerCertificate=%s", WORKSPACE,
	 * HOST_NAME, DB_PORT, DB_NAME, ENCRYPT, TRUST_SERVER_CERTIFICATE);
	 * 
	 * // Kiểm tra Config đọc được từ file (Debug)
	 * System.out.println("Database Configuration Details:"); System.out.println("- Workspace: " +
	 * WORKSPACE); System.out.println("HOST_NAME: " + HOST_NAME); System.out.println("DB_PORT: " +
	 * DB_PORT); System.out.println("DB_NAME: " + DB_NAME); System.out.println("ENCRYPT: " + ENCRYPT);
	 * System.out.println("TRUST_SERVER_CERTIFICATE: " + TRUST_SERVER_CERTIFICATE);
	 * System.out.println("USER_NAME: " + USER_NAME); System.out.println("DB_DRIVER: " + DB_DRIVER);
	 * System.out.println("DB_MIN_CONNECTIONS: " + DB_MIN_CONNECTIONS);
	 * System.out.println("DB_MAX_CONNECTIONS: " + DB_MAX_CONNECTIONS);
	 * System.out.println("CONNECTION_URL: " + CONNECTION_URL); } }
	 * 
	 * private DatabaseConfig() { throw new
	 * UnsupportedOperationException("Utility class can't be instantiated"); }
	 * 
	 * // Method đọc file Config private static Map<String, String> readConfigFromFile(InputStream
	 * fileStream) { Map<String, String> configMap = new HashMap<>();
	 * 
	 * try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream))) { String
	 * line;
	 * 
	 * @SuppressWarnings("unused") String currentSection = "";
	 * 
	 * while ((line = reader.readLine()) != null) { line = line.trim();
	 * 
	 * // Comments và cách dòng (Dòng trống) if(line.isEmpty() || line.startsWith("#")) { continue; }
	 * 
	 * // Header if(line.startsWith("[") && line.endsWith("]")) { currentSection = line.substring(1,
	 * line.length() - 1); }
	 * 
	 * // Key value để lấy từ file Config else { String[] parts = line.split("=", 2); if(parts.length ==
	 * 2) { String key = parts[0].trim(); String value = parts[1].trim(); configMap.put(key, value); } }
	 * } } catch (IOException e) { e.printStackTrace(); } return configMap; }
	 */

}