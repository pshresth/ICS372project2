import java.io.*;
import java.util.*;

// This is the main class

public class Driver {
	private static String configFile = "src\\ConfigurationFile.txt";
	private static int fridgeLow;
	private static int fridgeHigh;
	private static int freezerLow;
	private static int freezerHigh;
	private static int roomLow;
	private static int roomHigh;
	private static int fridgeRateLossDoorClosed;
	private static int fridgeRateLossDoorOpen;
	private static int freezerRateLossDoorClosed;
	private static int freezerRateLossDoorOpen;
	private static int fridgeCompressorStartDiff;
	private static int freezerCompressorStartDiff;
	private static int fridgeCoolRate;
	private static int freezerCoolRate;

	public static void main(String[] args) throws Exception {
		ReadConfigurationFromFile(configFile);
		//System.out.println(fridgeLow);
		RefrigeratorDisplay display = new GUIDisplay();
		RefrigeratorUnit fridge = new Fridge(display, fridgeLow, fridgeHigh, fridgeRateLossDoorClosed, fridgeRateLossDoorOpen, fridgeCompressorStartDiff, fridgeCoolRate);
		RefrigeratorUnit freezer = new Freezer(display, freezerLow, freezerHigh, freezerRateLossDoorClosed, freezerRateLossDoorOpen, freezerCompressorStartDiff, freezerCoolRate);
		
	}

	/**
	 * Read from the parameters frsom the configuration file
	 * 
	 * @throws Exception
	 */
	public static void ReadConfigurationFromFile(String configFile) throws Exception {
		try (BufferedReader buffer = new BufferedReader(new FileReader(configFile))) {
			String line;
			while ((line = buffer.readLine()) != null) {
				if (line.contains("FridgeLow")) {
					fridgeLow = ExtractInt(line);
				} else if (line.contains("FridgeHigh")) {
					fridgeHigh = ExtractInt(line);
				} else if (line.contains("FreezerLow")) {
					freezerLow = ExtractInt(line);
				} else if (line.contains("FreezerHigh")) {
					freezerHigh = ExtractInt(line);
				} else if (line.contains("RoomLow")) {
					roomLow = ExtractInt(line);
				} else if (line.contains("RoomHigh")) {
					roomHigh = ExtractInt(line);
				} else if (line.contains("FridgeRateLossDoorClosed")) {
					fridgeRateLossDoorClosed = ExtractInt(line);
				} else if (line.contains("FridgeRateLossDoorOpen")) {
					fridgeRateLossDoorOpen = ExtractInt(line);
				} else if (line.contains("FreezerRateLossDoorClosed")) {
					freezerRateLossDoorClosed = ExtractInt(line);
				} else if (line.contains("FreezerRateLossDoorOpen")) {
					freezerRateLossDoorOpen = ExtractInt(line);
				} else if (line.contains("FridgeCompressorStartDiff")) {
					fridgeCompressorStartDiff = ExtractInt(line);
				} else if (line.contains("FreezerCompressorStartDiff")) {
					freezerCompressorStartDiff = ExtractInt(line);
				} else if (line.contains("FridgeCoolRate")) {
					fridgeCoolRate = ExtractInt(line);
				} else if (line.contains("FreezerCoolRate")) {
					freezerCoolRate = ExtractInt(line);
				} else {
					throw new Exception("Unrecognized parameter: " + line.toString());
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	 public static int ExtractInt(String str) {
		 String intValue = str.replaceAll("[^0-9]", ""); 
		 return Integer.parseInt(intValue);
	 }
}
